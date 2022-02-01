package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.ci.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private ci UtK;
  private q UtL;
  
  public final q bdS()
  {
    AppMethodBeat.i(132993);
    g.aAi();
    g.aAf().azk();
    if (this.UtL == null)
    {
      this.UtL = new q();
      this.UtL.appForegroundListener.alive();
    }
    q localq = this.UtL;
    AppMethodBeat.o(132993);
    return localq;
  }
  
  public final ci glA()
  {
    AppMethodBeat.i(132994);
    g.aAi();
    g.aAf().azk();
    if (this.UtK == null) {
      this.UtK = new ci(new ci.a()
      {
        public final boolean aWx()
        {
          AppMethodBeat.i(132992);
          if (b.this.bdS().jei == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    ci localci = this.UtK;
    AppMethodBeat.o(132994);
    return localci;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(176851);
    if (MMApplicationContext.isMainProcess()) {
      bdS();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.UtL != null)
    {
      q localq = this.UtL;
      Log.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localq.jef.size()), Integer.valueOf(localq.jeg.size()), localq.jei });
      localq.jef.clear();
      localq.jeg.clear();
      this.UtL.appForegroundListener.dead();
    }
    if (this.UtK != null) {
      this.UtK.aWs();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */