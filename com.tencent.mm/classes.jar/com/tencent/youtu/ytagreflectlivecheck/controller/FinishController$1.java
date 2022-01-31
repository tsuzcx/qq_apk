package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

class FinishController$1
  implements UploadVideoRequester.UploadVideoResponse
{
  FinishController$1(FinishController paramFinishController, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    this.val$checkResult.onFailed(FinishController.access$200(), "Upload video failed.[" + paramInt + "]", "Maybe net error? return code: " + paramInt + " message: " + paramString);
  }
  
  public void onSuccess(String paramString)
  {
    try
    {
      LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramString, LightDiffResponse.class);
      if (localLightDiffResponse != null)
      {
        if (localLightDiffResponse.getError_code() == 0)
        {
          this.val$checkResult.onSuccess(true, localLightDiffResponse);
          return;
        }
        this.val$checkResult.onSuccess(false, localLightDiffResponse);
        return;
      }
    }
    catch (Exception localException)
    {
      YTException.report(localException);
      this.val$checkResult.onFailed(FinishController.access$100(), "Upload video response json decode failed.", "received response: " + paramString);
      return;
    }
    this.val$checkResult.onFailed(FinishController.access$000(), "Upload video call back decode return nil.", "received response: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController.1
 * JD-Core Version:    0.7.0.1
 */