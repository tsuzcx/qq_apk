package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;

final class WepkgMainProcessService$3
  extends Handler
{
  WepkgMainProcessService$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = WepkgMainProcessService.aj(paramMessage.getData());
    WepkgMainProcessTask localWepkgMainProcessTask = WepkgMainProcessService.Dx(i);
    if (localWepkgMainProcessTask == null)
    {
      y.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    WepkgMainProcessService.b(paramMessage, localWepkgMainProcessTask);
    localWepkgMainProcessTask.Zv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.3
 * JD-Core Version:    0.7.0.1
 */