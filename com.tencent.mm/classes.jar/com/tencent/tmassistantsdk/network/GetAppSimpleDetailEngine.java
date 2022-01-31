package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantExchangeURLListenner;
import com.tencent.tmassistantsdk.protocol.jce.AppDetailParam;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailResponse;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;

public class GetAppSimpleDetailEngine
  extends PostHttpRequest
{
  protected static final String TAG = "GetAppSimpleDetailHttpRequest";
  protected ITMAssistantExchangeURLListenner mListener = null;
  
  public GetAppSimpleDetailEngine(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    this.mListener = paramITMAssistantExchangeURLListenner;
  }
  
  protected void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    if (paramJceStruct2 == null) {}
    do
    {
      do
      {
        return;
        if ((this.mListener == null) || (paramInt != 0)) {
          break;
        }
      } while (!(paramJceStruct2 instanceof GetAppSimpleDetailResponse));
      paramJceStruct1 = (GetAppSimpleDetailResponse)paramJceStruct2;
      if (paramJceStruct1.ret == 0)
      {
        paramJceStruct1 = paramJceStruct1.appSimpleDetailList;
        if ((paramJceStruct1 != null) && (paramJceStruct1.size() > 0))
        {
          this.mListener.onExchangedURLSucceed(paramJceStruct1, true);
          return;
        }
        TMLog.w("GetAppSimpleDetailHttpRequest", " appDetails 为空!!");
        this.mListener.onExchangedURLSucceed(null, false);
        return;
      }
      TMLog.w("GetAppSimpleDetailHttpRequest", " 后台返回的ret错误，错误值为：" + paramJceStruct1.ret);
      this.mListener.onExchangedURLSucceed(null, false);
      return;
      TMLog.w("GetAppSimpleDetailHttpRequest", " error happened!!");
    } while (this.mListener == null);
    this.mListener.onExchangedURLSucceed(null, false);
  }
  
  public boolean sendReuqest(ArrayList<AppDetailParam> paramArrayList)
  {
    GetAppSimpleDetailRequest localGetAppSimpleDetailRequest = new GetAppSimpleDetailRequest();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localGetAppSimpleDetailRequest.appReqList = paramArrayList;
      super.sendRequest(localGetAppSimpleDetailRequest);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetAppSimpleDetailEngine
 * JD-Core Version:    0.7.0.1
 */