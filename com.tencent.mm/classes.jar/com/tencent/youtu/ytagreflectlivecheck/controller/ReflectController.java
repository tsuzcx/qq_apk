package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import org.json.JSONArray;

public class ReflectController
{
  private static final String CONFIG_ALPHA = "A";
  private static final String CONFIG_BLUE = "B";
  private static final String CONFIG_CONFIGS = "configs";
  private static final String CONFIG_DURATION = "duration";
  private static final String CONFIG_GREEN = "G";
  private static final String CONFIG_RED = "R";
  private static final String CONFIG_UNIT = "unit";
  public static final ColorMatrixColorFilter DEFAULT_MATRIX_COLOR_FILTER;
  private static final int DELAY_TIME = 400;
  private static int ERRCODE_CONFIG_DECODE_FAILED = 0;
  private static int ERRCODE_FINISH_FAILED = 0;
  private static int ERRCODE_GET_PARAMS_FAILED = 0;
  private static int ERRCODE_START_FAILED = 0;
  private static int ERRCODE_USER_CANCEL = 0;
  private static final int STATE_DETECT_DELAY = 1;
  private static final int STATE_END = 2;
  private static final int STATE_RGB_CHANGE = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  private static final long deltaTimeThreshold = 30L;
  private static long systemTime;
  private ProcessManager.ProcessResult mCheckResult;
  private int mConfigBegin = 0;
  private int mConfigEnd = 0;
  private int mConfigPoint = 0;
  private TimerWorker mCountDownTimer;
  private int mFrame = 0;
  private YTReflectLayout mReflectLayout;
  private int mState;
  private long time_finish_begin = 0L;
  private long time_finish_end = 0L;
  private long time_now = 0L;
  private long time_pre = 0L;
  private long time_start = 0L;
  
  static
  {
    AppMethodBeat.i(123168);
    ERRCODE_CONFIG_DECODE_FAILED = 0;
    ERRCODE_USER_CANCEL = 1;
    ERRCODE_GET_PARAMS_FAILED = 2;
    ERRCODE_START_FAILED = 3;
    ERRCODE_FINISH_FAILED = 4;
    systemTime = System.currentTimeMillis();
    DEFAULT_MATRIX_COLOR_FILTER = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    AppMethodBeat.o(123168);
  }
  
