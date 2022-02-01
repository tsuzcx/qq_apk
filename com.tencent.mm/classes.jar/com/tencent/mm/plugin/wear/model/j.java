package com.tencent.mm.plugin.wear.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class j
{
  MMHandler qdR;
  
  public j()
  {
    AppMethodBeat.i(30036);
    if (com.tencent.mm.compatible.util.d.qX(18))
    {
      this.qdR = new a("WearWorker_worker_thread");
      Log.i("MicroMsg.Wear.WearWorker", "start worker");
    }
    AppMethodBeat.o(30036);
  }
  
  public final void a(com.tencent.mm.plugin.wear.model.f.d paramd)
  {
    AppMethodBeat.i(30037);
    if (this.qdR != null)
    {
      paramd = this.qdR.obtainMessage(0, paramd);
      this.qdR.sendMessage(paramd);
    }
    AppMethodBeat.o(30037);
  }
  
  final class a
    extends MMHandler
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30035);
      paramMessage = (com.tencent.mm.plugin.wear.model.f.d)paramMessage.obj;
      if (paramMessage != null) {
        try
        {
          paramMessage.run();
          AppMethodBeat.o(30035);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Wear.WearWorker", localException.getCause(), "run task %s occur exception", new Object[] { paramMessage.getName() });
        }
      }
      AppMethodBeat.o(30035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.j
 * JD-Core Version:    0.7.0.1
 */