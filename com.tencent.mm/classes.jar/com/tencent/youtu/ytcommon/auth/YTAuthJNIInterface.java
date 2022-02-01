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
    AppMethodBeat.i(73364);
    handle = 0L;
    isReportStarted = false;
    licenceStr = "";
    VERSION = "1.2";
    mListener = new HttpUtil.HttpResponseListener()
    {
      public final void onFail(int paramAnonymousInt)
      {
        AppMethodBeat.i(73353);
        try
        {
          YTLogger.d("log_print_java", "http request error : ".concat(String.valueOf(paramAnonymousInt)));
          YTLogger.d("log_print_java", "handle: " + YTAuthJNIInterface.handle);
          YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, null);
          AppMethodBeat.o(73353);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(73353);
        }
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(73352);
        try
        {
          YTLogger.d("log_print_java", "response: ".concat(String.valueOf(paramAnonymousString)));
          YTLogger.d("log_print_java", "handle: " + YTAuthJNIInterface.handle);
          YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, paramAnonymousString);
          AppMethodBeat.o(73352);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          AppMethodBeat.o(73352);
        }
      }
    };
    AppMethodBeat.o(73364);
  }
  
  public static boolean check()
  {
    AppMethodBeat.i(73358);
    boolean bool = nativeCheck(handle);
    YTLogger.d("sdk", "--------------check");
    AppMethodBeat.o(73358);
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
    AppMethodBeat.i(73357);
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
      AppMethodBeat.o(73357);
      return paramInt;
      YTLogger.d("log_print_java", "need report");
      startTimer();
    }
  }
  
  private static boolean isInMainThread()
  {
    AppMethodBeat.i(73359);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(73359);
      return true;
    }
    AppMethodBeat.o(73359);
    return false;
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeFlush();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2);
  
  private static native int nativePreInitAndCheck(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, String paramString3);
  
  private static native long nativeUpdateFromServer(long paramLong, String paramString);
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73355);
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
        AppMethodBeat.o(73355);
        throw paramContext;
      }
    }
    catch (IOException paramContext) {}
    for (;;)
    {
      AppMethodBeat.o(73355);
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
    AppMethodBeat.i(73360);
    if (isInMainThread())
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73354);
          try
          {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", this.val$data, YTAuthJNIInterface.mListener);
            AppMethodBeat.o(73354);
            return;
          }
          catch (IOException localIOException)
          {
            AppMethodBeat.o(73354);
          }
        }
      }).start();
      AppMethodBeat.o(73360);
      return;
    }
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", paramString, mListener);
      AppMethodBeat.o(73360);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(73360);
    }
  }
  
  private static void startTimer()
  {
    AppMethodBeat.i(73356);
    YTLogger.d("log_print_java", "start timer");
    if (isReportStarted)
    {
      AppMethodBeat.o(73356);
      return;
    }
    Object localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(73350);
        String str = YTAuthJNIInterface.access$000();
        if (str != "") {
          YTAuthJNIInterface.report(str);
        }
        AppMethodBeat.o(73350);
      }
    };
    Timer localTimer = new Timer(true);
    timerReport = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(73351);
        YTLogger.d("log_print_java", "flush in java ");
        YTAuthJNIInterface.access$100();
        AppMethodBeat.o(73351);
      }
    };
    localTimer = new Timer(true);
    timerFlush = localTimer;
    localTimer.schedule((TimerTask)localObject, 600000L, 600000L);
    isReportStarted = true;
    AppMethodBeat.o(73356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface
 * JD-Core Version:    0.7.0.1
 */