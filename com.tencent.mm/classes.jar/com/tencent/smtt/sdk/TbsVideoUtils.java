package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static bg a = null;
  
  private static void a(Context paramContext)
  {
    Object localObject = null;
    try
    {
      if (a == null)
      {
        o.a(true).a(paramContext, false, false, null);
        bi localbi = o.a(true).a();
        paramContext = localObject;
        if (localbi != null) {
          paramContext = localbi.b();
        }
        if (paramContext != null) {
          a = new bg(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    a(paramContext);
    if (a != null) {
      return a.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */