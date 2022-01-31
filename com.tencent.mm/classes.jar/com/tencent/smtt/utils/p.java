package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class p
{
  private static Class a;
  private static Method b;
  
  static
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      a = localClass;
      b = localClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return b(paramString1, paramString2);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if ((a == null) || (b == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)b.invoke(a, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */