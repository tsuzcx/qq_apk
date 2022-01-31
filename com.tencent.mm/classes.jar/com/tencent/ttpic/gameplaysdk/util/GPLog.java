package com.tencent.ttpic.gameplaysdk.util;

public class GPLog
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!isLoggable(3)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public static final void debug(int paramInt, String paramString1, String paramString2)
  {
    if (!isLoggable(3)) {}
    while (paramString2 != null) {
      return;
    }
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!isLoggable(3)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!isLoggable(3)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public static final boolean isLoggable(int paramInt)
  {
    return false;
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!isLoggable(3)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public static final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!isLoggable(3)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.util.GPLog
 * JD-Core Version:    0.7.0.1
 */