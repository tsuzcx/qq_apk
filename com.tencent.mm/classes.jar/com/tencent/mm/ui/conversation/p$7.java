package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

final class p$7
  implements Runnable
{
  p$7(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(38729);
    if (!ai.eUU())
    {
      ai.vU(true);
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38728);
          ac.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
          com.tencent.mm.g.a.a locala = new com.tencent.mm.g.a.a();
          com.tencent.mm.sdk.b.a.GpY.l(locala);
          AppMethodBeat.o(38728);
        }
      }, 100L);
    }
    g.MI(8);
    AppMethodBeat.o(38729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.7
 * JD-Core Version:    0.7.0.1
 */