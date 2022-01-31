package com.tencent.wework.api.utils;

public class Log
{
  private static int wJC = 8;
  private static Log.ILogger xgg = new Log.WWAPILogger(new Log.LogcatLogger((byte)0));
  
  public static void d(String paramString1, String paramString2)
  {
    if (wJC <= 3) {
      xgg.a(3, paramString1, paramString2, null);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (wJC <= 6) {
      xgg.a(6, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (wJC <= 4) {
      xgg.a(4, paramString1, paramString2, null);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (wJC <= 5) {
      xgg.a(5, paramString1, paramString2, null);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (wJC <= 5) {
      xgg.a(5, paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.utils.Log
 * JD-Core Version:    0.7.0.1
 */