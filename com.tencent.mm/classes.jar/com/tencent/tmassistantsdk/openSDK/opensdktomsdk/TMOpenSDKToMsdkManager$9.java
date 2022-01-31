package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$9
  implements ITMAssistantDownloadSDKClientListener
{
  TMOpenSDKToMsdkManager$9(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    paramTMAssistantDownloadSDKClient = new Message();
    paramTMAssistantDownloadSDKClient.what = 1;
    paramString = new Bundle();
    paramString.putLong("receiveDataLen", paramLong1);
    paramString.putLong("totalDataLen", paramLong2);
    paramTMAssistantDownloadSDKClient.setData(paramString);
    this.this$0.mMainMessageHandler.sendMessage(paramTMAssistantDownloadSDKClient);
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    TMLog.i("OpensdkToMsdkManager", "OnDownloadSDKTaskStateChanged client:" + paramTMAssistantDownloadSDKClient + " | state:" + paramInt1 + " | errorcode:" + paramInt2 + " | errorMsg:" + paramString2);
    if ((paramTMAssistantDownloadSDKClient == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      if (4 == paramInt1)
      {
        this.this$0.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.9.1(this, paramTMAssistantDownloadSDKClient, paramString1));
        return;
      }
    } while (5 != paramInt1);
    paramTMAssistantDownloadSDKClient = new Message();
    paramTMAssistantDownloadSDKClient.what = 3;
    this.this$0.mMainMessageHandler.sendMessage(paramTMAssistantDownloadSDKClient);
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.9
 * JD-Core Version:    0.7.0.1
 */