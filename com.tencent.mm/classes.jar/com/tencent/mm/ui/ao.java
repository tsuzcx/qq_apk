package com.tencent.mm.ui;

import android.util.Log;

public final class ao
{
  private static a uRs;
  private static a uRt;
  
  static
  {
    a local1 = new a() {};
    uRs = local1;
    uRt = local1;
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (uRt != null)
    {
      paramVarArgs = String.format(paramString, paramVarArgs);
      paramString = paramVarArgs;
      if (paramVarArgs == null) {
        paramString = "";
      }
      new StringBuilder().append(paramString).append("  ").append(Log.getStackTraceString(paramThrowable));
    }
  }
  
  public static void r(String paramString, Object... paramVarArgs)
  {
    if (uRt != null) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public static void s(String paramString, Object... paramVarArgs)
  {
    if (uRt != null) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public static void t(String paramString, Object... paramVarArgs)
  {
    if (uRt != null) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public static void u(String paramString, Object... paramVarArgs)
  {
    if (uRt != null) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (uRt != null) {
      String.format(paramString, paramVarArgs);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ao
 * JD-Core Version:    0.7.0.1
 */