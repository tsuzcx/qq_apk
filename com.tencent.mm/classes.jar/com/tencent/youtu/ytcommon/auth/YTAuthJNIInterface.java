package com.tencent.youtu.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class YTAuthJNIInterface
{
  private static final String DAT_SUFFIX = "SDK.dat";
  private static final String LICENCE_SUFFIX = "SDK.licence";
  private static final String SDK_NAME = "YoutuFaceTrack";
  private static final String SDK_PREFIX = "YT";
  private static final String TAG = "log_print_java";
  private static String VERSION;
  private static long handle;
  private static boolean isReportStarted;
  private static String licenceStr;
  private static HttpUtil.HttpResponseListener mListener;
  private static Timer timerFlush;
  private static Timer timerReport;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(118077);
    handle = 0L;
    isReportStarted = false;
    licenceStr = "";
    VERSION = "1.2";
    mListener = new YTAuthJNIInterface.3();
    AppMethodBeat.o(118077);
  }
  
  public static boolean check()
  {
    AppMethodBeat.i(118071);
    boolean bool = nativeCheck(handle);
    YTLogger.d("sdk", "--------------check");
    AppMethodBeat.o(118071);
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
    AppMethodBeat.i(118070);
    YTLogger.d("log_print_java", "start init");
    String str = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
    YTLogger.d("log_print_java", "path: ".concat(String.valueOf(str)));
    handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), str);
    YTLogger.d("log_print_java", "handleinit: " + handle);
    if (getIsNeedReport(handle) == 0) {
      YTLogger.d("log_print_java", "no need to report");
    }
    for (;;)
    {
      paramInt = getCurrentAuthStatus(handle);
      AppMethodBeat.o(118070);
      return paramInt;
      YTLogger.d("log_print_java", "need report");
      startTimer();
    }
  }
  
  private static boolean isInMainThread()
  {
    AppMethodBeat.i(118072);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(118072);
      return true;
    }
    AppMethodBeat.o(118072);
    return false;
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeFlush();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2);
  
  private static native int nativePreInitAndCheck(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, String paramString3);
  
  private static native long nativeUpdateFromServer(long paramLong, String paramString);
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(118068);
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
        AppMethodBeat.o(118068);
        throw paramContext;
      }
    }
    catch (IOException paramContext) {}
    for (;;)
    {
      AppMethodBeat.o(118068);
      return i;
      String str1 = paramContext.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
      String str2 = paramContext.getPackageName();
      paramContext = StatisticsUtils.getDeviceUid(paramContext);
      YTLogger.d("log_print_java", "Package name: ".concat(String.valueOf(str2)));
      YTLogger.d("log_print_java", "Device id: ".concat(String.valueOf(paramContext)));
      j = nativePreInitAndCheck(paramString, j, str2, paramContext, str1);
      i = j;
    }
  }
  
  public static void report(String paramString)
  {
    AppMethodBeat.i(118073);
    if (isInMainThread())
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(118067);
          try
          {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", this.val$data, YTAuthJNIInterface.mListener);
            AppMethodBeat.o(118067);
            return;
          }
          catch (IOException localIOException)
          {
            AppMethodBeat.o(118067);
          }
        }
      }).start();
      AppMethodBeat.o(118073);
      return;
    }
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", paramString, mListener);
      AppMethodBeat.o(118073);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(118073);
    }
  }
  
  private static void startTimer()
  {
    AppMethodBeat.i(118069);
    YTLogger.d("log_print_java", "start timer");
    if (isReportStarted)
    {
      AppMethodBeat.o(118069);
      return;
    }
    Object localObject = new YTAuthJNIInterface.1();
    Timer localTimer = new Timer(true);
    timerReport = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    localObject = new YTAuthJNIInterface.2();
    localTimer = new Timer(true);
    timerFlush = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    isReportStarted = true;
    AppMethodBeat.o(118069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface
 * JD-Core Version:    0.7.0.1
 */