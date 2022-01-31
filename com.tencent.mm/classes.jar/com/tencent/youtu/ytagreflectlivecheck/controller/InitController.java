package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(123149);
    Object localObject = paramRGBConfigRequester.getColorSeqReq();
    if (localObject == null)
    {
      paramProcessResult.onFailed(RGBCONFIG_GET_COLLORSEQREQ_FAILED, "get colorSeqReq failed.", "Check \"rgbConfigRequester.getColorSeqReq()\" return value. Is that null?");
      AppMethodBeat.o(123149);
      return;
    }
    localObject = new ColorSeqReqInner((RGBConfigRequester.YTColorSeqReq)localObject);
    paramRGBConfigRequester.request(new WeJson().toJson(localObject), new InitController.1(this, paramProcessResult));
    AppMethodBeat.o(123149);
  }
  
  class ColorSeqReqInner
  {
    public String app_id;
    public String build_brand = Build.BRAND;
    public String build_device = Build.DEVICE;
    public String build_display = Build.DISPLAY;
    public String build_hardware = Build.HARDWARE;
    public String build_id = Build.ID;
    public String build_model = Build.MODEL;
    public String build_product = Build.PRODUCT;
    public String build_serial = Build.SERIAL;
    public String build_test = null;
    public String business_name;
    public String person_id;
    public int platform;
    
    public ColorSeqReqInner(RGBConfigRequester.YTColorSeqReq paramYTColorSeqReq)
    {
      this.app_id = paramYTColorSeqReq.app_id;
      this.business_name = paramYTColorSeqReq.business_name;
      this.person_id = paramYTColorSeqReq.person_id;
      this.platform = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController
 * JD-Core Version:    0.7.0.1
 */