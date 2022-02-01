package com.tencent.mm.sdk.platformtools;

public class WeChatEnvironment
{
  private static boolean coolassistEnv = false;
  private static String debuggerApiLevel;
  private static boolean hasDebugger = false;
  private static boolean monkeyEnv;
  
  static
  {
    debuggerApiLevel = null;
    monkeyEnv = false;
  }
  
  public static String getDebuggerApiLevel()
  {
    return debuggerApiLevel;
  }
  
  public static boolean hasDebugger()
  {
    return hasDebugger;
  }
  
  public static boolean isCoolassistEnv()
  {
    return coolassistEnv;
  }
  
  public static boolean isMonkeyEnv()
  {
    return monkeyEnv;
  }
  
  public static void setCoolassistEnv(boolean paramBoolean)
  {
    coolassistEnv = paramBoolean;
  }
  
  public static void setDebuggerApiLevel(String paramString)
  {
    debuggerApiLevel = paramString;
  }
  
  public static void setHasDebugger(boolean paramBoolean)
  {
    hasDebugger = paramBoolean;
  }
  
  public static void setMonkeyEnv(boolean paramBoolean)
  {
    monkeyEnv = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatEnvironment
 * JD-Core Version:    0.7.0.1
 */