package com.tencent.mm.plugin.rubbishbin;

public abstract class JNIExceptionHandler
{
  public static JNIExceptionHandler INSTANCE = null;
  private static boolean libLoaded = false;
  private byte _hellAccFlag_;
  
  public static void init()
  {
    if (!libLoaded)
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("rubbishbin");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandler", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandler", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      libLoaded = true;
    }
    initSigHandler();
  }
  
  public static native void initSigHandler();
  
  public static void invoke_crash()
  {
    if (!libLoaded)
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("rubbishbin");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandler", "invoke_crash", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandler", "invoke_crash", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      libLoaded = true;
    }
    testCrashAA();
  }
  
  public static native String testCrashAA();
  
  public abstract void onException(int paramInt, String paramString);
  
  public abstract void setReportExecutionTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.JNIExceptionHandler
 * JD-Core Version:    0.7.0.1
 */