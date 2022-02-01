package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorSeqRes;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBackType;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytcommon.tools.wejson.WeJsonException;

public class InitController
{
  private static int GET_RGBCONFIG_FAILED = 0;
  private static int RGBCONFIG_GET_COLLORSEQREQ_FAILED = 0;
  private static int RGBCONFIG_GET_RGBCONFIG_NULL = 0;
  private static int RGBCONFIG_PARSE_FAILED = 5;
  private static int RGBCONFIG_RETURN_NULL = 1;
  private static int RGBCONFIG_WRONG_TYPE = 6;
  private static int RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    RGBCONFIG_GET_COLLORSEQREQ_FAILED = 2;
    RGBCONFIG_GET_RGBCONFIG_NULL = 3;
    RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 4;
  }
  
  public void start(RGBConfigRequester paramRGBConfigRequester, final ProcessManager.ProcessResult paramProcessResult, final long paramLong)
  {
    AppMethodBeat.i(43345);
    paramRGBConfigRequester.request(new RGBConfigRequester.RGBConfigRequestCallBack()
    {
      public void onFailed(int paramAnonymousInt)
      {
        AppMethodBeat.i(43344);
        paramProcessResult.onFailed(InitController.GET_RGBCONFIG_FAILED, "Get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?", paramLong);
        AppMethodBeat.o(43344);
      }
      
      public void onSuccess(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(43343);
        if (paramAnonymousString != null)
        {
          try
          {
            if (paramAnonymousString.equals(""))
            {
              paramProcessResult.onFailed(InitController.RGBCONFIG_GET_RGBCONFIG_NULL, "Get rgbconfig return string is null.", "Check \"RGBConfigRequester.RGBConfigRequestCallBack()\" return value. Is it null?", paramLong);
              AppMethodBeat.o(43343);
              return;
            }
            if (YTCommonExInterface.getBusinessCode() == 1)
            {
              ProcessManager.dataWorker().mRgbConfigCode = paramAnonymousString;
              paramProcessResult.onSuccess(paramLong);
              AppMethodBeat.o(43343);
              return;
            }
          }
          catch (WeJsonException paramAnonymousString)
          {
            paramProcessResult.onFailed(InitController.RGBCONFIG_PARSE_FAILED, "Parse rgbconfig json failed.", "Check rgbconfig json. Is it a valid json?", paramLong);
            AppMethodBeat.o(43343);
            return;
          }
          if (paramAnonymousInt == RGBConfigRequester.RGBConfigRequestCallBackType.RGB_FullResponse)
          {
            paramAnonymousString = (ColorSeqRes)new WeJson().fromJson(paramAnonymousString, ColorSeqRes.class);
            if (paramAnonymousString.error_code == 0)
            {
              ProcessManager.dataWorker().mRgbConfigCode = paramAnonymousString.color_data;
              paramProcessResult.onSuccess(paramLong);
              AppMethodBeat.o(43343);
              return;
            }
            paramProcessResult.onFailed(InitController.RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0, "Get_rgbconfig youtu server return code not 0, current is: " + paramAnonymousString.error_code, "Request rgbConfig youtu server return value not currect. Check request and response log for more details. tag: ", paramLong);
            AppMethodBeat.o(43343);
            return;
          }
          if (paramAnonymousInt == RGBConfigRequester.RGBConfigRequestCallBackType.RGB_OnlyRgbConfig)
          {
            ProcessManager.dataWorker().mRgbConfigCode = paramAnonymousString;
            paramProcessResult.onSuccess(paramLong);
            AppMethodBeat.o(43343);
            return;
          }
          paramProcessResult.onFailed(InitController.RGBCONFIG_WRONG_TYPE, "Input type is wrong.", "Type should be one of RGBConfigRequestCallBackType.", paramLong);
          AppMethodBeat.o(43343);
          return;
        }
        paramProcessResult.onFailed(InitController.RGBCONFIG_RETURN_NULL, "Get_rgbconfig return null.", "Server return value not currect.", paramLong);
        AppMethodBeat.o(43343);
      }
    });
    AppMethodBeat.o(43345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController
 * JD-Core Version:    0.7.0.1
 */