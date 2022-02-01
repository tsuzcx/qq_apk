package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$8
  implements Runnable
{
  TMOpenSDKToMsdkManager$8(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(102173);
    TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = this.this$0.getClient();
    try
    {
      if (localTMAssistantDownloadSDKClient.getDownloadTaskState(this.val$downloadUrl) != null)
      {
        localTMAssistantDownloadSDKClient.pauseDownloadTask(this.val$downloadUrl);
        AppMethodBeat.o(102173);
        return;
      }
      TMLog.i("OpensdkToMsdkManager", "getDownloadTaskState taskinfo is null!");
      AppMethodBeat.o(102173);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
      AppMethodBeat.o(102173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.8
 * JD-Core Version:    0.7.0.1
 */