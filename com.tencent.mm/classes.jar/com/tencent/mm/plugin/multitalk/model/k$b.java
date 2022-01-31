package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;

public final class k$b
  implements Runnable
{
  public k$b(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(54061);
    this.oUl.oUk.ezJ = true;
    if (this.oUl.oUk.nfX != null)
    {
      long l = System.currentTimeMillis();
      if (this.oUl.oTC != null) {
        this.oUl.oTC.a(r.Zn(), this.oUl.oUk.nfX, this.oUl.oUk.oUn, this.oUl.oUk.angle);
      }
      l = System.currentTimeMillis() - l;
      if (l > 30L) {
        ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[] { Long.valueOf(l) });
      }
      this.oUl.oUk.ezJ = false;
    }
    try
    {
      Thread.sleep(20L);
      AppMethodBeat.o(54061);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", localInterruptedException, "", new Object[0]);
      AppMethodBeat.o(54061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.k.b
 * JD-Core Version:    0.7.0.1
 */