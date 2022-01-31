package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WepkgMainProcessService$1
  extends Handler
{
  WepkgMainProcessService$1(WepkgMainProcessService paramWepkgMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(63480);
    WepkgMainProcessTask localWepkgMainProcessTask = WepkgMainProcessService.aB(paramMessage.getData());
    Messenger localMessenger = paramMessage.replyTo;
    int i = paramMessage.what;
    localWepkgMainProcessTask.hwC = localMessenger;
    localWepkgMainProcessTask.mTaskId = i;
    localWepkgMainProcessTask.ata();
    AppMethodBeat.o(63480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */