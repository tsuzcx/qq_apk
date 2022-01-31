package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class YTAGReflectLiveCheckInterface
{
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.1.0";
  private static YTAGReflectLiveCheckInterface.LightLiveCheckResult mCheckResult;
  private static boolean mInitModel = false;
  public static YTReflectLayout mReflectLayout;
  public static RGBConfigRequester mRgbConfigRequester;
  public static UploadVideoRequester mUploadVideoRequester;
  private static boolean mUserCanceled = false;
  
  public static void cancel()
  {
    AppMethodBeat.i(123141);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] ---");
    ProcessManager.cancel();
    noticeFailed(3, "user canceled", "YTAGReflectLiveCheckInterface.cancel() be called.");
    mUserCanceled = true;
    AppMethodBeat.o(123141);
  }
  
  public static int getProcessState()
  {
    return ProcessManager.mProcessState;
  }
  
  public static int initModel(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(123135);
    try
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] ---");
      if (mInitModel)
      {
        YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] has already inited.");
        AppMethodBeat.o(123135);
        return 0;
      }
      boolean bool = YTAGReflectLiveCheckJNIInterface.FRInitFaceSDK(paramArrayOfByte1, paramArrayOfByte2);
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] -=-=-=-=reflect init");
      if (bool)
      {
        mInitModel = true;
        ProcessManager.initAll();
        AppMethodBeat.o(123135);
        return 0;
      }
      AppMethodBeat.o(123135);
      return 1;
    }
    catch (Exception paramArrayOfByte1)
    {
      YTLogger.w("YoutuLightLiveCheck", "initModel failed. message: " + paramArrayOfByte1.getMessage());
      YTException.report(paramArrayOfByte1);
      AppMethodBeat.o(123135);
    }
    return 10;
  }
  
  public static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123143);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    if (mUserCanceled)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice failed");
      AppMethodBeat.o(123143);
      return;
    }
    if (mInitModel)
    {
      ProcessManager.dataWorker().cleanup();
      ProcessManager.cameraWorker().cleanup();
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onFailed(paramInt, paramString1, paramString2);
      mCheckResult = null;
      AppMethodBeat.o(123143);
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice failed");
    }
    new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.2(paramInt, paramString1, paramString2));
    AppMethodBeat.o(123143);
  }
  
  public static void noticeSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse)
  {
    AppMethodBeat.i(123142);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] ---isAlive: ".concat(String.valueOf(paramBoolean)));
    if (mUserCanceled)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice success");
      AppMethodBeat.o(123142);
      return;
    }
    if (mInitModel)
    {
      ProcessManager.dataWorker().cleanup();
      ProcessManager.cameraWorker().cleanup();
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onSuccess(paramBoolean, paramLightDiffResponse);
      mCheckResult = null;
      AppMethodBeat.o(123142);
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice success");
    }
    new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.1(paramBoolean, paramLightDiffResponse));
    AppMethodBeat.o(123142);
  }
  
  public static void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(123139);
    if (ProcessManager.cameraWorker() != null) {
      ProcessManager.cameraWorker().onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    AppMethodBeat.o(123139);
  }
  
  public static void releaseModel()
  {
    AppMethodBeat.i(123136);
    if (ProcessManager.mProcessState != 0)
    {
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: " + ProcessManager.mProcessState);
      YTException.report(new Exception("\"[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: \" + ProcessManager.mProcessState"));
    }
    ProcessManager.clearAll();
    if (mInitModel)
    {
      YTAGReflectLiveCheckJNIInterface.FRReleaseFaceSDK();
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] -=-=-=-=reflect releae");
      mInitModel = false;
    }
    AppMethodBeat.o(123136);
  }
  
  public static void setRGBConfigRequest(RGBConfigRequester paramRGBConfigRequester)
  {
    AppMethodBeat.i(123137);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setRGBConfigRequest] ---");
    mRgbConfigRequester = paramRGBConfigRequester;
    AppMethodBeat.o(123137);
  }
  
  public static void setUploadVideoRequester(UploadVideoRequester paramUploadVideoRequester)
  {
    AppMethodBeat.i(123138);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequester] ---");
    mUploadVideoRequester = paramUploadVideoRequester;
    AppMethodBeat.o(123138);
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTReflectLayout paramYTReflectLayout, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    AppMethodBeat.i(123140);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    mCheckResult = paramLightLiveCheckResult;
    mReflectLayout = paramYTReflectLayout;
    ProcessManager.dataWorker().mCameraRotate = CameraSetting.getVideoRotate(paramContext, paramInt);
    mUserCanceled = false;
    if (!YTCommonExInterface.isAuthSuccess())
    {
      noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTCommonExInterface.initAuth() before.");
      AppMethodBeat.o(123140);
      return;
    }
    if (!mInitModel)
    {
      noticeFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
      AppMethodBeat.o(123140);
      return;
    }
    ProcessManager.cameraWorker().setCamera(paramCamera);
    ProcessManager.start();
    AppMethodBeat.o(123140);
  }
  
  public static abstract interface LightLiveProcessState
  {
    public static final int GET_RGBCONFIG = 1;
    public static final int HANGUP = 0;
    public static final int REFLECTING = 2;
    public static final int UPLOAD = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */