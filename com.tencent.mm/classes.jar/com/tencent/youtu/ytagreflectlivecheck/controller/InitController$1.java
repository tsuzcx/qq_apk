package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorSeqRes;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytcommon.tools.wejson.WeJsonException;

class InitController$1
  implements RGBConfigRequester.RGBConfigRequestCallBack
{
  InitController$1(InitController paramInitController, ProcessManager.ProcessResult paramProcessResult) {}
  
  public void onFailed(int paramInt)
  {
    this.val$checkResult.onFailed(InitController.access$200(), "get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?");
  }
  
  public void onSuccess(String paramString)
  {
    if (paramString != null)
    {
      if (paramString != null) {}
      try
      {
        if (paramString.equals(""))
        {
          this.val$checkResult.onFailed(InitController.access$000(), "get rgbconfig return string is null.", "Check \"RGBConfigRequester.RGBConfigRequestCallBack()\" return value. Is it null?");
          return;
        }
        if (YTCommonExInterface.getBusinessCode() == 1)
        {
          ProcessManager.dataWorker().mRgbConfigCode = paramString;
          this.val$checkResult.onSuccess();
          return;
        }
      }
      catch (WeJsonException paramString)
      {
        this.val$checkResult.onFailed(InitController.access$200(), "get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?");
        return;
      }
      paramString = (ColorSeqRes)new WeJson().fromJson(paramString, ColorSeqRes.class);
      if (paramString.error_code == 0)
      {
        ProcessManager.dataWorker().mRgbConfigCode = paramString.color_data;
        this.val$checkResult.onSuccess();
        return;
      }
      this.val$checkResult.onFailed(InitController.access$100(), "get rgbconfig youtu server return code not 0, current is: " + paramString.error_code, "Request rgbConfig youtu server return value not currect. Check request and response log for more details.");
      return;
    }
    this.val$checkResult.onFailed(InitController.access$300(), "get rgbconfig return null.", "Server return value not currect.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController.1
 * JD-Core Version:    0.7.0.1
 */