package com.tencent.sqlitelint.util;

import com.tencent.matrix.d.b;

public class SLog
{
  private static final String TAG = "SQLiteLint.SLog";
  private static volatile SLog mInstance = null;
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getInstance().printLog(3, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getInstance().printLog(6, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static SLog getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new SLog();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getInstance().printLog(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static native void nativeSetLogger(int paramInt);
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getInstance().printLog(2, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    getInstance().printLog(5, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void printLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
      try
      {
        b.i(paramString1, paramString2, new Object[0]);
        return;
      }
      catch (Throwable paramString1)
      {
        new StringBuilder("printLog ex ").append(paramString1.getMessage());
        return;
      }
      b.v(paramString1, paramString2, new Object[0]);
      return;
    case 3: 
      b.d(paramString1, paramString2, new Object[0]);
      return;
    case 4: 
      b.i(paramString1, paramString2, new Object[0]);
      return;
    case 5: 
      b.w(paramString1, paramString2, new Object[0]);
      return;
    }
    b.e(paramString1, paramString2, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SLog
 * JD-Core Version:    0.7.0.1
 */