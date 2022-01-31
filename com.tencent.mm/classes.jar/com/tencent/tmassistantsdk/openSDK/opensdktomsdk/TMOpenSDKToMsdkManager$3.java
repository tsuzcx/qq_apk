package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;

class TMOpenSDKToMsdkManager$3
  implements Runnable
{
  TMOpenSDKToMsdkManager$3(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void run()
  {
    AppMethodBeat.i(75922);
    try
    {
      Object localObject = this.this$0.getClient().getDownloadTaskState(this.this$0.mDownloadUrl);
      Message localMessage;
      if (localObject != null)
      {
        if (((TMAssistantDownloadTaskInfo)localObject).mState != 3) {
          break label143;
        }
        localMessage = new Message();
        localMessage.what = 6;
        Bundle localBundle = new Bundle();
        localBundle.putLong("receiveDataLen", ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen);
        localBundle.putLong("totalDataLen", ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
        localMessage.setData(localBundle);
        this.this$0.mMainMessageHandler.sendMessage(localMessage);
      }
      while ((localObject != null) && (((TMAssistantDownloadTaskInfo)localObject).mState == 4))
      {
        localObject = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
        ((TipsInfoLog)localObject).installTipsCount += 1;
        TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject);
        AppMethodBeat.o(75922);
        return;
        label143:
        if (((TMAssistantDownloadTaskInfo)localObject).mState == 4)
        {
          localMessage = new Message();
          localMessage.what = 0;
          localMessage.arg1 = 1;
          localMessage.obj = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          this.this$0.mMainMessageHandler.sendMessage(localMessage);
        }
      }
      localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
      AppMethodBeat.o(75922);
      return;
    }
    TipsInfoLog localTipsInfoLog;
    localTipsInfoLog.downloadTipsCount += 1;
    TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
    AppMethodBeat.o(75922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.3
 * JD-Core Version:    0.7.0.1
 */