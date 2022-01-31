package com.tencent.util;

import android.util.Log;
import com.tencent.view.b;
import java.util.HashMap;

public final class g
{
  public static boolean xcF = false;
  private static HashMap<String, Long> xcG = new HashMap();
  private static f xcH = null;
  
  public static int a(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (b.xdc)
    {
      paramObject = cu(paramObject);
      if (xcH == null) {
        break label19;
      }
    }
    label19:
    while (!b.xdc) {
      return 0;
    }
    return Log.e(paramObject, paramString, paramThrowable);
  }
  
  private static String cu(Object paramObject)
  {
    if (paramObject == null) {
      return "filter process";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.getClass().getSimpleName();
  }
  
  public static int g(Object paramObject, String paramString)
  {
    if (b.xdc)
    {
      paramObject = cu(paramObject);
      if (xcH == null) {
        break label19;
      }
    }
    label19:
    while (!b.xdc) {
      return 0;
    }
    return Log.i(paramObject, paramString);
  }
  
  public static int h(Object paramObject, String paramString)
  {
    if (b.xdc)
    {
      paramObject = cu(paramObject);
      if (xcH == null) {
        break label19;
      }
    }
    label19:
    while (!b.xdc) {
      return 0;
    }
    return Log.d(paramObject, paramString);
  }
  
  public static int i(Object paramObject, String paramString)
  {
    if (b.xdc)
    {
      paramObject = cu(paramObject);
      if (xcH == null) {
        break label19;
      }
    }
    label19:
    while (!b.xdc) {
      return 0;
    }
    return Log.e(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.util.g
 * JD-Core Version:    0.7.0.1
 */