package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class q
{
  private static Class a;
  private static Method b;
  
  static
  {
    AppMethodBeat.i(65285);
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      a = localClass;
      b = localClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      AppMethodBeat.o(65285);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(65285);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65283);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(65283);
      return paramString2;
    }
    paramString1 = b(paramString1, paramString2);
    AppMethodBeat.o(65283);
    return paramString1;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65284);
    if ((a == null) || (b == null))
    {
      AppMethodBeat.o(65284);
      return paramString2;
    }
    try
    {
      paramString1 = (String)b.invoke(a, new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(65284);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1 = paramString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.utils.q
 * JD-Core Version:    0.7.0.1
 */