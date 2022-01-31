package com.tencent.ttpic.baseutils;

import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;

public class LogUtils
{
  private static boolean isLogcatEnable = false;
  private static long mInitTime;
  private static long mLastTime;
  private static LruCache<String, Long> mTimeStampMap = new LruCache(1000);
  private static final Configuration sConfiguration = new Configuration();
  
  public static void d(String paramString1, String paramString2)
  {
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable) {}
  
  public static void e(Throwable paramThrowable)
  {
    e("", paramThrowable.getMessage());
  }
  
  private static String generateLogPrefix(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return "";
    }
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (localStackTraceElement.getClassName().endsWith(paramString))) {
        return "(" + Thread.currentThread().getName() + ")" + localStackTraceElement.getClassName() + "(" + localStackTraceElement.getLineNumber() + ")[" + localStackTraceElement.getMethodName() + "]: ";
      }
      i += 1;
    }
    return "";
  }
  
  private static String getFormatMessage(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {}
    try
    {
      str = String.format(sConfiguration.locale, paramString2, paramVarArgs);
      return generateLogPrefix(paramString1) + str;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        str = paramString2;
      }
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  private static long initTime()
  {
    long l = SystemClock.currentThreadTimeMillis();
    mLastTime = l;
    mInitTime = l;
    return mLastTime;
  }
  
  public static void printTime(String paramString1, String paramString2)
  {
    if ((!isLogcatEnable) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    long l1;
    if (paramString2.contains("BEGIN"))
    {
      l1 = System.currentTimeMillis();
      mTimeStampMap.put(paramString1, Long.valueOf(l1));
      i("LOG_PERFORMANCE_" + paramString1, paramString2);
      return;
    }
    if (paramString2.contains("END"))
    {
      Long localLong = (Long)mTimeStampMap.get(paramString1);
      if (localLong != null) {}
      for (l1 = localLong.longValue();; l1 = System.currentTimeMillis())
      {
        long l2 = System.currentTimeMillis();
        i("LOG_PERFORMANCE_" + paramString1, paramString2 + " = " + (l2 - l1));
        return;
      }
    }
    i("LOG_PERFORMANCE_" + paramString1, paramString2);
  }
  
  public static void setLogcatEnable(boolean paramBoolean)
  {
    isLogcatEnable = paramBoolean;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.LogUtils
 * JD-Core Version:    0.7.0.1
 */