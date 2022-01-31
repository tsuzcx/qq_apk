package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

final class WepkgMainProcessService$1
  extends Handler
{
  WepkgMainProcessService$1(WepkgMainProcessService paramWepkgMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    WepkgMainProcessTask localWepkgMainProcessTask = WepkgMainProcessService.aj(paramMessage.getData());
    Messenger localMessenger = paramMessage.replyTo;
    int i = paramMessage.what;
    localWepkgMainProcessTask.geD = localMessenger;
    localWepkgMainProcessTask.mTaskId = i;
    localWepkgMainProcessTask.Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */