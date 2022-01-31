package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Auth
{
  private static final String DAT_SUFFIX = "SDK.dat";
  private static final String LICENCE_SUFFIX = "SDK.licence";
  private static final String SDK_NAME = "YoutuFaceTrack";
  private static final String SDK_PREFIX = "YT";
  private static final String TAG = "log_print_java";
  private static long handle = 0L;
  private static boolean isReportStarted = false;
  private static String licenceStr = "";
  private static HttpUtil.HttpResponseListener mListener = new Auth.3();
  private static Timer timerFlush;
  private static Timer timerReport;
  private long nativePtr;
  
  public static boolean check()
  {
    return nativeCheck(handle);
  }
  
  private static native int getCurrentAuthStatus(long paramLong);
  
  public static long getHandle()
  {
    return handle;
  }
  
  private static native int getIsNeedReport(long paramLong);
  
  private static native String getReportContent();
  
  public static int init(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    Log.d("log_print_java", "start init");
    String str = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
    Log.d("log_print_java", "path: " + str);
    handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), str);
    Log.d("log_print_java", "handleinit: " + handle);
    if (getIsNeedReport(handle) == 0) {
      Log.d("log_print_java", "no need to report");
    }
    for (;;)
    {
      return getCurrentAuthStatus(handle);
      Log.d("log_print_java", "need report");
      startTimer();
    }
  }
  
  private static boolean isInMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeFlush();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2);
  
  private static native int nativePreInitAndCheck(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, String paramString3);
  
  private static native long nativeUpdateFromServer(long paramLong, String paramString);
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    licenceStr = paramString;
    try
    {
      paramString = paramString.getBytes();
      int i = paramString.length;
      if (i <= 0) {
        throw new IOException("licence error");
      }
      String str1 = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
      String str2 = paramContext.getPackageName();
      paramContext = StatisticsUtils.getDeviceUid(paramContext);
      Log.d("log_print_java", "Package name: " + str2);
      Log.d("log_print_java", "Device id: " + paramContext);
      i = nativePreInitAndCheck(paramString, i, str2, paramContext, str1);
      return i;
    }
    catch (IOException paramContext) {}
    return -1;
  }
  
  public static void report(String paramString)
  {
    if (isInMainThread())
    {
      new Thread(new Auth.4(paramString)).start();
      return;
    }
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", paramString, mListener);
      return;
    }
    catch (IOException paramString) {}
  }
  
  private static void startTimer()
  {
    Log.d("log_print_java", "start timer");
    if (isReportStarted) {
      return;
    }
    Object localObject = new Auth.1();
    Timer localTimer = new Timer(true);
    timerReport = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    localObject = new Auth.2();
    localTimer = new Timer(true);
    timerFlush = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    isReportStarted = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */