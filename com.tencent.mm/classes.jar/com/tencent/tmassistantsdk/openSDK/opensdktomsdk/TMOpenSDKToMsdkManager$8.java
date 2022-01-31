package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$8
  implements Runnable
{
  TMOpenSDKToMsdkManager$8(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager, String paramString) {}
  
  public void run()
  {
    TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = this.this$0.getClient();
    try
    {
      if (localTMAssistantDownloadSDKClient.getDownloadTaskState(this.val$downloadUrl) != null)
      {
        localTMAssistantDownloadSDKClient.pauseDownloadTask(this.val$downloadUrl);
        return;
      }
      TMLog.i("OpensdkToMsdkManager", "getDownloadTaskState taskinfo is null!");
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.8
 * JD-Core Version:    0.7.0.1
 */