package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.plugin.voip.floatcard.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;

final class SubCoreVoip$1
  extends q.a
{
  SubCoreVoip$1(SubCoreVoip paramSubCoreVoip) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114801);
    if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
    {
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.kernel.b.aZG();
    }
    AppMethodBeat.o(114801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114800);
    if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
    {
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZG()) {
        com.tencent.mm.blink.b.aJY().arrange(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114799);
            com.tencent.threadpool.h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(292223);
                u localu = SubCoreVoip.hVp();
                if (localu.UCa.Mxl)
                {
                  Log.i("MicroMsg.Voip.VoipService", "no allow to show main ui");
                  localu.ggh();
                  AppMethodBeat.o(292223);
                  return;
                }
                u.b localb = localu.UBP;
                if (localb != null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "on voip resume");
                  String str = localb.toUser;
                  boolean bool1 = localb.OEa;
                  boolean bool2 = localb.UvH;
                  long l = localb.Hnt;
                  localu.ggh();
                  localu.a(MMApplicationContext.getContext(), str, l, bool1, bool2, true);
                  AppMethodBeat.o(292223);
                  return;
                }
                Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
                AppMethodBeat.o(292223);
              }
            });
            AppMethodBeat.o(114799);
          }
        });
      }
    }
    AppMethodBeat.o(114800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.SubCoreVoip.1
 * JD-Core Version:    0.7.0.1
 */