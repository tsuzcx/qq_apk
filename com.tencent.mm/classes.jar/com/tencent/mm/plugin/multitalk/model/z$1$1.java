package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class z$1$1
  implements Runnable
{
  z$1$1(z.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114619);
    if ((z.a(this.wdj.wdi) != null) && (z.a(this.wdj.wdi).cae()))
    {
      ad.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
      o localo = z.a(this.wdj.wdi);
      if (localo.wbT != null)
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
        localo.a(localo.wbT.wcd, localo.wbT.wce);
        localo.dpU();
      }
      AppMethodBeat.o(114619);
      return;
    }
    ad.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
    AppMethodBeat.o(114619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z.1.1
 * JD-Core Version:    0.7.0.1
 */