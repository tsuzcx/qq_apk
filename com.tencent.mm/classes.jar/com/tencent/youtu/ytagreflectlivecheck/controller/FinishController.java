package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

public class FinishController
{
  private static int ERRCODE_JNI_DETECT_FAILED = 3;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    ERRCODE_JSON_DECODE_FAILED = 2;
  }
  
  public void start(UploadVideoRequester paramUploadVideoRequester, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    YTLogger.i("mCountDownTimer", "current thread3: " + Thread.currentThread());
    long l1 = System.currentTimeMillis();
    int i = CameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate);
    long l2 = System.currentTimeMillis();
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    long l3 = System.currentTimeMillis();
    if (i == 0)
    {
      Object localObject = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
      long l4 = System.currentTimeMillis();
      localObject = JNIUtils.translation((FullPack)localObject, ProcessManager.dataWorker().mRgbConfigCode);
      long l5 = System.currentTimeMillis();
      localObject = new WeJson().toJson(localObject);
      long l6 = System.currentTimeMillis();
      YTLogger.i("mCountDownTimer", "[FinishController.start] finish t2: " + (l2 - l1));
      YTLogger.i("mCountDownTimer", "[FinishController.start] finish t3: " + (l3 - l2));
      YTLogger.i("mCountDownTimer", "[FinishController.start] finish t4: " + (l4 - l3));
      YTLogger.i("mCountDownTimer", "[FinishController.start] finish t5: " + (l5 - l4));
      YTLogger.i("mCountDownTimer", "[FinishController.start] finish t6: " + (l6 - l5));
      paramUploadVideoRequester.request((String)localObject, new FinishController.1(this, paramLightLiveCheckResult));
      return;
    }
    paramLightLiveCheckResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Check log for more information. code: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController
 * JD-Core Version:    0.7.0.1
 */