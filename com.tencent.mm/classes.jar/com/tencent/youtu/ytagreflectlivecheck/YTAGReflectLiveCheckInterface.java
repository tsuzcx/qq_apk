package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
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
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] ---");
    ProcessManager.cancel();
    noticeFailed(3, "user canceled", "YTAGReflectLiveCheckInterface.cancel() be called.");
    mUserCanceled = true;
  }
  
  public static int getProcessState()
  {
    return ProcessManager.mProcessState;
  }
  
  public static int initModel(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] ---");
      if (mInitModel)
      {
        YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] has already inited.");
        return 0;
      }
      boolean bool = YTAGReflectLiveCheckJNIInterface.FRInitFaceSDK(paramArrayOfByte1, paramArrayOfByte2);
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.initModel] -=-=-=-=reflect init");
      if (bool)
      {
        mInitModel = true;
        ProcessManager.initAll();
        return 0;
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      YTLogger.w("YoutuLightLiveCheck", "initModel failed. message: " + paramArrayOfByte1.getMessage());
      YTException.report(paramArrayOfByte1);
      return 10;
    }
    return 1;
  }
  
  public static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    if (mUserCanceled)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice failed");
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
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice failed");
    }
    new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.2(paramInt, paramString1, paramString2));
  }
  
  public static void noticeSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] ---isAlive: " + paramBoolean);
    if (mUserCanceled)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice success");
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
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice success");
    }
    new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.1(paramBoolean, paramLightDiffResponse));
  }
  
  public static void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (ProcessManager.cameraWorker() != null) {
      ProcessManager.cameraWorker().onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
  
  public static void releaseModel()
  {
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
  }
  
  public static void setRGBConfigRequest(RGBConfigRequester paramRGBConfigRequester)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setRGBConfigRequest] ---");
    mRgbConfigRequester = paramRGBConfigRequester;
  }
  
  public static void setUploadVideoRequester(UploadVideoRequester paramUploadVideoRequester)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequester] ---");
    mUploadVideoRequester = paramUploadVideoRequester;
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTReflectLayout paramYTReflectLayout, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    mCheckResult = paramLightLiveCheckResult;
    mReflectLayout = paramYTReflectLayout;
    ProcessManager.dataWorker().mCameraRotate = CameraSetting.getVideoRotate(paramContext, paramInt);
    mUserCanceled = false;
    if (!YTCommonExInterface.isAuthSuccess())
    {
      noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTCommonExInterface.initAuth() before.");
      return;
    }
    if (!mInitModel)
    {
      noticeFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
      return;
    }
    ProcessManager.cameraWorker().setCamera(paramCamera);
    ProcessManager.start();
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