package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingHttpRequest
  extends PostHttpRequest
{
  protected static final String TAG = "GetSettingHttpRequest";
  protected IGetSettingHttpListener mListener = null;
  
  protected void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    if (paramJceStruct2 == null) {
      TMLog.i("GetSettingHttpRequest", "response is null!");
    }
    while ((this.mListener == null) || (paramInt != 0) || (!(paramJceStruct2 instanceof GetSettingsResponse))) {
      return;
    }
    paramJceStruct2 = (GetSettingsResponse)paramJceStruct2;
    if (paramJceStruct2.ret == 0)
    {
      this.mListener.onSettingHttpRequestFinish((GetSettingsRequest)paramJceStruct1, paramJceStruct2, true);
      return;
    }
    this.mListener.onSettingHttpRequestFinish((GetSettingsRequest)paramJceStruct1, paramJceStruct2, false);
  }
  
  public void sendSettingRequest()
  {
    super.sendRequest(new GetSettingsRequest());
  }
  
  public void setGetSettingHttpListener(IGetSettingHttpListener paramIGetSettingHttpListener)
  {
    this.mListener = paramIGetSettingHttpListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetSettingHttpRequest
 * JD-Core Version:    0.7.0.1
 */