package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  public static final int LOGGER_DEFAULT = 1;
  public static final int LOGGER_NONE = 0;
  private static LogCallback mCallback = null;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12716);
    println(3, paramString1, paramString2);
    AppMethodBeat.o(12716);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12722);
    println(3, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12722);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12713);
    println(6, paramString1, paramString2);
    AppMethodBeat.o(12713);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12719);
    println(6, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12719);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12712);
    println(7, paramString1, paramString2);
    AppMethodBeat.o(12712);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12718);
    println(7, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12718);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12715);
    println(4, paramString1, paramString2);
    AppMethodBeat.o(12715);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12721);
    println(4, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12721);
  }
  
  private static native void nativePrintLn(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeSetLogger(int paramInt, LogCallback paramLogCallback);
  
  public static void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(12711);
    if (mCallback != null)
    {
      mCallback.println(paramInt, paramString1, paramString2);
      AppMethodBeat.o(12711);
      return;
    }
    nativePrintLn(paramInt, paramString1, paramString2);
    AppMethodBeat.o(12711);
  }
  
  public static void setLogger(int paramInt)
  {
    AppMethodBeat.i(12709);
    mCallback = null;
    nativeSetLogger(paramInt, null);
    AppMethodBeat.o(12709);
  }
  
  public static void setLogger(LogCallback paramLogCallback)
  {
    AppMethodBeat.i(12710);
    mCallback = paramLogCallback;
    nativeSetLogger(-1, paramLogCallback);
    AppMethodBeat.o(12710);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12717);
    println(2, paramString1, paramString2);
    AppMethodBeat.o(12717);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12723);
    println(2, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12723);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12714);
    println(5, paramString1, paramString2);
    AppMethodBeat.o(12714);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(12720);
    println(5, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(12720);
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