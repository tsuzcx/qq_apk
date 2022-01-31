package com.tencent.tencentmap.mapsdk.a;

import java.util.Locale;

public final class cy
{
  public static boolean a = false;
  public static boolean b = false;
  
  private static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1; (i == 0) || (paramString2 == null) || (paramVarArgs == null) || (paramVarArgs.length == 0); i = 0) {
      return;
    }
    String.format(Locale.US, paramString2, paramVarArgs);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1; (i == 0) || (paramString == null) || (paramVarArgs == null) || (paramVarArgs.length == 0); i = 0) {
      return;
    }
    String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && ((paramThrowable instanceof Throwable))) {
      if (!a) {
        break label24;
      }
    }
    label24:
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    d(paramThrowable.getMessage(), new Object[0]);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1; (i == 0) || (paramString == null) || (paramVarArgs == null) || (paramVarArgs.length == 0); i = 0) {
      return;
    }
    String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if ((paramString == null) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((paramString == null) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_api", paramString, paramVarArgs);
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_buffer", paramString, paramVarArgs);
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_db", paramString, paramVarArgs);
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_upload", paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cy
 * JD-Core Version:    0.7.0.1
 */