package com.tencent.mm.plugin.rubbishbin;

public abstract class JNIExceptionHandler
{
  public static JNIExceptionHandler INSTANCE = null;
  private static boolean libLoaded = false;
  
  public static void init()
  {
    if (!libLoaded)
    {
      System.loadLibrary("rubbishbin");
      libLoaded = true;
    }
    initSigHandler();
  }
  
  public static native void initSigHandler();
  
  public static void invoke_crash()
  {
    if (!libLoaded)
    {
      System.loadLibrary("rubbishbin");
      libLoaded = true;
    }
    testCrashAA();
  }
  
  public static native String testCrashAA();
  
  public abstract void onException(int paramInt, String paramString);
  
  public abstract void setReportExecutionTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler
 * JD-Core Version:    0.7.0.1
 */