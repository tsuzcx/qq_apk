package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah;

public class jq
{
  public static String a()
  {
    AppMethodBeat.i(148722);
    String str = d();
    if (str.equals("didi"))
    {
      if (ah.a() == 1)
      {
        AppMethodBeat.o(148722);
        return "https://ddsdk.vectors.map.qq.com";
      }
      AppMethodBeat.o(148722);
      return "https://ddsdk.vectors2.map.qq.com";
    }
    if (str.equals("tencentmap"))
    {
      AppMethodBeat.o(148722);
      return "https://mapvectors.map.qq.com";
    }
    AppMethodBeat.o(148722);
    return "https://vectorsdk.map.qq.com";
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(148724);
    String str = d();
    if ((!str.equals("didi")) && (!str.equals("tencentmap")) && (paramString.contains("indoor_map")))
    {
      paramString = paramString.replace("https://vectorsdk.map.qq.com/indoor_map?", "https://mapvectors.map.qq.com/indoormap2?");
      paramString = paramString + "&apiKey=" + ka.a;
      AppMethodBeat.o(148724);
      return paramString;
    }
    AppMethodBeat.o(148724);
    return paramString;
  }
  
  public static String b()
  {
    AppMethodBeat.i(148723);
    if (d().equals("didi"))
    {
      AppMethodBeat.o(148723);
      return "/mobile_newmap";
    }
    AppMethodBeat.o(148723);
    return "/mvd_map";
  }
  
  public static String c()
  {
    AppMethodBeat.i(148725);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://closedroadvector.map.qq.com/closed_road_v2?");
    ((StringBuilder)localObject).append("iszip=true");
    ((StringBuilder)localObject).append("&imei=" + ka.a());
    ((StringBuilder)localObject).append("&pf=android");
    ((StringBuilder)localObject).append("&sdkversion=4.2.3");
    ((StringBuilder)localObject).append("&p=sdk");
    ((StringBuilder)localObject).append("&nettype=" + ka.b());
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(148725);
    return localObject;
  }
  
  private static String d()
  {
    return "wechat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jq
 * JD-Core Version:    0.7.0.1
 */