  private boolean cameraStateControl(int paramInt)
  {
    AppMethodBeat.i(123162);
    Object localObject = ProcessManager.cameraWorker().mCamera;
    if (paramInt == 0) {}
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        localParameters = ((Camera)localObject).getParameters();
        localParameters.setAutoWhiteBalanceLock(true);
        ((Camera)localObject).setParameters(localParameters);
        AppMethodBeat.o(123162);
        return true;
        if (paramInt == 1)
        {
          l1 = System.currentTimeMillis();
          localParameters = ((Camera)localObject).getParameters();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          long l1;
          paramInt = localParameters.getExposureCompensation();
          long l2 = System.currentTimeMillis();
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISObackup(paramInt);
          long l3 = System.currentTimeMillis();
          paramInt = localParameters.getMinExposureCompensation();
          long l4 = System.currentTimeMillis();
          localParameters.setExposureCompensation(paramInt);
          long l5 = System.currentTimeMillis();
          ((Camera)localObject).setParameters(localParameters);
          long l6 = System.currentTimeMillis();
          long l7 = System.nanoTime() / 1000L;
          localObject = new Timeval(l7 / 1000000L, (int)(l7 % 1000000L));
          l7 = System.currentTimeMillis();
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISOchangeTime((Timeval)localObject);
          long l8 = System.currentTimeMillis();
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetDoingDelayCalc(true);
          long l9 = System.currentTimeMillis();
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t2: " + (l2 - l1));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t3: " + (l3 - l2));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t4: " + (l4 - l3));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t5: " + (l5 - l4));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t6: " + (l6 - l5));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t7: " + (l7 - l6));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t8: " + (l8 - l7));
          YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t9: " + (l9 - l8));
        }
        catch (Exception localException2)
        {
          AppMethodBeat.o(123162);
          return false;
        }
        localException1 = localException1;
        YTException.report(localException1);
        AppMethodBeat.o(123162);
        return false;
      }
      if (paramInt == 2)
      {
        localParameters = localException2.getParameters();
        localParameters.setExposureCompensation((int)YTAGReflectLiveCheckJNIInterface.getInstance().FRGetISObackup());
        localParameters.setAutoWhiteBalanceLock(false);
        localException2.setParameters(localParameters);
      }
    }
  }
  
  private void changeState(int paramInt)
  {
    AppMethodBeat.i(123161);
    this.mState = paramInt;
    YTLogger.i("YoutuLightLiveCheck", "changeState. state: ".concat(String.valueOf(paramInt)));
    cameraStateControl(paramInt);
    if (paramInt == 0)
    {
      this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
      this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
      this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
      ProcessManager.cameraWorker().setCameraPreviewCallback(new ReflectController.3(this));
      AppMethodBeat.o(123161);
      return;
    }
    if (paramInt == 2)
    {
      YTLogger.i("mCountDownTimer", "cameraStateControl:" + (System.currentTimeMillis() - this.time_finish_begin));
      ProcessManager.cameraWorker().setCameraPreviewCallback(null);
      YTLogger.i("mCountDownTimer", "setCameraPreviewCallback:" + (System.currentTimeMillis() - this.time_finish_begin));
      this.time_finish_end = System.currentTimeMillis();
      YTLogger.i("mCountDownTimer", "onFinish. to finish: " + (this.time_finish_begin - this.time_start) + " to finish_end: " + (this.time_finish_end - this.time_finish_begin));
      this.mCheckResult.onSuccess();
    }
    AppMethodBeat.o(123161);
  }
  
  private void innerCancel()
  {
    AppMethodBeat.i(123159);
    if (this.mState == 0) {
      setColorMatrixColorFilter(DEFAULT_MATRIX_COLOR_FILTER);
    }
    AppMethodBeat.o(123159);
  }
  
  private void onPreviewFrameReceived(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(123163);
    int i = ProcessManager.cameraWorker().getDesiredPreviewWidth();
    int j = ProcessManager.cameraWorker().getDesiredPreviewHeight();
    if (this.mState == 0)
    {
      int k = this.mConfigBegin - 3;
      int m = this.mConfigEnd + 3;
      int n = this.mFrame;
      YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + k + " endFrame: " + m + " currentFrame: " + n);
      if ((n > k) && (n < m))
      {
        long l = System.currentTimeMillis();
        YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        systemTime = l;
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, i, j);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
      }
      AppMethodBeat.o(123163);
      return;
    }
    if (this.mState == 1)
    {
      YTLogger.d("YoutuLightLiveCheck", "put IOS timeval ");
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, i, j);
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval());
    }
    AppMethodBeat.o(123163);
  }
  
  private void setColorMatrixColorFilter(final ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(123157);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
      AppMethodBeat.o(123157);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(123150);
        ReflectController.this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
        AppMethodBeat.o(123150);
      }
    });
    AppMethodBeat.o(123157);
  }
  
  private void startTimer(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(123160);
    YTLogger.i("YoutuLightLiveCheck", "start timer.");
    changeState(0);
    this.mFrame = 0;
    YTLogger.i("mCountDownTimer", "duration:" + paramInt1 + " unit: " + paramInt2);
    this.time_pre = System.currentTimeMillis();
    this.time_start = this.time_pre;
    this.mCountDownTimer = new ReflectController.2(this, paramInt1, paramInt2, paramInt2, paramJSONArray);
    this.mCountDownTimer.start();
    AppMethodBeat.o(123160);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(123158);
    if (this.mCountDownTimer != null)
    {
      this.mCountDownTimer.cancel();
      this.mCountDownTimer = null;
    }
    AppMethodBeat.o(123158);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(123156);
    innerCancel();
    this.mCheckResult.onFailed(ERRCODE_USER_CANCEL, "User canceled. ", "User actively closes the proccess.");
    AppMethodBeat.o(123156);
  }
  
  /* Error */
  public void start(YTReflectLayout paramYTReflectLayout, ProcessManager.ProcessResult paramProcessResult)
  {
    // Byte code:
    //   0: ldc_w 458
    //   3: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: putfield 131	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectLayout	Lcom/tencent/youtu/ytagreflectlivecheck/ui/YTReflectLayout;
    //   11: aload_0
    //   12: aload_2
    //   13: putfield 147	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   16: invokestatic 462	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:dataWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/DataWorker;
    //   19: getfield 467	com/tencent/youtu/ytagreflectlivecheck/worker/DataWorker:mRgbConfigCode	Ljava/lang/String;
    //   22: astore_2
    //   23: new 469	org/json/JSONObject
    //   26: dup
    //   27: invokestatic 219	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   30: iconst_1
    //   31: aload_2
    //   32: invokevirtual 473	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRInit	(ZLjava/lang/String;)Ljava/lang/String;
    //   35: invokespecial 474	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 19
    //   42: invokevirtual 478	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   45: istore 4
    //   47: aload_1
    //   48: ldc 28
    //   50: invokevirtual 478	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   53: istore_3
    //   54: aload_1
    //   55: ldc 16
    //   57: invokevirtual 482	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   60: astore_1
    //   61: aload_0
    //   62: iload 4
    //   64: iload_3
    //   65: aload_1
    //   66: invokespecial 484	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:startTimer	(IILorg/json/JSONArray;)V
    //   69: ldc_w 458
    //   72: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: return
    //   76: astore_1
    //   77: aload_1
    //   78: invokestatic 289	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   81: aload_0
    //   82: getfield 147	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   85: getstatic 79	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_CONFIG_DECODE_FAILED	I
    //   88: ldc_w 486
    //   91: ldc_w 488
    //   94: aload_2
    //   95: invokestatic 491	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokeinterface 454 4 0
    //   106: ldc_w 458
    //   109: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: astore_1
    //   114: iconst_0
    //   115: istore_3
    //   116: iconst_0
    //   117: istore 4
    //   119: aload_1
    //   120: invokestatic 289	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   123: aload_0
    //   124: getfield 147	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   127: getstatic 83	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_GET_PARAMS_FAILED	I
    //   130: ldc_w 493
    //   133: ldc_w 495
    //   136: aload_2
    //   137: invokestatic 491	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   140: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   143: invokeinterface 454 4 0
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -89 -> 61
    //   153: astore_1
    //   154: aload_1
    //   155: invokestatic 289	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   158: aload_0
    //   159: invokespecial 446	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:innerCancel	()V
    //   162: aload_0
    //   163: getfield 147	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   166: getstatic 85	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_START_FAILED	I
    //   169: ldc_w 497
    //   172: ldc_w 499
    //   175: invokeinterface 454 4 0
    //   180: ldc_w 458
    //   183: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: return
    //   187: astore_1
    //   188: iconst_0
    //   189: istore_3
    //   190: goto -71 -> 119
    //   193: astore_1
    //   194: goto -75 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	ReflectController
    //   0	197	1	paramYTReflectLayout	YTReflectLayout
    //   0	197	2	paramProcessResult	ProcessManager.ProcessResult
    //   53	137	3	i	int
    //   45	73	4	j	int
    // Exception table:
    //   from	to	target	type
    //   23	39	76	org/json/JSONException
    //   39	47	113	org/json/JSONException
    //   61	69	153	java/lang/Exception
    //   47	54	187	org/json/JSONException
    //   54	61	193	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController
 * JD-Core Version:    0.7.0.1
 */