package com.yrShin.controller;

import com.yrShin.model.FirstArray;
import com.yrShin.model.SecondArr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    @ResponseBody
    public String apiRoot() {
        //아래 범위 주석은 2중 리스트 혹은 2중 맵
        //현재 활성화된 코드는 리스트나 맵
        double[] firArr = FirstArray.MakeArray();
        double[] secArr = SecondArr.MakeArray(firArr);
        double[] thiArr = {1,2,0,0,3,4,0,0,5,6,0,0};
        double[] fourArr = {0,0,-1,-2,0,0,-3,-4,0,0,-5,-6};

        //List
        ArrayList<double[]> list = new ArrayList<double[]>();
        list.add(firArr);
        list.add(secArr);
        list.add(thiArr);
        list.add(fourArr);

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(double[] values : list){
            JSONArray childJArray = new JSONArray();
            for(double value : values){
                childJArray.add(value);
            }
            Object objChild = childJArray;
            jsonArray.add(objChild);
        }

        Object obj = jsonArray;
        jsonObject.put("resultSet", jsonArray);

        String json = jsonObject.toJSONString();
        return json;
    }

    @RequestMapping(
            value = "/api1",
            method = RequestMethod.GET)
    @ResponseBody
    public String api1(
            @RequestParam("para1") String _para1,
            @RequestParam("para2") String _para2) {
        return "api test, /api1";
    }
}