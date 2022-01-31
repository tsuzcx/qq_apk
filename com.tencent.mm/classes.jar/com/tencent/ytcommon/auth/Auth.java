package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static long handle;
  private static boolean isReportStarted;
  private static String licenceStr;
  private static HttpUtil.HttpResponseListener mListener;
  private static Timer timerFlush;
  private static Timer timerReport;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(15);
    handle = 0L;
    isReportStarted = false;
    licenceStr = "";
    mListener = new Auth.3();
    AppMethodBeat.o(15);
  }
  
  public static boolean check()
  {
    AppMethodBeat.i(9);
    boolean bool = nativeCheck(handle);
    AppMethodBeat.o(9);
    return bool;
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
    AppMethodBeat.i(8);
    Log.d("log_print_java", "start init");
    String str = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
    Log.d("log_print_java", "path: ".concat(String.valueOf(str)));
    handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), str);
    Log.d("log_print_java", "handleinit: " + handle);
    if (getIsNeedReport(handle) == 0) {
      Log.d("log_print_java", "no need to report");
    }
    for (;;)
    {
      paramInt = getCurrentAuthStatus(handle);
      AppMethodBeat.o(8);
      return paramInt;
      Log.d("log_print_java", "need report");
      startTimer();
    }
  }
  
  private static boolean isInMainThread()
  {
    AppMethodBeat.i(10);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(10);
      return true;
    }
    AppMethodBeat.o(10);
    return false;
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeFlush();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2);
  
  private static native int nativePreInitAndCheck(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, String paramString3);
  
  private static native long nativeUpdateFromServer(long paramLong, String paramString);
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(6);
    licenceStr = paramString;
    int i = -1;
    int j;
    try
    {
      paramString = paramString.getBytes();
      j = paramString.length;
      if (j <= 0)
      {
        paramContext = new IOException("licence error");
        AppMethodBeat.o(6);
        throw paramContext;
      }
    }
    catch (IOException paramContext) {}
    for (;;)
    {
      AppMethodBeat.o(6);
      return i;
      String str1 = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
      String str2 = paramContext.getPackageName();
      paramContext = StatisticsUtils.getDeviceUid(paramContext);
      Log.d("log_print_java", "Package name: ".concat(String.valueOf(str2)));
      Log.d("log_print_java", "Device id: ".concat(String.valueOf(paramContext)));
      j = nativePreInitAndCheck(paramString, j, str2, paramContext, str1);
      i = j;
    }
  }
  
  public static void report(String paramString)
  {
    AppMethodBeat.i(11);
    if (isInMainThread())
    {
      new Thread(new Auth.4(paramString)).start();
      AppMethodBeat.o(11);
      return;
    }
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", paramString, mListener);
      AppMethodBeat.o(11);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(11);
    }
  }
  
  private static void startTimer()
  {
    AppMethodBeat.i(7);
    Log.d("log_print_java", "start timer");
    if (isReportStarted)
    {
      AppMethodBeat.o(7);
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
    AppMethodBeat.o(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */