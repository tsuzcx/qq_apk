package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

final class c$1
  extends o.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114801);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      a.aiT();
    }
    AppMethodBeat.o(114801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114800);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!a.aiT()) {
        b.Wq().u(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114799);
            u localu = c.eys();
            u.b localb = localu.Cvq;
            if (localb != null)
            {
              ae.i("MicroMsg.Voip.VoipService", "on voip resume");
              String str = localb.toUser;
              boolean bool1 = localb.CvE;
              boolean bool2 = localb.CvF;
              long l = localb.uXg;
              localu.dtg();
              localu.a(ak.getContext(), str, l, bool1, bool2, true);
              AppMethodBeat.o(114799);
              return;
            }
            ae.i("MicroMsg.Voip.VoipService", "do not need voip resume");
            AppMethodBeat.o(114799);
          }
        });
      }
    }
    AppMethodBeat.o(114800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.1
 * JD-Core Version:    0.7.0.1
 */