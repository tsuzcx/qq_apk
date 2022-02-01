package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  public static final int LOGGER_DEFAULT = 1;
  public static final int LOGGER_NONE = 0;
  private static LogCallback mCallback = null;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3402);
    println(3, paramString1, paramString2);
    AppMethodBeat.o(3402);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3408);
    println(3, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3408);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3399);
    println(6, paramString1, paramString2);
    AppMethodBeat.o(3399);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3405);
    println(6, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3405);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3398);
    println(7, paramString1, paramString2);
    AppMethodBeat.o(3398);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3404);
    println(7, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3404);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3401);
    println(4, paramString1, paramString2);
    AppMethodBeat.o(3401);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3407);
    println(4, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3407);
  }
  
  private static native void nativePrintLn(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeSetLogger(int paramInt, LogCallback paramLogCallback);
  
  public static void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(3397);
    if (mCallback != null)
    {
      mCallback.println(paramInt, paramString1, paramString2);
      AppMethodBeat.o(3397);
      return;
    }
    nativePrintLn(paramInt, paramString1, paramString2);
    AppMethodBeat.o(3397);
  }
  
  public static void setLogger(int paramInt)
  {
    AppMethodBeat.i(3395);
    mCallback = null;
    nativeSetLogger(paramInt, null);
    AppMethodBeat.o(3395);
  }
  
  public static void setLogger(LogCallback paramLogCallback)
  {
    AppMethodBeat.i(3396);
    mCallback = paramLogCallback;
    nativeSetLogger(-1, paramLogCallback);
    AppMethodBeat.o(3396);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3403);
    println(2, paramString1, paramString2);
    AppMethodBeat.o(3403);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3409);
    println(2, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3409);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3400);
    println(5, paramString1, paramString2);
    AppMethodBeat.o(3400);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(3406);
    println(5, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(3406);
  }
  
  public static abstract interface LogCallback
  {
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.Log
 * JD-Core Version:    0.7.0.1
 */