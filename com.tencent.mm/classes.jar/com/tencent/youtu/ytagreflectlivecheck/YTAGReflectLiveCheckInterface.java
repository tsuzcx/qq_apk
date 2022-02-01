package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker.OnGetValue;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.ArrayList;

public class YTAGReflectLiveCheckInterface
{
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.4.2.2_wx";
  private static GetLiveStyleResult getLiveStyleResultHandler;
  public static YTAGReflectSettings mAGSettings;
  public static String mAppId;
  private static ArrayList mCanceledList;
  private static YTAGReflectLiveCheckInterface.LightLiveCheckResult mCheckResult;
  private static long mCurrentTag;
  private static TimerWorker mGetValueTimer;
  private static boolean mInitModel;
  private static int mOnGetValueCount;
  public static YTReflectLayout mReflectLayout;
  public static RGBConfigRequester mRgbConfigRequester;
  public static UploadVideoRequester mUploadVideoRequester;
  public static UploadVideoRequesterV2 mUploadVideoRequesterV2;
  public static UploadVideoRequesterV3 mUploadVideoRequesterV3;
  private static long tagIndex;
  
  static
  {
    AppMethodBeat.i(43327);
    mAppId = "";
    mAGSettings = new YTAGReflectSettings();
    mInitModel = false;
    tagIndex = 0L;
    getLiveStyleResultHandler = null;
    AppMethodBeat.o(43327);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(43321);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] --- " + ProcessManager.mProcessState + " current: " + mCurrentTag);
    if ((ProcessManager.mProcessState != 0) && (!isCanceled(mCurrentTag)))
    {
      ProcessManager.cancel();
      noticeFailed(3, "user canceled", "YTAGReflectLiveCheckInterface.cancel() be called.", mCurrentTag);
      if (mCanceledList != null) {
        mCanceledList.add(Long.valueOf(mCurrentTag));
      }
    }
    AppMethodBeat.o(43321);
  }
  
  public static void clean()
  {
    mCanceledList = null;
  }
  
  public static YTAGReflectSettings getAGSettings()
  {
    return mAGSettings;
  }
  
  public static Bitmap getBestImage(boolean paramBoolean)
  {
    AppMethodBeat.i(43323);
    int i = -1;
    if (paramBoolean) {
      i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    }
    Bitmap localBitmap = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetBestImg(i);
    AppMethodBeat.o(43323);
    return localBitmap;
  }
  
  public static int getLiveCheckType(Context paramContext, GetLiveStyleResult paramGetLiveStyleResult)
  {
    int i = 1;
    AppMethodBeat.i(43314);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
    if (paramGetLiveStyleResult == null) {}
    for (;;)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: ".concat(String.valueOf(i)));
      AppMethodBeat.o(43314);
      return i;
      if (paramContext == null)
      {
        paramGetLiveStyleResult.onFailed(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
        i = 2;
      }
      else
      {
        if (getLiveStyleResultHandler != null) {
          YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
        }
        getLiveStyleResultHandler = paramGetLiveStyleResult;
        mOnGetValueCount = 0;
        i = SensorManagerWorker.getInstance().start(paramContext, new SensorManagerWorker.OnGetValue()
        {
          public final void onGetValue(float paramAnonymousFloat)
          {
            AppMethodBeat.i(43307);
            YTAGReflectLiveCheckInterface.access$008();
            YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + paramAnonymousFloat + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.mOnGetValueCount);
            if (YTAGReflectLiveCheckInterface.mOnGetValueCount > 1)
            {
              YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: ".concat(String.valueOf(paramAnonymousFloat)));
              if (YTAGReflectLiveCheckInterface.mGetValueTimer != null)
              {
                YTAGReflectLiveCheckInterface.mGetValueTimer.cancel();
                YTAGReflectLiveCheckInterface.access$102(null);
              }
              if (YTAGReflectLiveCheckInterface.getLiveStyleResultHandler != null)
              {
                YTAGReflectLiveCheckInterface.getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(paramAnonymousFloat, YTAGReflectLiveCheckInterface.mAppId), new LiveStyleResponse());
                YTAGReflectLiveCheckInterface.access$202(null);
              }
              SensorManagerWorker.getInstance().stop();
            }
            AppMethodBeat.o(43307);
          }
        });
        if (i == 1)
        {
          YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-1.0F, mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else if (i != 0)
        {
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(SensorManagerWorker.getInstance().getLux(), mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else
        {
          paramContext = new TimerWorker(3000L, 3000L)
          {
            public final void onFinish()
            {
              AppMethodBeat.i(43309);
              YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
              if (YTAGReflectLiveCheckInterface.getLiveStyleResultHandler != null)
              {
                YTAGReflectLiveCheckInterface.getLiveStyleResultHandler.onFailed(3, "Get light from sensor overtime.", "Maybe try again will work. if have tryed times, please record the device and report to server.");
                YTAGReflectLiveCheckInterface.access$202(null);
              }
              AppMethodBeat.o(43309);
            }
            
            public final void onTick(long paramAnonymousLong)
            {
              AppMethodBeat.i(43308);
              YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
              AppMethodBeat.o(43308);
            }
          };
          mGetValueTimer = paramContext;
          paramContext.start();
          i = 0;
        }
      }
    }
  }
  
  public static int getProcessState()
  {
    return ProcessManager.mProcessState;
  }
  
  private static long getTag()
  {
    long l = tagIndex + 1L;
    tagIndex = l;
    return l;
  }
  
  public static int initModel(String paramString)
  {
    AppMethodBeat.i(43312);
    try
    {
      mInitModel = true;
      ProcessManager.initAll();
      if (mCanceledList == null) {
        mCanceledList = new ArrayList();
      }
      if (paramString == null) {}
      for (mAppId = "";; mAppId = paramString)
      {
        AppMethodBeat.o(43312);
        return 0;
      }
      return 10;
    }
    catch (Exception paramString)
    {
      YTLogger.w("YoutuLightLiveCheck", "initModel failed. message: " + paramString.getMessage());
      YTException.report(paramString);
      AppMethodBeat.o(43312);
    }
  }
  
  public static boolean isCanceled(long paramLong)
  {
    AppMethodBeat.i(43322);
    if (mCanceledList == null)
    {
      AppMethodBeat.o(43322);
      return true;
    }
    int i = 0;
    while (i < mCanceledList.size())
    {
      if (((Long)mCanceledList.get(i)).longValue() == paramLong)
      {
        AppMethodBeat.o(43322);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43322);
    return false;
  }
  
  public static void noticeFailed(int paramInt, final String paramString1, final String paramString2, long paramLong)
  {
    AppMethodBeat.i(43325);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2 + " tag: " + paramLong);
    if (isCanceled(paramLong))
    {
      YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] user canceled before notice failed. tag: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(43325);
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
      AppMethodBeat.o(43325);
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice failed");
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43311);
        YTAGReflectLiveCheckInterface.mCheckResult.onFailed(this.val$resultCode, paramString1, paramString2);
        YTAGReflectLiveCheckInterface.access$302(null);
        AppMethodBeat.o(43311);
      }
    });
    AppMethodBeat.o(43325);
  }
  
  public static void noticeSuccess(boolean paramBoolean, final LightDiffResponse paramLightDiffResponse, final String paramString, long paramLong)
  {
    AppMethodBeat.i(43324);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] ---isAlive: " + paramBoolean + " tag: " + paramLong);
    if (isCanceled(paramLong))
    {
      YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice success. tag: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(43324);
      return;
    }
    if (mInitModel)
    {
      ProcessManager.dataWorker().cleanup();
      ProcessManager.cameraWorker().cleanup();
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onSuccess(paramBoolean, paramLightDiffResponse, paramString);
      mCheckResult = null;
      AppMethodBeat.o(43324);
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice success");
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43310);
        YTAGReflectLiveCheckInterface.mCheckResult.onSuccess(this.val$isAlive, paramLightDiffResponse, paramString);
        YTAGReflectLiveCheckInterface.access$302(null);
        AppMethodBeat.o(43310);
      }
    });
    AppMethodBeat.o(43324);
  }
  
  public static void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(43319);
    if (ProcessManager.cameraWorker() != null) {
      ProcessManager.cameraWorker().onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    AppMethodBeat.o(43319);
  }
  
  public static void releaseModel()
  {
    AppMethodBeat.i(43313);
    if (ProcessManager.mProcessState != 0)
    {
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: " + ProcessManager.mProcessState);
      YTException.report(new Exception("\"[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: \" + ProcessManager.mProcessState"));
    }
    ProcessManager.clearAll();
    mInitModel = false;
    AppMethodBeat.o(43313);
  }
  
  public static void setAGSettings(YTAGReflectSettings paramYTAGReflectSettings)
  {
    mAGSettings = paramYTAGReflectSettings;
  }
  
  public static void setRGBConfigRequest(RGBConfigRequester paramRGBConfigRequester)
  {
    AppMethodBeat.i(43315);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setRGBConfigRequest] ---");
    mRgbConfigRequester = paramRGBConfigRequester;
    AppMethodBeat.o(43315);
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    AppMethodBeat.i(43318);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: ".concat(String.valueOf(paramInt)));
    mAGSettings.safetylevel = paramInt;
    AppMethodBeat.o(43318);
  }
  
  public static void setUploadVideoRequester(UploadVideoRequester paramUploadVideoRequester)
  {
    AppMethodBeat.i(43326);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequester] ---");
    mUploadVideoRequester = paramUploadVideoRequester;
    AppMethodBeat.o(43326);
  }
  
  public static void setUploadVideoRequesterV2(UploadVideoRequesterV2 paramUploadVideoRequesterV2)
  {
    AppMethodBeat.i(43316);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2] ---");
    mUploadVideoRequesterV2 = paramUploadVideoRequesterV2;
    AppMethodBeat.o(43316);
  }
  
  public static void setUploadVideoRequesterV3(UploadVideoRequesterV3 paramUploadVideoRequesterV3)
  {
    AppMethodBeat.i(43317);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequesterV3] ---");
    mUploadVideoRequesterV3 = paramUploadVideoRequesterV3;
    AppMethodBeat.o(43317);
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTReflectLayout paramYTReflectLayout, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    AppMethodBeat.i(43320);
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    mCheckResult = paramLightLiveCheckResult;
    mReflectLayout = paramYTReflectLayout;
    ProcessManager.dataWorker().mCameraRotate = YTCameraSetting.getVideoRotate(paramContext, paramInt);
    mCurrentTag = getTag();
    if (!mInitModel)
    {
      noticeFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.", mCurrentTag);
      AppMethodBeat.o(43320);
      return;
    }
    if (mRgbConfigRequester == null)
    {
      noticeFailed(4, "Not set rgbRequest.", "Call YTAGReflectLiveCheckInterface.setRGBConfigRequest() before.", mCurrentTag);
      AppMethodBeat.o(43320);
      return;
    }
    if ((mUploadVideoRequesterV3 == null) && (mUploadVideoRequesterV2 == null) && (mUploadVideoRequester == null))
    {
      noticeFailed(5, "Not set uploadRequest.", "Call YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2() or setUploadVideoRequesterV3() before.", mCurrentTag);
      AppMethodBeat.o(43320);
      return;
    }
    ProcessManager.cameraWorker().setCamera(paramCamera);
    ProcessManager.start(mCurrentTag);
    AppMethodBeat.o(43320);
  }
  
  public static abstract interface GetLiveStyleResult
  {
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */