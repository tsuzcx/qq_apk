package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WepkgMainProcessService$3
  extends Handler
{
  WepkgMainProcessService$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(63483);
    int i = paramMessage.what;
    paramMessage = WepkgMainProcessService.aB(paramMessage.getData());
    WepkgMainProcessTask localWepkgMainProcessTask = WepkgMainProcessService.Lp(i);
    if (localWepkgMainProcessTask == null)
    {
      ab.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(63483);
      return;
    }
    WepkgMainProcessService.b(paramMessage, localWepkgMainProcessTask);
    localWepkgMainProcessTask.atb();
    AppMethodBeat.o(63483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.3
 * JD-Core Version:    0.7.0.1
 */