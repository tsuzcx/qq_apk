package com.tencent.tmassistantsdk.logreport;

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
      if (mInstance == null) {
        mInstance = new GetSettingEngine();
      }
      GetSettingEngine localGetSettingEngine = mInstance;
      return localGetSettingEngine;
    }
    finally {}
  }
  
  public void cancleRequest()
  {
    try
    {
      if (this.httpRequest != null)
      {
        this.httpRequest.cancleRequest();
        this.httpRequest = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onSettingHttpRequestFinish(GetSettingsRequest paramGetSettingsRequest, GetSettingsResponse paramGetSettingsResponse, boolean paramBoolean)
  {
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
            break label84;
          }
          GlobalUtil.getInstance().setNetTypeValue(paramGetSettingsRequest.netType);
        }
      }
      for (;;)
      {
        TMLog.i("GetSettingEngine", "response.settings is null !");
        return;
        label84:
        TMLog.i("GetSettingEngine", "response  StatCfg is null !");
      }
    }
    TMLog.i("GetSettingEngine", "get settings failed!");
  }
  
  public void sendRequest()
  {
    if (this.httpRequest != null) {
      return;
    }
    this.httpRequest = new GetSettingHttpRequest();
    this.httpRequest.setGetSettingHttpListener(this);
    this.httpRequest.sendSettingRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.GetSettingEngine
 * JD-Core Version:    0.7.0.1
 */