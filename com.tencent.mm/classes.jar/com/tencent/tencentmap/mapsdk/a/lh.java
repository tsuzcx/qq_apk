package com.tencent.tencentmap.mapsdk.a;

public class lh
{
  public static String a()
  {
    String str = d();
    if (str.equals("didi"))
    {
      if (ah.a() == 1) {
        return "https://ddsdk.vectors.map.qq.com";
      }
      return "https://ddsdk.vectors2.map.qq.com";
    }
    if (str.equals("tencentmap")) {
      return "https://mapvectors.map.qq.com";
    }
    return "https://vectorsdk.map.qq.com";
  }
  
  public static String a(String paramString)
  {
    String str2 = d();
    String str1 = paramString;
    if (!str2.equals("didi"))
    {
      str1 = paramString;
      if (!str2.equals("tencentmap"))
      {
        str1 = paramString;
        if (paramString.contains("indoor_map"))
        {
          paramString = paramString.replace("https://vectorsdk.map.qq.com/indoor_map?", "https://mapvectors.map.qq.com/indoormap2?");
          str1 = paramString + "&apiKey=" + lq.a;
        }
      }
    }
    return str1;
  }
  
  public static String b()
  {
    if (d().equals("didi")) {
      return "/mobile_newmap";
    }
    return "/mvd_map";
  }
  
  public static String c()
  {
    if (d().equals("didi")) {
      return "1HV13IK65T1XH392";
    }
    return "0M3009PNO62FLOQC";
  }
  
  private static String d()
  {
    return "sdk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lh
 * JD-Core Version:    0.7.0.1
 */