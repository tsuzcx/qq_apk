package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class j
{
  HandlerThread handlerThread;
  ak ipC;
  
  public j()
  {
    AppMethodBeat.i(26354);
    if (com.tencent.mm.compatible.util.d.iU(18))
    {
      this.handlerThread = com.tencent.mm.sdk.g.d.aqu("WearWorker_worker_thread");
      this.handlerThread.start();
      this.ipC = new a(this.handlerThread.getLooper());
      ab.i("MicroMsg.Wear.WearWorker", "start worker %d", new Object[] { Integer.valueOf(this.handlerThread.getThreadId()) });
    }
    AppMethodBeat.o(26354);
  }
  
  public final void a(com.tencent.mm.plugin.wear.model.f.d paramd)
  {
    AppMethodBeat.i(26355);
    if (this.ipC != null)
    {
      paramd = this.ipC.obtainMessage(0, paramd);
      this.ipC.sendMessage(paramd);
    }
    AppMethodBeat.o(26355);
  }
  
  final class a
    extends ak
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(26353);
      paramMessage = (com.tencent.mm.plugin.wear.model.f.d)paramMessage.obj;
      if (paramMessage != null) {
        try
        {
          paramMessage.run();
          AppMethodBeat.o(26353);
          return;
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.Wear.WearWorker", localException.getCause(), "run task %s occur exception", new Object[] { paramMessage.getName() });
        }
      }
      AppMethodBeat.o(26353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.j
 * JD-Core Version:    0.7.0.1
 */