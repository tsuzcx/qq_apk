package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.ActReflectResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.UploadVideoResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.io.ByteArrayOutputStream;

public class FinishController
{
  private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
  private static int ERRCODE_JNI_DETECT_FAILED = 0;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    ERRCODE_JSON_DECODE_FAILED = 2;
    ERRCODE_JNI_DETECT_FAILED = 3;
  }
  
  private byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(43336);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(43336);
    return paramBitmap;
  }
  
  private void checkUpload(UploadVideoRequester paramUploadVideoRequester, final ProcessManager.ProcessFinishResult paramProcessFinishResult, final long paramLong)
  {
    AppMethodBeat.i(43341);
    PersonLiveReq localPersonLiveReq = JNIUtils.translation(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin(), ProcessManager.dataWorker().mRgbConfigCode);
    paramUploadVideoRequester.request(new WeJson().toJson(localPersonLiveReq), new UploadVideoRequester.UploadVideoResponse()
    {
      public void onFailed(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(43335);
        paramProcessFinishResult.onFailed(FinishController.ERRCODE_UPLOAD_VIDEO_FAILED, "Upload video failed.[" + paramAnonymousInt + "]", "Maybe net error? return code: " + paramAnonymousInt + " message: " + paramAnonymousString, paramLong);
        AppMethodBeat.o(43335);
      }
      
      public void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(43334);
        try
        {
          LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramAnonymousString, LightDiffResponse.class);
          if (localLightDiffResponse != null)
          {
            if (localLightDiffResponse.getError_code() == 0)
            {
              paramProcessFinishResult.onSuccess(true, localLightDiffResponse, paramAnonymousString, paramLong);
              AppMethodBeat.o(43334);
              return;
            }
            paramProcessFinishResult.onSuccess(false, localLightDiffResponse, paramAnonymousString, paramLong);
            AppMethodBeat.o(43334);
            return;
          }
        }
        catch (Exception localException)
        {
          YTException.report(localException);
          paramProcessFinishResult.onFailed(FinishController.ERRCODE_JSON_DECODE_FAILED, "Upload video response json decode failed.", "received response: ".concat(String.valueOf(paramAnonymousString)), paramLong);
          AppMethodBeat.o(43334);
          return;
        }
        paramProcessFinishResult.onFailed(FinishController.ERRCODE_NET_RETURN_PARSE_NULL, "Upload video call back decode return nil.", "received response: ".concat(String.valueOf(paramAnonymousString)), paramLong);
        AppMethodBeat.o(43334);
      }
    });
    AppMethodBeat.o(43341);
  }
  
  private void checkUploadV2(UploadVideoRequesterV2 paramUploadVideoRequesterV2, final ProcessManager.ProcessFinishResult paramProcessFinishResult, final long paramLong)
  {
    AppMethodBeat.i(43339);
    TimeCounter.ins("sdk处理反光数据").begin();
    EncodeReflectData localEncodeReflectData;
    FullPack localFullPack;
    if (YTAGReflectLiveCheckInterface.getAGSettings().isEncodeReflectData)
    {
      localEncodeReflectData = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetEncodeReflectData();
      localFullPack = null;
    }
    for (;;)
    {
      TimeCounter.ins("sdk处理反光数据").end(false);
      paramUploadVideoRequesterV2.request(JNIUtils.getReflectLiveReq(localFullPack, localEncodeReflectData, ProcessManager.dataWorker().mRgbConfigCode), new UploadVideoRequesterV2.UploadVideoResponse()
      {
        public void onFailed(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(43333);
          paramProcessFinishResult.onFailed(FinishController.ERRCODE_UPLOAD_VIDEO_FAILED, "Upload video failed.[" + paramAnonymousInt + "]", "Maybe net error? return code: " + paramAnonymousInt + " message: " + paramAnonymousString, paramLong);
          AppMethodBeat.o(43333);
        }
        
        public void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(43332);
          try
          {
            LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramAnonymousString, LightDiffResponse.class);
            if (localLightDiffResponse != null)
            {
              if ((localLightDiffResponse.reflect_live_code == 0) && (localLightDiffResponse.picture_live_code == 0))
              {
                paramProcessFinishResult.onSuccess(true, localLightDiffResponse, paramAnonymousString, paramLong);
                AppMethodBeat.o(43332);
                return;
              }
              paramProcessFinishResult.onSuccess(false, localLightDiffResponse, paramAnonymousString, paramLong);
              AppMethodBeat.o(43332);
              return;
            }
          }
          catch (Exception localException)
          {
            YTException.report(localException);
            paramProcessFinishResult.onFailed(FinishController.ERRCODE_JSON_DECODE_FAILED, "Upload video response json decode failed.", "received response: ".concat(String.valueOf(paramAnonymousString)), paramLong);
            AppMethodBeat.o(43332);
            return;
          }
          paramProcessFinishResult.onFailed(FinishController.ERRCODE_NET_RETURN_PARSE_NULL, "Upload video call back decode return nil.", "received response: ".concat(String.valueOf(paramAnonymousString)), paramLong);
          AppMethodBeat.o(43332);
        }
      });
      AppMethodBeat.o(43339);
      return;
      localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
      localEncodeReflectData = null;
    }
  }
  
  private void checkUploadV3(final UploadVideoRequesterV3 paramUploadVideoRequesterV3, final ProcessManager.ProcessFinishResult paramProcessFinishResult, final long paramLong)
  {
    AppMethodBeat.i(43337);
    TimeCounter.ins("sdk请求动作图片信息").begin();
    paramUploadVideoRequesterV3.getActReflectData(new UploadVideoRequesterV3.ActReflectResponse()
    {
      public void onFailed(String paramAnonymousString)
      {
        AppMethodBeat.i(43331);
        TimeCounter.ins("sdk请求动作图片信息").end(false);
        paramProcessFinishResult.onFailed(FinishController.ERRCODE_GET_ACTREFLECTDATA_FAILED, "Get ActReflectData failed", "received response: ".concat(String.valueOf(paramAnonymousString)), paramLong);
        AppMethodBeat.o(43331);
      }
      
      public void onSuccess(YTActReflectData paramAnonymousYTActReflectData)
      {
        AppMethodBeat.i(43330);
        TimeCounter.ins("sdk请求动作图片信息").end(false);
        TimeCounter.ins("sdk处理反光数据").begin();
        EncodeReflectData localEncodeReflectData;
        FullPack localFullPack;
        if (YTAGReflectLiveCheckInterface.getAGSettings().isEncodeReflectData)
        {
          localEncodeReflectData = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetEncodeReflectData();
          localFullPack = null;
        }
        for (;;)
        {
          TimeCounter.ins("sdk处理反光数据").end(false);
          paramAnonymousYTActReflectData = JNIUtils.getActionReflectLiveReq(localFullPack, localEncodeReflectData, paramAnonymousYTActReflectData, ProcessManager.dataWorker().mRgbConfigCode);
          paramUploadVideoRequesterV3.request(paramAnonymousYTActReflectData, new UploadVideoRequesterV3.UploadVideoResponse()
          {
            public void onFailed(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(43329);
              FinishController.1.this.val$checkResult.onFailed(FinishController.ERRCODE_UPLOAD_VIDEO_FAILED, "Upload video failed.[" + paramAnonymous2Int + "]", "Maybe net error? return code: " + paramAnonymous2Int + " message: " + paramAnonymous2String, FinishController.1.this.val$tag);
              AppMethodBeat.o(43329);
            }
            
            public void onSuccess(String paramAnonymous2String)
            {
              AppMethodBeat.i(43328);
              try
              {
                LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramAnonymous2String, LightDiffResponse.class);
                if (localLightDiffResponse != null)
                {
                  if (localLightDiffResponse.errorcode == 0)
                  {
                    FinishController.1.this.val$checkResult.onSuccess(true, localLightDiffResponse, paramAnonymous2String, FinishController.1.this.val$tag);
                    AppMethodBeat.o(43328);
                    return;
                  }
                  FinishController.1.this.val$checkResult.onSuccess(false, localLightDiffResponse, paramAnonymous2String, FinishController.1.this.val$tag);
                  AppMethodBeat.o(43328);
                  return;
                }
              }
              catch (Exception localException)
              {
                YTException.report(localException);
                FinishController.1.this.val$checkResult.onFailed(FinishController.ERRCODE_JSON_DECODE_FAILED, "Upload video response json decode failed.", "received response: ".concat(String.valueOf(paramAnonymous2String)), FinishController.1.this.val$tag);
                AppMethodBeat.o(43328);
                return;
              }
              FinishController.1.this.val$checkResult.onFailed(FinishController.ERRCODE_NET_RETURN_PARSE_NULL, "Upload video call back decode return nil.", "received response: ".concat(String.valueOf(paramAnonymous2String)), FinishController.1.this.val$tag);
              AppMethodBeat.o(43328);
            }
          });
          AppMethodBeat.o(43330);
          return;
          localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
          localEncodeReflectData = null;
        }
      }
    });
    AppMethodBeat.o(43337);
  }
  
  public void start(UploadVideoRequester paramUploadVideoRequester, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    AppMethodBeat.i(43342);
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUpload(paramUploadVideoRequester, paramProcessFinishResult, paramLong);
      AppMethodBeat.o(43342);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ".concat(String.valueOf(i)), paramLong);
    AppMethodBeat.o(43342);
  }
  
  public void start(UploadVideoRequesterV2 paramUploadVideoRequesterV2, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    AppMethodBeat.i(43340);
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUploadV2(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2, paramProcessFinishResult, paramLong);
      AppMethodBeat.o(43340);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ".concat(String.valueOf(i)), paramLong);
    AppMethodBeat.o(43340);
  }
  
  public void start(UploadVideoRequesterV3 paramUploadVideoRequesterV3, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    AppMethodBeat.i(43338);
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUploadV3(paramUploadVideoRequesterV3, paramProcessFinishResult, paramLong);
      AppMethodBeat.o(43338);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ".concat(String.valueOf(i)), paramLong);
    AppMethodBeat.o(43338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController
 * JD-Core Version:    0.7.0.1
 */