package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;

public final class k$b
  implements Runnable
{
  public k$b(k paramk) {}
  
  public final void run()
  {
    this.muw.muv.dCs = true;
    if (this.muw.muv.kJz != null)
    {
      long l = System.currentTimeMillis();
      if (this.muw.mtQ != null) {
        this.muw.mtQ.a(q.Gj(), this.muw.muv.kJz, this.muw.muv.muy, this.muw.muv.angle);
      }
      l = System.currentTimeMillis() - l;
      if (l > 30L) {
        y.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[] { Long.valueOf(l) });
      }
      this.muw.muv.dCs = false;
    }
    try
    {
      Thread.sleep(20L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      y.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", localInterruptedException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.k.b
 * JD-Core Version:    0.7.0.1
 */