package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;

class TMOpenSDKToMsdkManager$1
  implements ah.a
{
  TMOpenSDKToMsdkManager$1(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (AuthorizedResult)paramMessage.obj;
      if (paramMessage != null)
      {
        this.this$0.onNetworkFinishedSuccess(paramMessage);
        continue;
        int i = ((Integer)paramMessage.obj).intValue();
        this.this$0.onNetworkFinishedFailed(i);
        continue;
        i = paramMessage.arg1;
        paramMessage = paramMessage.obj.toString();
        this.this$0.handleInstall(paramMessage, i);
        continue;
        paramMessage = paramMessage.getData();
        if (paramMessage != null)
        {
          this.this$0.handleDownloading(paramMessage.getLong("receiveDataLen"), paramMessage.getLong("totalDataLen"));
          continue;
          paramMessage = paramMessage.getData();
          if (paramMessage != null)
          {
            this.this$0.handleDownloadContinue(paramMessage.getLong("receiveDataLen"), paramMessage.getLong("totalDataLen"));
            continue;
            this.this$0.handleDownloadFailed();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.1
 * JD-Core Version:    0.7.0.1
 */