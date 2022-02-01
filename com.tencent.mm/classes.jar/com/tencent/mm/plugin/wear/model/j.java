package com.tencent.mm.plugin.wear.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class j
{
  ap lRx;
  
  public j()
  {
    AppMethodBeat.i(30036);
    if (com.tencent.mm.compatible.util.d.lA(18))
    {
      this.lRx = new a("WearWorker_worker_thread");
      ad.i("MicroMsg.Wear.WearWorker", "start worker");
    }
    AppMethodBeat.o(30036);
  }
  
  public final void a(com.tencent.mm.plugin.wear.model.f.d paramd)
  {
    AppMethodBeat.i(30037);
    if (this.lRx != null)
    {
      paramd = this.lRx.obtainMessage(0, paramd);
      this.lRx.sendMessage(paramd);
    }
    AppMethodBeat.o(30037);
  }
  
  final class a
    extends ap
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
          ad.printErrStackTrace("MicroMsg.Wear.WearWorker", localException.getCause(), "run task %s occur exception", new Object[] { paramMessage.getName() });
        }
      }
      AppMethodBeat.o(30035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.j
 * JD-Core Version:    0.7.0.1
 */