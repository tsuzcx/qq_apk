package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class TMOpenSDKToMsdkManager$9$1
  implements Runnable
{
  TMOpenSDKToMsdkManager$9$1(TMOpenSDKToMsdkManager.9 param9, TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = this.val$client.getDownloadTaskState(this.val$url).mSavePath;
      if (!TextUtils.isEmpty(str))
      {
        Message localMessage = new Message();
        localMessage.what = 0;
        localMessage.obj = str;
        this.this$1.this$0.mMainMessageHandler.sendMessage(localMessage);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.9.1
 * JD-Core Version:    0.7.0.1
 */