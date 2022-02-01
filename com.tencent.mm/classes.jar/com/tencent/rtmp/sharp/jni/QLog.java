package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(13901);
    TXCLog.d(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13901);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(13902);
    TXCLog.d(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13902);
  }
  
  public static void dumpCacheToFile() {}
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(13895);
    TXCLog.e(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13895);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(13896);
    e(paramString1, paramInt, paramString2);
    AppMethodBeat.o(13896);
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
    AppMethodBeat.i(13894);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    AppMethodBeat.o(13894);
    return paramThrowable;
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(13899);
    TXCLog.i(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13899);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(13900);
    TXCLog.i(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13900);
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
    AppMethodBeat.i(13897);
    TXCLog.w(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13897);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(13898);
    TXCLog.w(paramString1, "[" + getReportLevel(paramInt) + "]" + paramString2);
    AppMethodBeat.o(13898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.QLog
 * JD-Core Version:    0.7.0.1
 */