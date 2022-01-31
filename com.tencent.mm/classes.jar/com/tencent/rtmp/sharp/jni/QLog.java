package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;

public class QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final String ERR_KEY = "qq_error|";
  public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
  public static final String TAG_REPORTLEVEL_COLORUSER = "W";
  public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
  public static final String TAG_REPORTLEVEL_USER = "E";
  public static final int USR = 1;
  public static String sBuildNumber = "";
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    TXCLog.d(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    TXCLog.d(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void dumpCacheToFile() {}
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    TXCLog.e(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    e(paramString1, paramInt, paramString2);
  }
  
  public static String getReportLevel(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    TXCLog.i(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    TXCLog.i(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void init(Context paramContext) {}
  
  public static boolean isColorLevel()
  {
    return true;
  }
  
  public static boolean isDevelopLevel()
  {
    return true;
  }
  
  public static void p(String paramString1, String paramString2) {}
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    TXCLog.w(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    TXCLog.w(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.QLog
 * JD-Core Version:    0.7.0.1
 */