package com.tencent.tmassistantsdk.openSDK;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

class DownloadStateChangedReceiver$1
  implements Runnable
{
  DownloadStateChangedReceiver$1(DownloadStateChangedReceiver paramDownloadStateChangedReceiver, Intent paramIntent) {}
  
  public void run()
  {
    AppMethodBeat.i(75839);
    TMQQDownloaderStateChangeParam localTMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
    localTMQQDownloaderStateChangeParam.hostPackageName = this.val$intent.getStringExtra("hostPackageName");
    localTMQQDownloaderStateChangeParam.hostVersion = this.val$intent.getStringExtra("hostVersion");
    localTMQQDownloaderStateChangeParam.taskId = this.val$intent.getStringExtra("taskId");
    localTMQQDownloaderStateChangeParam.errorCode = bo.getInt(this.val$intent.getStringExtra("errorCode"), 0);
    localTMQQDownloaderStateChangeParam.errorMsg = this.val$intent.getStringExtra("errorMsg");
    localTMQQDownloaderStateChangeParam.state = bo.getInt(this.val$intent.getStringExtra("state"), 0);
    Object localObject = new TMQQDownloaderOpenSDKParam();
    ((TMQQDownloaderOpenSDKParam)localObject).SNGAppId = this.val$intent.getStringExtra("sngAppId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskAppId = this.val$intent.getStringExtra("taskAppId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskApkId = this.val$intent.getStringExtra("taskApkId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskPackageName = this.val$intent.getStringExtra("taskPackageName");
    ((TMQQDownloaderOpenSDKParam)localObject).taskVersion = bo.getInt(this.val$intent.getStringExtra("taskVersion"), 0);
    ((TMQQDownloaderOpenSDKParam)localObject).via = this.val$intent.getStringExtra("via");
    ((TMQQDownloaderOpenSDKParam)localObject).uin = this.val$intent.getStringExtra("uin");
    ((TMQQDownloaderOpenSDKParam)localObject).uinType = this.val$intent.getStringExtra("uinType");
    localTMQQDownloaderStateChangeParam.param = ((TMQQDownloaderOpenSDKParam)localObject);
    localObject = this.this$0.mListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IDownloadStateChangedListener)((Iterator)localObject).next()).onDownloadStateChanged(localTMQQDownloaderStateChangeParam);
    }
    AppMethodBeat.o(75839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver.1
 * JD-Core Version:    0.7.0.1
 */