package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114799);
    u localu = c.euM();
    u.b localb = localu.CdP;
    if (localb != null)
    {
      ad.i("MicroMsg.Voip.VoipService", "on voip resume");
      String str = localb.toUser;
      boolean bool1 = localb.Ced;
      boolean bool2 = localb.Cee;
      long l = localb.uLt;
      localu.dpU();
      localu.a(aj.getContext(), str, l, bool1, bool2, true);
      AppMethodBeat.o(114799);
      return;
    }
    ad.i("MicroMsg.Voip.VoipService", "do not need voip resume");
    AppMethodBeat.o(114799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.1.1
 * JD-Core Version:    0.7.0.1
 */