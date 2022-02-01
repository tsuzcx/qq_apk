package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class c$1
  extends n.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114801);
    if ((g.afw()) && (g.afz().gcn))
    {
      g.afz();
      a.aeC();
    }
    AppMethodBeat.o(114801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114800);
    if ((g.afw()) && (g.afz().gcn))
    {
      g.afz();
      if (!a.aeC()) {
        b.SX().v(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114799);
            u localu = c.dRQ();
            if (localu.zmb != null)
            {
              ad.i("MicroMsg.Voip.VoipService", "on voip resume");
              String str = localu.zmb.toUser;
              boolean bool1 = localu.zmb.zmp;
              boolean bool2 = localu.zmb.zmq;
              localu.cSm();
              localu.a(aj.getContext(), str, bool1, bool2, true);
              AppMethodBeat.o(114799);
              return;
            }
            ad.i("MicroMsg.Voip.VoipService", "do not need voip resume");
            AppMethodBeat.o(114799);
          }
        });
      }
    }
    AppMethodBeat.o(114800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.1
 * JD-Core Version:    0.7.0.1
 */