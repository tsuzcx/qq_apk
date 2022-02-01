package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class c$1
  extends n.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114801);
    if ((g.agM()) && (g.agP().ggT))
    {
      g.agP();
      a.afS();
    }
    AppMethodBeat.o(114801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114800);
    if ((g.agM()) && (g.agP().ggT))
    {
      g.agP();
      if (!a.afS()) {
        b.TR().w(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114799);
            u localu = c.ehb();
            u.b localb = localu.AEP;
            if (localb != null)
            {
              ac.i("MicroMsg.Voip.VoipService", "on voip resume");
              String str = localb.toUser;
              boolean bool1 = localb.AFd;
              boolean bool2 = localb.AFe;
              localu.dfW();
              localu.a(ai.getContext(), str, bool1, bool2, true);
              AppMethodBeat.o(114799);
              return;
            }
            ac.i("MicroMsg.Voip.VoipService", "do not need voip resume");
            AppMethodBeat.o(114799);
          }
        });
      }
    }
    AppMethodBeat.o(114800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.1
 * JD-Core Version:    0.7.0.1
 */