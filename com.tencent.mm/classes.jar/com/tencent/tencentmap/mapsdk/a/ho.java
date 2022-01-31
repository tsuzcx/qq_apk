package com.tencent.tencentmap.mapsdk.a;

import java.util.Map;

public final class ho
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    er.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1);
  }
  
  public static boolean a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramInt == em.c())
    {
      if ((a) && (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString))))
      {
        a = false;
        return true;
      }
      if ((b) && ("HLHttpDirect".equals(paramString)))
      {
        paramString = (String)paramMap.get("B15");
        if ((!hq.a(paramString)) && (paramString.equals("app")))
        {
          b = false;
          return true;
        }
      }
    }
    return false;
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    er.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ho
 * JD-Core Version:    0.7.0.1
 */