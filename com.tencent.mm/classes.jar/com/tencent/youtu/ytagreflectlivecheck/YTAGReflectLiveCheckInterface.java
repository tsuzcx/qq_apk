package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker.OnGetValue;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckInterface
{
  private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 0;
  private static int ERRCODE_JNI_DETECT_FAILED = 0;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.6.4.3";
  private static GetLiveStyleResult getLiveStyleResultHandler;
  private static Lock initLock;
  public static YTAGReflectSettings mAGSettings;
  public static String mAppId;
  private static Camera mCamera;
  private static int mCameraRotatedTag;
  private static LightLiveCheckResult mCheckResult;
  private static String mColorSeq;
  private static TimerWorker mGetValueTimer;
  private static int mInitModel;
  private static int mOnGetValueCount;
  private static IYTReflectListener mReflectListener;
  public static YTReflectNotice mReflectNotice;
  private static int mState;
  
  static
  {
    AppMethodBeat.i(43327);
    ERRCODE_NET_RETURN_PARSE_NULL = 0;
    ERRCODE_UPLOAD_VIDEO_FAILED = 1;
    ERRCODE_JSON_DECODE_FAILED = 2;
    ERRCODE_JNI_DETECT_FAILED = 3;
    ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
    mAppId = "";
    mAGSettings = new YTAGReflectSettings();
    mInitModel = 0;
    initLock = new ReentrantLock();
    getLiveStyleResultHandler = null;
    AppMethodBeat.o(43327);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(43321);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] --- ");
    YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
    AppMethodBeat.o(43321);
  }
  
  public static YTAGReflectSettings getAGSettings()
  {
    return mAGSettings;
  }
  
  public static int getLiveCheckType(Context paramContext, GetLiveStyleResult paramGetLiveStyleResult)
  {
    int i = 1;
    AppMethodBeat.i(43314);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
    if (paramGetLiveStyleResult == null) {}
    for (;;)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: ".concat(String.valueOf(i)));
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
          YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
        }
        getLiveStyleResultHandler = paramGetLiveStyleResult;
        mOnGetValueCount = 0;
        i = SensorManagerWorker.getInstance().start(paramContext, new SensorManagerWorker.OnGetValue()
        {
          public final void onGetValue(float paramAnonymousFloat)
          {
            AppMethodBeat.i(43307);
            YTAGReflectLiveCheckInterface.access$008();
            YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + paramAnonymousFloat + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.mOnGetValueCount);
            if (YTAGReflectLiveCheckInterface.mOnGetValueCount > 1)
            {
              YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: ".concat(String.valueOf(paramAnonymousFloat)));
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
          YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
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
              YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
              if (YTAGReflectLiveCheckInterface.getLiveStyleResultHandler != null)
              {
                YTAGReflectLiveCheckInterface.getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-2.0F, YTAGReflectLiveCheckInterface.mAppId), new LiveStyleResponse());
                YTAGReflectLiveCheckInterface.access$202(null);
              }
              AppMethodBeat.o(43309);
            }
            
            public final void onTick(long paramAnonymousLong)
            {
              AppMethodBeat.i(43308);
              YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
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
  
  public static RawYuvData[] getRawYuvDatas()
  {
    AppMethodBeat.i(193631);
    RawYuvData[] arrayOfRawYuvData = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
    AppMethodBeat.o(193631);
    return arrayOfRawYuvData;
  }
  
  public static IYTReflectListener getReflectListener()
  {
    return mReflectListener;
  }
  
  /* Error */
  public static int initModel(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 215
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_0
    //   9: istore_1
    //   10: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 220 1 0
    //   18: getstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   21: ifle +36 -> 57
    //   24: ldc 32
    //   26: ldc 222
    //   28: invokestatic 126	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:nativeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: getstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   34: iconst_1
    //   35: iadd
    //   36: putstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   39: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 225 1 0
    //   47: ldc 215
    //   49: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: ldc 2
    //   54: monitorexit
    //   55: iload_1
    //   56: ireturn
    //   57: aload_0
    //   58: putstatic 80	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mAppId	Ljava/lang/String;
    //   61: aload_0
    //   62: ifnonnull -31 -> 31
    //   65: ldc 78
    //   67: putstatic 80	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mAppId	Ljava/lang/String;
    //   70: goto -39 -> 31
    //   73: astore_0
    //   74: ldc 32
    //   76: new 227	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 229
    //   82: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 126	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:nativeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iconst_m1
    //   99: istore_1
    //   100: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   103: invokeinterface 225 1 0
    //   108: goto -61 -> 47
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   121: invokeinterface 225 1 0
    //   126: ldc 215
    //   128: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_0
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   9	91	1	i	int
    // Exception table:
    //   from	to	target	type
    //   10	31	73	java/lang/Exception
    //   31	39	73	java/lang/Exception
    //   57	61	73	java/lang/Exception
    //   65	70	73	java/lang/Exception
    //   3	8	111	finally
    //   39	47	111	finally
    //   47	52	111	finally
    //   100	108	111	finally
    //   118	133	111	finally
    //   10	31	117	finally
    //   31	39	117	finally
    //   57	61	117	finally
    //   65	70	117	finally
    //   74	98	117	finally
  }
  
  public static void onCameraChanged(int paramInt)
  {
    AppMethodBeat.i(193629);
    try
    {
      Camera.Parameters localParameters = mCamera.getParameters();
      localParameters.setExposureCompensation(paramInt);
      mCamera.setParameters(localParameters);
      AppMethodBeat.o(193629);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("on camera changed failed:").append(localException.getLocalizedMessage());
      AppMethodBeat.o(193629);
    }
  }
  
  public static int[] onFetchCameraInfo()
  {
    AppMethodBeat.i(193630);
    for (;;)
    {
      try
      {
        localParameters = mCamera.getParameters();
        i = localParameters.getExposureCompensation();
        try
        {
          j = Integer.parseInt(localParameters.get("iso"));
          i = j;
        }
        catch (Exception localException4)
        {
          try
          {
            k = localParameters.getMinExposureCompensation();
            j = k;
          }
          catch (Exception localException1)
          {
            k = 0;
            i = j;
            j = k;
          }
          try
          {
            k = localParameters.getMaxExposureCompensation();
            new StringBuilder("on fetch camera exp:").append(i).append(" min:").append(j).append(" max:").append(k);
            AppMethodBeat.o(193630);
            return new int[] { i, j, k };
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException4 = localException4;
          j = i;
          new StringBuilder("on fectch camera compoensation failed:").append(localException4.getLocalizedMessage());
          continue;
        }
        j = i;
      }
      catch (Exception localException2)
      {
        Camera.Parameters localParameters;
        int k;
        int j = 0;
        int i = 0;
        continue;
      }
      new StringBuilder("on fectch camera info failed:").append(localException1.getLocalizedMessage());
      k = 0;
    }
  }
  
  public static void onFinish()
  {
    AppMethodBeat.i(193625);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "on finished");
    int i = mCameraRotatedTag;
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "on finished ".concat(String.valueOf(i)));
    if (i == 0)
    {
      FullPack localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
      mCheckResult.onSuccess(localFullPack);
      AppMethodBeat.o(193625);
      return;
    }
    mCheckResult.onFailed(-1, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ".concat(String.valueOf(i)));
    AppMethodBeat.o(193625);
  }
  
  public static void onScreenChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(193626);
    ColorMatrixColorFilter localColorMatrixColorFilter = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, 0.0F, 0.0F, 0.0F, 0.0F, paramInt3, 0.0F, 0.0F, 0.0F, 0.0F, paramInt4, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1 });
    if (mReflectListener == null)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection screen change failed:mReflectListener is null");
      AppMethodBeat.o(193626);
      return;
    }
    mReflectListener.onReflectEvent(localColorMatrixColorFilter, paramFloat);
    AppMethodBeat.o(193626);
  }
  
  public static void onStateChanged(int paramInt)
  {
    AppMethodBeat.i(193627);
    mState = paramInt;
    new StringBuilder("on state changed call ").append(mState);
    if (paramInt == 0) {}
    try
    {
      Camera.Parameters localParameters1 = mCamera.getParameters();
      localParameters1.setAutoWhiteBalanceLock(true);
      mCamera.setParameters(localParameters1);
      AppMethodBeat.o(193627);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("on state changed failed:").append(localException.getLocalizedMessage());
      AppMethodBeat.o(193627);
      return;
    }
    if (paramInt == 1)
    {
      if (mReflectNotice != null)
      {
        mReflectNotice.onDelayCalc();
        AppMethodBeat.o(193627);
      }
    }
    else if (paramInt == 2)
    {
      Camera.Parameters localParameters2 = mCamera.getParameters();
      localParameters2.setAutoWhiteBalanceLock(false);
      mCamera.setParameters(localParameters2);
      onFinish();
    }
    AppMethodBeat.o(193627);
  }
  
  public static void pushImageData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(193628);
    if (mState == 0)
    {
      int i = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
      int j = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
      int k = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + i + " endFrame: " + j + " currentFrame: " + k);
      if ((k > i) && (k < j))
      {
        System.currentTimeMillis();
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3, paramArrayOfFloat);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval(paramLong));
      }
      AppMethodBeat.o(193628);
      return;
    }
    if (mState == 1)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] record ios");
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, paramInt1, paramInt2);
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval(paramLong));
    }
    AppMethodBeat.o(193628);
  }
  
  /* Error */
  public static void releaseModel()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 416
    //   6: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 220 1 0
    //   17: getstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   20: iconst_1
    //   21: isub
    //   22: istore_0
    //   23: iload_0
    //   24: putstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   27: iload_0
    //   28: ifgt +35 -> 63
    //   31: iconst_0
    //   32: putstatic 89	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   35: aconst_null
    //   36: putstatic 356	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectNotice	Lcom/tencent/youtu/ytagreflectlivecheck/notice/YTReflectNotice;
    //   39: aconst_null
    //   40: putstatic 210	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectListener	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$IYTReflectListener;
    //   43: getstatic 110	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   46: ifnull +13 -> 59
    //   49: getstatic 110	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   52: invokevirtual 418	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:cancel	()V
    //   55: aconst_null
    //   56: putstatic 110	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   59: aconst_null
    //   60: putstatic 96	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getLiveStyleResultHandler	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$GetLiveStyleResult;
    //   63: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   66: invokeinterface 225 1 0
    //   71: invokestatic 421	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:clearInstance	()V
    //   74: ldc_w 416
    //   77: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 2
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: getstatic 94	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 225 1 0
    //   93: ldc_w 416
    //   96: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	6	0	i	int
    //   84	16	1	localObject1	Object
    //   101	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	27	84	finally
    //   31	59	84	finally
    //   59	63	84	finally
    //   3	9	101	finally
    //   63	80	101	finally
    //   85	101	101	finally
  }
  
  public static void setAGSettings(YTAGReflectSettings paramYTAGReflectSettings)
  {
    mAGSettings = paramYTAGReflectSettings;
  }
  
  public static void setReflectListener(IYTReflectListener paramIYTReflectListener)
  {
    mReflectListener = paramIYTReflectListener;
  }
  
  public static void setReflectNotice(YTReflectNotice paramYTReflectNotice)
  {
    mReflectNotice = paramYTReflectNotice;
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    AppMethodBeat.i(43318);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: ".concat(String.valueOf(paramInt)));
    mAGSettings.safetylevel = paramInt;
    AppMethodBeat.o(43318);
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, String paramString, LightLiveCheckResult paramLightLiveCheckResult)
  {
    AppMethodBeat.i(193624);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    if (paramLightLiveCheckResult == null)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:checkResult is null");
      AppMethodBeat.o(193624);
      return;
    }
    mCheckResult = paramLightLiveCheckResult;
    if (mInitModel <= 0)
    {
      mCheckResult.onFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
      AppMethodBeat.o(193624);
      return;
    }
    mCameraRotatedTag = paramInt;
    mColorSeq = paramString;
    mCamera = paramCamera;
    paramContext = new long[2];
    float f = -1.0F;
    if (mReflectListener == null) {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:mReflectListener is null");
    }
    if (mReflectListener != null) {
      f = mReflectListener.onGetAppBrightness();
    }
    YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, paramString, mAGSettings.safetylevel, paramContext, f);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "output duration ms" + paramContext[0] + " " + paramContext[1]);
    if (mReflectListener != null) {
      mReflectListener.onReflectStart(paramContext[0]);
    }
    AppMethodBeat.o(193624);
  }
  
  public static abstract interface GetLiveStyleResult
  {
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse);
  }
  
  public static abstract interface IYTReflectListener
  {
    public abstract float onGetAppBrightness();
    
    public abstract void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat);
    
    public abstract void onReflectStart(long paramLong);
  }
  
  public static abstract interface LightLiveCheckResult
  {
    public static final int AUTH_FAILED = 1;
    public static final int FINISH_ERRORBASE = 300;
    public static final int INIT_ERRORBASE = 100;
    public static final int NOT_INIT_MODEL = 2;
    public static final int NOT_SET_RGBREQUEST = 4;
    public static final int NOT_SET_UPLOADREQUEST = 5;
    public static final int REFLECT_ERRORBASE = 200;
    public static final int SUCCESS = 0;
    public static final int USER_CANCEL = 3;
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess(FullPack paramFullPack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */