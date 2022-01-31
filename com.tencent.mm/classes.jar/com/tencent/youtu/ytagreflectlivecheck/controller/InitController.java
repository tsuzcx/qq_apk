package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

public class InitController
{
  private static int GET_RGBCONFIG_FAILED = 0;
  private static int RGBCONFIG_GET_COLLORSEQREQ_FAILED = 2;
  private static int RGBCONFIG_GET_RGBCONFIG_NULL = 3;
  private static int RGBCONFIG_RETURN_NULL = 1;
  private static int RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 4;
  private static final String TAG = "YoutuLightLiveCheck";
  
  public void start(RGBConfigRequester paramRGBConfigRequester, ProcessManager.ProcessResult paramProcessResult)
  {
    Object localObject = paramRGBConfigRequester.getColorSeqReq();
    if (localObject == null)
    {
      paramProcessResult.onFailed(RGBCONFIG_GET_COLLORSEQREQ_FAILED, "get colorSeqReq failed.", "Check \"rgbConfigRequester.getColorSeqReq()\" return value. Is that null?");
      return;
    }
    localObject = new InitController.ColorSeqReqInner(this, (RGBConfigRequester.YTColorSeqReq)localObject);
    paramRGBConfigRequester.request(new WeJson().toJson(localObject), new InitController.1(this, paramProcessResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController
 * JD-Core Version:    0.7.0.1
 */