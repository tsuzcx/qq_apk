package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.f;
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
    if (!aj.fkz())
    {
      aj.wG(true);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38728);
          ad.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
          com.tencent.mm.g.a.a locala = new com.tencent.mm.g.a.a();
          com.tencent.mm.sdk.b.a.IbL.l(locala);
          AppMethodBeat.o(38728);
        }
      }, 100L);
    }
    f.Ok(8);
    AppMethodBeat.o(38729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.7
 * JD-Core Version:    0.7.0.1
 */