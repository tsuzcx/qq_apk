package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.GetSettingHttpRequest;
import com.tencent.tmassistantsdk.network.IGetSettingHttpListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.protocol.jce.SettingsCfg;
import com.tencent.tmassistantsdk.protocol.jce.StatCfg;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;

public class GetSettingEngine
  implements IGetSettingHttpListener
{
  protected static final String TAG = "GetSettingEngine";
  protected static GetSettingEngine mInstance = null;
  protected GetSettingHttpRequest httpRequest = null;
  
  public static GetSettingEngine getInstance()
  {
    try
    {
      AppMethodBeat.i(75811);
      if (mInstance == null) {
        mInstance = new GetSettingEngine();
      }
      GetSettingEngine localGetSettingEngine = mInstance;
      AppMethodBeat.o(75811);
      return localGetSettingEngine;
    }
    finally {}
  }
  
  public void cancleRequest()
  {
    try
    {
      AppMethodBeat.i(75812);
      if (this.httpRequest != null)
      {
        this.httpRequest.cancleRequest();
        this.httpRequest = null;
      }
      AppMethodBeat.o(75812);
      return;
    }
    finally {}
  }
  
  public void onSettingHttpRequestFinish(GetSettingsRequest paramGetSettingsRequest, GetSettingsResponse paramGetSettingsResponse, boolean paramBoolean)
  {
    AppMethodBeat.i(75814);
    this.httpRequest = null;
    if (paramBoolean)
    {
      if ((paramGetSettingsResponse.settings != null) && (paramGetSettingsResponse.settings.size() > 0))
      {
        paramGetSettingsRequest = (SettingsCfg)paramGetSettingsResponse.settings.get(0);
        if ((paramGetSettingsRequest != null) && (paramGetSettingsRequest.cfg != null))
        {
          paramGetSettingsRequest = (StatCfg)ProtocolPackage.bytes2JceObj(paramGetSettingsRequest.cfg, StatCfg.class);
          if (paramGetSettingsRequest == null) {
            break label94;
          }
          GlobalUtil.getInstance().setNetTypeValue(paramGetSettingsRequest.netType);
        }
      }
      for (;;)
      {
        TMLog.i("GetSettingEngine", "response.settings is null !");
        AppMethodBeat.o(75814);
        return;
        label94:
        TMLog.i("GetSettingEngine", "response  StatCfg is null !");
      }
    }
    TMLog.i("GetSettingEngine", "get settings failed!");
    AppMethodBeat.o(75814);
  }
  
  public void sendRequest()
  {
    AppMethodBeat.i(75813);
    if (this.httpRequest != null)
    {
      AppMethodBeat.o(75813);
      return;
    }
    this.httpRequest = new GetSettingHttpRequest();
    this.httpRequest.setGetSettingHttpListener(this);
    this.httpRequest.sendSettingRequest();
    AppMethodBeat.o(75813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.GetSettingEngine
 * JD-Core Version:    0.7.0.1
 */