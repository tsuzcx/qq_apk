package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$9
  implements ITMAssistantDownloadSDKClientListener
{
  TMOpenSDKToMsdkManager$9(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102176);
    paramTMAssistantDownloadSDKClient = new Message();
    paramTMAssistantDownloadSDKClient.what = 1;
    paramString = new Bundle();
    paramString.putLong("receiveDataLen", paramLong1);
    paramString.putLong("totalDataLen", paramLong2);
    paramTMAssistantDownloadSDKClient.setData(paramString);
    this.this$0.mMainMessageHandler.sendMessage(paramTMAssistantDownloadSDKClient);
    AppMethodBeat.o(102176);
  }
  
  public void OnDownloadSDKTaskStateChanged(final TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, final String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102175);
    TMLog.i("OpensdkToMsdkManager", "OnDownloadSDKTaskStateChanged client:" + paramTMAssistantDownloadSDKClient + " | state:" + paramInt1 + " | errorcode:" + paramInt2 + " | errorMsg:" + paramString2);
    if ((paramTMAssistantDownloadSDKClient == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(102175);
      return;
    }
    if (4 == paramInt1)
    {
      this.this$0.mSubMessageHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(102174);
          try
          {
            String str = paramTMAssistantDownloadSDKClient.getDownloadTaskState(paramString1).mSavePath;
            if (!TextUtils.isEmpty(str))
            {
              Message localMessage = new Message();
              localMessage.what = 0;
              localMessage.obj = str;
              TMOpenSDKToMsdkManager.9.this.this$0.mMainMessageHandler.sendMessage(localMessage);
            }
            AppMethodBeat.o(102174);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
            AppMethodBeat.o(102174);
          }
        }
      });
      AppMethodBeat.o(102175);
      return;
    }
    if (5 == paramInt1)
    {
      paramTMAssistantDownloadSDKClient = new Message();
      paramTMAssistantDownloadSDKClient.what = 3;
      this.this$0.mMainMessageHandler.sendMessage(paramTMAssistantDownloadSDKClient);
    }
    AppMethodBeat.o(102175);
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.9
 * JD-Core Version:    0.7.0.1
 */