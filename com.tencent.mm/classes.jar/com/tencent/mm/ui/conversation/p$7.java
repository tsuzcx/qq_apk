package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

final class p$7
  implements Runnable
{
  p$7(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(38729);
    if (!aj.eFA())
    {
      aj.uS(true);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38728);
          ad.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
          com.tencent.mm.g.a.a locala = new com.tencent.mm.g.a.a();
          com.tencent.mm.sdk.b.a.ESL.l(locala);
          AppMethodBeat.o(38728);
        }
      }, 100L);
    }
    g.KJ(8);
    AppMethodBeat.o(38729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.7
 * JD-Core Version:    0.7.0.1
 */