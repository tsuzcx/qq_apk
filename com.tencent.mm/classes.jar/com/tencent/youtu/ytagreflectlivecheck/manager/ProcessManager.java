package com.tencent.youtu.ytagreflectlivecheck.manager;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.controller.FinishController;
import com.tencent.youtu.ytagreflectlivecheck.controller.InitController;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class ProcessManager
{
  private static String TAG = "ProcessManager";
  private static CameraWorker mCameraWorker;
  private static DataWorker mDataWorker;
  public static int mProcessState = 0;
  private static ReflectController mReflectController;
  private static int mRetainCount = 0;
  
  private static void FinishStart(long paramLong)
  {
    AppMethodBeat.i(43397);
    YTLogger.i(TAG, "[ProcessManager.FinishStart] --- ".concat(String.valueOf(paramLong)));
    if (YTAGReflectLiveCheckInterface.isCanceled(paramLong))
    {
      YTLogger.d(TAG, "[ProcessManager.FinishStart] canceled. stop this procession");
      AppMethodBeat.o(43397);
      return;
    }
    mProcessState = 3;
    FinishController localFinishController = new FinishController();
    if (YTAGReflectLiveCheckInterface.mUploadVideoRequesterV3 != null)
    {
      localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV3, new ProcessFinishResult()
      {
        public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
        {
          AppMethodBeat.i(43389);
          YTAGReflectLiveCheckInterface.noticeFailed(paramAnonymousInt + 300, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
          ProcessManager.mProcessState = 0;
          AppMethodBeat.o(43389);
        }
        
        public final void onSuccess(boolean paramAnonymousBoolean, LightDiffResponse paramAnonymousLightDiffResponse, String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(43388);
          YTAGReflectLiveCheckInterface.noticeSuccess(paramAnonymousBoolean, paramAnonymousLightDiffResponse, paramAnonymousString, paramAnonymousLong);
          ProcessManager.mProcessState = 0;
          AppMethodBeat.o(43388);
        }
      }, paramLong);
      AppMethodBeat.o(43397);
      return;
    }
    if (YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2 != null)
    {
      localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2, new ProcessFinishResult()
      {
        public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
        {
          AppMethodBeat.i(43391);
          YTAGReflectLiveCheckInterface.noticeFailed(paramAnonymousInt + 300, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
          ProcessManager.mProcessState = 0;
          AppMethodBeat.o(43391);
        }
        
        public final void onSuccess(boolean paramAnonymousBoolean, LightDiffResponse paramAnonymousLightDiffResponse, String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(43390);
          YTAGReflectLiveCheckInterface.noticeSuccess(paramAnonymousBoolean, paramAnonymousLightDiffResponse, paramAnonymousString, paramAnonymousLong);
          ProcessManager.mProcessState = 0;
          AppMethodBeat.o(43390);
        }
      }, paramLong);
      AppMethodBeat.o(43397);
      return;
    }
    localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequester, new ProcessFinishResult()
    {
      public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(43393);
        YTAGReflectLiveCheckInterface.noticeFailed(paramAnonymousInt + 300, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        ProcessManager.mProcessState = 0;
        AppMethodBeat.o(43393);
      }
      
      public final void onSuccess(boolean paramAnonymousBoolean, LightDiffResponse paramAnonymousLightDiffResponse, String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(43392);
        YTAGReflectLiveCheckInterface.noticeSuccess(paramAnonymousBoolean, paramAnonymousLightDiffResponse, paramAnonymousString, paramAnonymousLong);
        ProcessManager.mProcessState = 0;
        AppMethodBeat.o(43392);
      }
    }, paramLong);
    AppMethodBeat.o(43397);
  }
  
  private static void ReflectStart(long paramLong)
  {
    AppMethodBeat.i(43396);
    YTLogger.i(TAG, "[ProcessManager.ReflectStart] --- ".concat(String.valueOf(paramLong)));
    if (YTAGReflectLiveCheckInterface.isCanceled(paramLong))
    {
      YTLogger.d(TAG, "[ProcessManager.ReflectStart] canceled. stop this procession");
      AppMethodBeat.o(43396);
      return;
    }
    mProcessState = 2;
    ReflectController localReflectController = new ReflectController();
    mReflectController = localReflectController;
    localReflectController.start(YTAGReflectLiveCheckInterface.mReflectLayout, new ProcessResult()
    {
      public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(43387);
        YTAGReflectLiveCheckInterface.noticeFailed(paramAnonymousInt + 200, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        ProcessManager.mProcessState = 0;
        AppMethodBeat.o(43387);
      }
      
      public final void onSuccess(long paramAnonymousLong)
      {
        AppMethodBeat.i(43386);
        ProcessManager.access$100(paramAnonymousLong);
        AppMethodBeat.o(43386);
      }
    }, paramLong);
    AppMethodBeat.o(43396);
  }
  
  public static CameraWorker cameraWorker()
  {
    return mCameraWorker;
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(43398);
    if (mCameraWorker != null) {
      mCameraWorker.cleanup();
    }
    if (mProcessState == 2) {
      mReflectController.cancel();
    }
    mProcessState = 0;
    AppMethodBeat.o(43398);
  }
  
  public static void clearAll()
  {
    int i = mRetainCount - 1;
    mRetainCount = i;
    if (i == 0)
    {
      mDataWorker = null;
      mCameraWorker = null;
      mProcessState = 0;
    }
  }
  
  public static DataWorker dataWorker()
  {
    return mDataWorker;
  }
  
  public static void initAll()
  {
    AppMethodBeat.i(43394);
    mDataWorker = new DataWorker();
    mCameraWorker = new CameraWorker();
    mProcessState = 0;
    mRetainCount += 1;
    AppMethodBeat.o(43394);
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(43395);
    mProcessState = 1;
    YTLogger.i(TAG, "[ProcessManager.InitStart] --- ".concat(String.valueOf(paramLong)));
    new InitController().start(YTAGReflectLiveCheckInterface.mRgbConfigRequester, new ProcessResult()
    {
      public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(43385);
        YTAGReflectLiveCheckInterface.noticeFailed(paramAnonymousInt + 100, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        ProcessManager.mProcessState = 0;
        AppMethodBeat.o(43385);
      }
      
      public final void onSuccess(final long paramAnonymousLong)
      {
        AppMethodBeat.i(43384);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          ProcessManager.access$000(paramAnonymousLong);
          AppMethodBeat.o(43384);
          return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(43383);
            ProcessManager.access$000(paramAnonymousLong);
            AppMethodBeat.o(43383);
          }
        });
        AppMethodBeat.o(43384);
      }
    }, paramLong);
    AppMethodBeat.o(43395);
  }
  
  public static abstract interface ProcessFinishResult
  {
    public abstract void onFailed(int paramInt, String paramString1, String paramString2, long paramLong);
    
    public abstract void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString, long paramLong);
  }
  
  public static abstract interface ProcessResult
  {
    public abstract void onFailed(int paramInt, String paramString1, String paramString2, long paramLong);
    
    public abstract void onSuccess(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager
 * JD-Core Version:    0.7.0.1
 */