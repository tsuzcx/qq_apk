package io.flutter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  public static int ASSERT = 7;
  public static int DEBUG = 3;
  public static int ERROR = 6;
  public static int INFO = 4;
  public static int VERBOSE = 2;
  public static int WARN = 5;
  private static int logLevel = 3;
  
  public static void d(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void e(String paramString1, String paramString2) {}
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void i(String paramString1, String paramString2) {}
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void println(int paramInt, String paramString1, String paramString2) {}
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
  }
  
  public static void v(String paramString1, String paramString2) {}
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void w(String paramString1, String paramString2) {}
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void wtf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189643);
    android.util.Log.wtf(paramString1, paramString2);
    AppMethodBeat.o(189643);
  }
  
  public static void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(189656);
    android.util.Log.wtf(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(189656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.Log
 * JD-Core Version:    0.7.0.1
 */