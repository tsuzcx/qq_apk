package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class z$1$1
  implements Runnable
{
  z$1$1(z.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114619);
    if ((z.a(this.wsL.wsK) != null) && (z.a(this.wsL.wsK).cbt()))
    {
      ae.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
      o localo = z.a(this.wsL.wsK);
      if (localo.wrs != null)
      {
        ae.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
        localo.a(localo.wrs.wrF, localo.wrs.wrG);
        localo.dtg();
      }
      AppMethodBeat.o(114619);
      return;
    }
    ae.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
    AppMethodBeat.o(114619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z.1.1
 * JD-Core Version:    0.7.0.1
 */