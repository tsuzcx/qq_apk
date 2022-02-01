package com.tencent.sqlitelint.util;

import com.tencent.matrix.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SLog
{
  private static final String TAG = "SQLiteLint.SLog";
  private static volatile SLog mInstance = null;
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52957);
    getInstance().printLog(3, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(52957);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52954);
    getInstance().printLog(6, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(52954);
  }
  
  public static SLog getInstance()
  {
    AppMethodBeat.i(52952);
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new SLog();
      }
      SLog localSLog = mInstance;
      AppMethodBeat.o(52952);
      return localSLog;
    }
    finally
    {
      AppMethodBeat.o(52952);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52956);
    getInstance().printLog(4, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(52956);
  }
  
  public static native void nativeSetLogger(int paramInt);
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52958);
    getInstance().printLog(2, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(52958);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52955);
    getInstance().printLog(5, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(52955);
  }
  
  public void printLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(52953);
    switch (paramInt)
    {
    }
    try
    {
      c.i(paramString1, paramString2, new Object[0]);
      AppMethodBeat.o(52953);
      return;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("printLog ex ").append(paramString1.getMessage());
      AppMethodBeat.o(52953);
    }
    c.v(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52953);
    return;
    c.d(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52953);
    return;
    c.i(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52953);
    return;
    c.w(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52953);
    return;
    c.e(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52953);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SLog
 * JD-Core Version:    0.7.0.1
 */