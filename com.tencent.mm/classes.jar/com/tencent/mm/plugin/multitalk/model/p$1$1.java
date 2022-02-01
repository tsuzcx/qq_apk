package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class p$1$1
  implements Runnable
{
  p$1$1(p.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114619);
    if ((p.a(this.tQn.tQm) != null) && (p.a(this.tQn.tQm).cSx()))
    {
      ad.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
      f localf = p.a(this.tQn.tQm);
      if (localf.tPd != null)
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
        localf.a(localf.tPd.tPn, localf.tPd.tPo);
        localf.cSm();
      }
      AppMethodBeat.o(114619);
      return;
    }
    ad.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
    AppMethodBeat.o(114619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p.1.1
 * JD-Core Version:    0.7.0.1
 */