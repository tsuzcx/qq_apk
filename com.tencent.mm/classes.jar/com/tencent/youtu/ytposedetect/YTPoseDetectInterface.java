package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.3.2";
  private static PoseDetectResult mCheckResult;
  private static boolean mInitModel = false;
  private static boolean mIsStarted = false;
  public static int mModelRetainCount = 0;
  private static PoseDetectProcessManager mPoseDetectProcessManager;
  
  public static void getBestImage(PoseDetectGetBestImage paramPoseDetectGetBestImage, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62504);
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8)) {
        break;
      }
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
      AppMethodBeat.o(62504);
      return;
      i = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1);
    }
    paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
    AppMethodBeat.o(62504);
  }
  
  public static int getFrameNum()
  {
    AppMethodBeat.i(62509);
    int i = YTPoseDetectJNIInterface.getFrameNum();
    AppMethodBeat.o(62509);
    return i;
  }
  
  public static int initModel()
  {
    AppMethodBeat.i(62500);
    try
    {
      YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] ---");
      if (mInitModel)
      {
        YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] has already inited.");
        AppMethodBeat.o(62500);
        return 0;
      }
      int i = YTPoseDetectJNIInterface.initModel("");
      if (i == 0)
      {
        PoseDetectProcessManager localPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager = localPoseDetectProcessManager;
        localPoseDetectProcessManager.initAll();
        mInitModel = true;
        AppMethodBeat.o(62500);
        return 0;
      }
      AppMethodBeat.o(62500);
      return i;
    }
    catch (Exception localException)
    {
      YTLogger.w("YoutuFaceDetect", "initModel failed. message: " + localException.getMessage());
      YTException.report(localException);
      AppMethodBeat.o(62500);
    }
    return 10;
  }
  
  public static boolean isDetecting()
  {
    return (mPoseDetectProcessManager != null) && (mPoseDetectProcessManager.mIsDetecting);
  }
  
  private static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(62511);
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    mPoseDetectProcessManager.restoreCamera();
    mCheckResult.onFailed(paramInt, paramString1, paramString2);
    mCheckResult = null;
    mIsStarted = false;
    AppMethodBeat.o(62511);
  }
  
  private static void noticeSuccess()
  {
    AppMethodBeat.i(62510);
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeSuccess] ---");
    mCheckResult.onSuccess();
    mCheckResult = null;
    mIsStarted = true;
    AppMethodBeat.o(62510);
  }
  
  public static void poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt, byte[] paramArrayOfByte, Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, PoseDetectOnFrame paramPoseDetectOnFrame)
  {
    AppMethodBeat.i(62503);
    if (!mInitModel)
    {
      paramPoseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
      AppMethodBeat.o(62503);
      return;
    }
    if (!mIsStarted)
    {
      paramPoseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
      AppMethodBeat.o(62503);
      return;
    }
    paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt, paramArrayOfByte, paramFloat1, paramFloat2, paramFloat3));
    if (YTPoseDetectJNIInterface.isRecordingDone())
    {
      paramArrayOfFloat1 = YTPoseDetectJNIInterface.getFrameList();
      YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.poseDetect] list num: " + paramArrayOfFloat1.length);
      paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat1, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
    }
    AppMethodBeat.o(62503);
  }
  
  public static void releaseModel()
  {
    AppMethodBeat.i(62501);
    YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.finalize] ---");
    if (mInitModel)
    {
      mPoseDetectProcessManager.clearAll();
      YTPoseDetectJNIInterface.releaseAll();
      mInitModel = false;
    }
    AppMethodBeat.o(62501);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(62506);
    YTPoseDetectJNIInterface.resetDetect();
    AppMethodBeat.o(62506);
  }
  
  public static void setFrameNum(int paramInt)
  {
    AppMethodBeat.i(62508);
    YTPoseDetectJNIInterface.setFrameNum(paramInt);
    AppMethodBeat.o(62508);
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    AppMethodBeat.i(62502);
    if ((paramInt >= 0) && (paramInt < 3)) {
      YTPoseDetectJNIInterface.setSafetyLevel(paramInt);
    }
    AppMethodBeat.o(62502);
  }
  
  public static int start(Context paramContext, Camera paramCamera, int paramInt, PoseDetectResult paramPoseDetectResult)
  {
    AppMethodBeat.i(62505);
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.start] ---");
    if (paramPoseDetectResult == null)
    {
      AppMethodBeat.o(62505);
      return -1;
    }
    mCheckResult = paramPoseDetectResult;
    if (mInitModel) {
      mPoseDetectProcessManager.start(paramContext, paramCamera, paramInt, new PoseDetectResult()
      {
        public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(62499);
          YTPoseDetectInterface.access$100(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(62499);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(62498);
          YTPoseDetectInterface.access$000();
          AppMethodBeat.o(62498);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(62505);
      return 0;
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
    }
  }
  
  public static void stop()
  {
    AppMethodBeat.i(62507);
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.stop] ---");
    if (mPoseDetectProcessManager != null) {
      mPoseDetectProcessManager.stop();
    }
    mIsStarted = false;
    AppMethodBeat.o(62507);
  }
  
  public static abstract interface PoseDetectGetBestImage
  {
    public abstract void onGetBestImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface PoseDetectOnFrame
  {
    public static final int DETECT_AUTH_FAILED = 1;
    public static final int DETECT_NOT_CALL_START = 3;
    public static final int DETECT_NOT_INIT_MODEL = 2;
    public static final int DETECT_SUCCESS = 0;
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void onSuccess(int paramInt);
  }
  
  public static abstract interface PoseDetectResult
  {
    public static final int ERROR_AUTH_FAILED = 1;
    public static final int ERROR_NOT_INIT_MODEL = 2;
    public static final int SUCCESS = 0;
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */