package com.tencent.ttpic.baseutils;

import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogUtils
{
  private static boolean isLogcatEnable;
  private static long mInitTime;
  private static long mLastTime;
  private static LruCache<String, Long> mTimeStampMap;
  private static final Configuration sConfiguration;
  
  static
  {
    AppMethodBeat.i(49786);
    isLogcatEnable = false;
    sConfiguration = new Configuration();
    mTimeStampMap = new LruCache(1000);
    AppMethodBeat.o(49786);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49772);
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
    AppMethodBeat.o(49772);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(49774);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49774);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49773);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49773);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49779);
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
    AppMethodBeat.o(49779);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(49781);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49781);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49780);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49780);
  }
  
  public static void e(String paramString, Throwable paramThrowable) {}
  
  public static void e(Throwable paramThrowable)
  {
    AppMethodBeat.i(49778);
    e("", paramThrowable.getMessage());
    AppMethodBeat.o(49778);
  }
  
  private static String generateLogPrefix(String paramString)
  {
    AppMethodBeat.i(49785);
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(49785);
      return "";
    }
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (localStackTraceElement.getClassName().endsWith(paramString)))
      {
        paramString = "(" + Thread.currentThread().getName() + ")" + localStackTraceElement.getClassName() + "(" + localStackTraceElement.getLineNumber() + ")[" + localStackTraceElement.getMethodName() + "]: ";
        AppMethodBeat.o(49785);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(49785);
    return "";
  }
  
  private static String getFormatMessage(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49784);
    String str = paramString2;
    if (paramVarArgs != null) {}
    try
    {
      str = String.format(sConfiguration.locale, paramString2, paramVarArgs);
      paramString1 = generateLogPrefix(paramString1) + str;
      AppMethodBeat.o(49784);
      return paramString1;
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
    AppMethodBeat.i(49769);
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
    AppMethodBeat.o(49769);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(49771);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49771);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49770);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49770);
  }
  
  private static long initTime()
  {
    AppMethodBeat.i(49783);
    long l = SystemClock.currentThreadTimeMillis();
    mLastTime = l;
    mInitTime = l;
    l = mLastTime;
    AppMethodBeat.o(49783);
    return l;
  }
  
  public static void printTime(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49782);
    if ((!isLogcatEnable) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(49782);
      return;
    }
    long l1;
    if (paramString2.contains("BEGIN"))
    {
      l1 = System.currentTimeMillis();
      mTimeStampMap.put(paramString1, Long.valueOf(l1));
      i("LOG_PERFORMANCE_".concat(String.valueOf(paramString1)), paramString2);
      AppMethodBeat.o(49782);
      return;
    }
    if (paramString2.contains("END"))
    {
      Long localLong = (Long)mTimeStampMap.get(paramString1);
      if (localLong != null) {}
      for (l1 = localLong.longValue();; l1 = System.currentTimeMillis())
      {
        long l2 = System.currentTimeMillis();
        i("LOG_PERFORMANCE_".concat(String.valueOf(paramString1)), paramString2 + " = " + (l2 - l1));
        AppMethodBeat.o(49782);
        return;
      }
    }
    i("LOG_PERFORMANCE_".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(49782);
  }
  
  public static void setLogcatEnable(boolean paramBoolean)
  {
    isLogcatEnable = paramBoolean;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49766);
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
    AppMethodBeat.o(49766);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(49768);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49768);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49767);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49767);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49775);
    if (isLogcatEnable)
    {
      paramString1 = Thread.currentThread().getStackTrace()[3];
      paramString1 = "(" + Thread.currentThread().getName() + ")" + paramString1.getClassName() + "(" + paramString1.getLineNumber() + ")[" + paramString1.getMethodName() + "]";
      new StringBuilder().append(paramString1).append(": ").append(paramString2);
    }
    AppMethodBeat.o(49775);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(49777);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49777);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(49776);
    if (isLogcatEnable) {
      getFormatMessage(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(49776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.LogUtils
 * JD-Core Version:    0.7.0.1
 */