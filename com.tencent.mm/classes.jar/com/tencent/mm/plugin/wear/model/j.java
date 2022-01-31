package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  ah gNQ;
  HandlerThread handlerThread;
  
  public j()
  {
    if (com.tencent.mm.compatible.util.d.gH(18))
    {
      this.handlerThread = e.aap("WearWorker_worker_thread");
      this.handlerThread.start();
      this.gNQ = new a(this.handlerThread.getLooper());
      y.i("MicroMsg.Wear.WearWorker", "start worker %d", new Object[] { Integer.valueOf(this.handlerThread.getThreadId()) });
    }
  }
  
  public final void a(com.tencent.mm.plugin.wear.model.f.d paramd)
  {
    if (this.gNQ != null)
    {
      paramd = this.gNQ.obtainMessage(0, paramd);
      this.gNQ.sendMessage(paramd);
    }
  }
  
  private final class a
    extends ah
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      paramMessage = (com.tencent.mm.plugin.wear.model.f.d)paramMessage.obj;
      if (paramMessage != null) {}
      try
      {
        paramMessage.run();
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Wear.WearWorker", localException.getCause(), "run task %s occur exception", new Object[] { paramMessage.getName() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.j
 * JD-Core Version:    0.7.0.1
 */