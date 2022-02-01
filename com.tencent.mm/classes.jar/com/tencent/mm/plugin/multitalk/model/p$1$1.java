package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class p$1$1
  implements Runnable
{
  p$1$1(p.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114619);
    if ((p.a(this.uYN.uYM) != null) && (p.a(this.uYN.uYM).bVB()))
    {
      ac.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
      f localf = p.a(this.uYN.uYM);
      if (localf.uXF != null)
      {
        ac.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
        localf.a(localf.uXF.uXO, localf.uXF.uXP);
        localf.dfW();
      }
      AppMethodBeat.o(114619);
      return;
    }
    ac.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
    AppMethodBeat.o(114619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p.1.1
 * JD-Core Version:    0.7.0.1
 */