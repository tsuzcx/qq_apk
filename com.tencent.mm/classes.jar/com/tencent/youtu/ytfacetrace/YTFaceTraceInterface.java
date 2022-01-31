package com.tencent.youtu.ytfacetrace;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager;

public class YTFaceTraceInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.0.1";
  private static YTFaceTraceInterface.FaceDetectResult mCheckResult;
  private static FaceTraceProcessManager mFaceTraceProcessManager;
  private static FaceTraceingNotice mFaceTraceingNotice;
  private static boolean mInitModel = false;
  public static int mModelRetainCount = 0;
  
  public static int initModel(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.initModel] ---");
      if (mInitModel)
      {
        YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.initModel] has already inited.");
        return 0;
      }
      if (YTFaceTraceJNIInterface.Init(paramArrayOfByte1, paramArrayOfByte2))
      {
        paramArrayOfByte1 = new FaceTraceProcessManager();
        mFaceTraceProcessManager = paramArrayOfByte1;
        paramArrayOfByte1.initAll();
        mInitModel = true;
        return 0;
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      YTLogger.w("YoutuFaceDetect", "initModel failed. message: " + paramArrayOfByte1.getMessage());
      YTException.report(paramArrayOfByte1);
      return 10;
    }
    return 1;
  }
  
  public static boolean isTracing()
  {
    return (mFaceTraceProcessManager != null) && (mFaceTraceProcessManager.mIsTracing);
  }
  
  private static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    if (mFaceTraceProcessManager != null) {
      mFaceTraceProcessManager.restoreCamera();
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onFailed(paramInt, paramString1, paramString2);
      mCheckResult = null;
      return;
    }
    new Handler(Looper.getMainLooper()).post(new YTFaceTraceInterface.4(paramInt, paramString1, paramString2));
  }
  
  private static void noticePreviewing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    mFaceTraceingNotice.onTracing(paramInt, paramFaceStatus, paramRect, paramArrayOfByte, paramCamera);
  }
  
  private static void noticeSuccess()
  {
    YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.noticeSuccess] ---");
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onSuccess();
      mCheckResult = null;
      return;
    }
    new Handler(Looper.getMainLooper()).post(new YTFaceTraceInterface.3());
  }
  
  public static void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (mFaceTraceProcessManager != null) {
      mFaceTraceProcessManager.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
  
  public static void releaseModel()
  {
    YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.finalize] ---");
    if (mInitModel)
    {
      mFaceTraceProcessManager.clearAll();
      YTFaceTraceJNIInterface.Release();
      mInitModel = false;
    }
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTFaceTraceInterface.FaceDetectResult paramFaceDetectResult, FaceTraceingNotice paramFaceTraceingNotice)
  {
    YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.start] ---");
    mCheckResult = paramFaceDetectResult;
    if (YTCommonExInterface.isAuthSuccess())
    {
      if (mInitModel)
      {
        mFaceTraceProcessManager.start(paramContext, paramCamera, paramInt, new YTFaceTraceInterface.1(paramFaceTraceingNotice), new YTFaceTraceInterface.2());
        return;
      }
      noticeFailed(2, "Not init model.", "Call YTFaceTraceInterface.initModel() before.");
      return;
    }
    noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTFaceTraceInterface.initAuth() before.");
  }
  
  public static void stop()
  {
    YTLogger.i("YoutuFaceDetect", "[YTFaceTraceInterface.stop] ---");
    if (mFaceTraceProcessManager != null) {
      mFaceTraceProcessManager.stop();
    }
  }
  
  public static abstract interface FaceTraceingNotice
  {
    public static final int PREVIEWING_ONPREVIEW = 1;
    public static final int PREVIEWING_START = 0;
    public static final int PREVIEWING_STOP = 2;
    
    public abstract void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface
 * JD-Core Version:    0.7.0.1
 */