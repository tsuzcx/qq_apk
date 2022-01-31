package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(75837);
    if (paramJceStruct2 == null)
    {
      TMLog.i("GetSettingHttpRequest", "response is null!");
      AppMethodBeat.o(75837);
      return;
    }
    if ((this.mListener != null) && (paramInt == 0) && ((paramJceStruct2 instanceof GetSettingsResponse)))
    {
      paramJceStruct2 = (GetSettingsResponse)paramJceStruct2;
      if (paramJceStruct2.ret == 0)
      {
        this.mListener.onSettingHttpRequestFinish((GetSettingsRequest)paramJceStruct1, paramJceStruct2, true);
        AppMethodBeat.o(75837);
        return;
      }
      this.mListener.onSettingHttpRequestFinish((GetSettingsRequest)paramJceStruct1, paramJceStruct2, false);
    }
    AppMethodBeat.o(75837);
  }
  
  public void sendSettingRequest()
  {
    AppMethodBeat.i(75836);
    super.sendRequest(new GetSettingsRequest());
    AppMethodBeat.o(75836);
  }
  
  public void setGetSettingHttpListener(IGetSettingHttpListener paramIGetSettingHttpListener)
  {
    this.mListener = paramIGetSettingHttpListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetSettingHttpRequest
 * JD-Core Version:    0.7.0.1
 */