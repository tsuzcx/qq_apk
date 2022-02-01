package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cb.a;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private cb Hai;
  private p Haj;
  
  public final p aGm()
  {
    AppMethodBeat.i(132993);
    g.agS();
    g.agP().afT();
    if (this.Haj == null)
    {
      this.Haj = new p();
      this.Haj.appForegroundListener.alive();
    }
    p localp = this.Haj;
    AppMethodBeat.o(132993);
    return localp;
  }
  
  public final cb eJO()
  {
    AppMethodBeat.i(132994);
    g.agS();
    g.agP().afT();
    if (this.Hai == null) {
      this.Hai = new cb(new cb.a()
      {
        public final boolean azG()
        {
          AppMethodBeat.i(132992);
          if (b.this.aGm().hNe == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    cb localcb = this.Hai;
    AppMethodBeat.o(132994);
    return localcb;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(176851);
    if (ai.cin()) {
      aGm();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.Haj != null)
    {
      p localp = this.Haj;
      ac.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localp.hNb.size()), Integer.valueOf(localp.hNc.size()), localp.hNe });
      localp.hNb.clear();
      localp.hNc.clear();
      this.Haj.appForegroundListener.dead();
    }
    if (this.Hai != null) {
      this.Hai.azB();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */