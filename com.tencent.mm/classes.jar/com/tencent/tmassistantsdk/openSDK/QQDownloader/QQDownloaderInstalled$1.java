package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

class QQDownloaderInstalled$1
  extends Thread
{
  QQDownloaderInstalled$1(QQDownloaderInstalled paramQQDownloaderInstalled, Context paramContext) {}
  
  public void run()
  {
    AppMethodBeat.i(75851);
    if (this.this$0.mListener != null) {
      this.this$0.mListener.onQQDownloaderInstalled(this.val$context);
    }
    AppMethodBeat.o(75851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.1
 * JD-Core Version:    0.7.0.1
 */