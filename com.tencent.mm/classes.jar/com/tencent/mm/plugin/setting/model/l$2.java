package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

final class l$2
  implements Runnable
{
  l$2(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(126868);
    try
    {
      this.qEX.qEP.await();
      long l = System.currentTimeMillis();
      this.qEX.qEQ.clear();
      this.qEX.qER.remove(r.Zn());
      this.qEX.qEQ.addAll(this.qEX.qER);
      this.qEX.qEQ.addAll(this.qEX.qES);
      this.qEX.qEQ.addAll(this.qEX.qET);
      if (this.qEX.qEN) {
        this.qEX.qEQ.retainAll(this.qEX.qET);
      }
      if (this.qEX.qEO) {
        this.qEX.qEQ.retainAll(this.qEX.qES);
      }
      if (this.qEX.qEM) {
        this.qEX.qEQ.retainAll(this.qEX.qER);
      }
      this.qEX.qEV.e(this.qEX.qEQ);
      ab.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      al.d(new l.2.1(this));
      ab.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.qEX.qEW) });
      AppMethodBeat.o(126868);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ab.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", localInterruptedException, "", new Object[0]);
      al.d(new l.2.2(this));
      AppMethodBeat.o(126868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.2
 * JD-Core Version:    0.7.0.1
 */