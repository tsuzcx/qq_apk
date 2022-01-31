package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.a;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
{
  public j.a appForegroundListener;
  public com.tencent.mm.sdk.b.c vHa;
  public final com.tencent.mm.sdk.b.c vHb;
  
  public c()
  {
    AppMethodBeat.i(63636);
    this.appForegroundListener = new j.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(141555);
        if ((g.RG()) && (g.RJ().eHg))
        {
          g.RJ();
          if (!com.tencent.mm.kernel.a.QP())
          {
            paramAnonymousString = new wi();
            paramAnonymousString.cNO.coO = 3;
            com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(141555);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(141554);
        if ((g.RG()) && (g.RJ().eHg))
        {
          g.RJ();
          if (!com.tencent.mm.kernel.a.QP())
          {
            paramAnonymousString = new wi();
            paramAnonymousString.cNO.coO = 5;
            com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(141554);
      }
    };
    this.vHa = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qh paramAnonymousqh)
      {
        AppMethodBeat.i(141556);
        boolean bool = paramAnonymousqh.cGV.cwK;
        ab.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) && (bo.gz(bo.c((Long)g.RL().Ru().get(ac.a.yHo, Long.valueOf(0L)))) > 60L))
        {
          g.RL().Ru().set(ac.a.yHo, Long.valueOf(bo.aox()));
          c.a(c.this, 2);
        }
        AppMethodBeat.o(141556);
        return false;
      }
    };
    this.vHb = new c.3(this);
    AppMethodBeat.o(63636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */