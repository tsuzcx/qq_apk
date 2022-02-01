package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private cc Oeh;
  private q Oei;
  
  public final q aJx()
  {
    AppMethodBeat.i(132993);
    g.ajD();
    g.ajA().aiF();
    if (this.Oei == null)
    {
      this.Oei = new q();
      this.Oei.appForegroundListener.alive();
    }
    q localq = this.Oei;
    AppMethodBeat.o(132993);
    return localq;
  }
  
  public final cc eYC()
  {
    AppMethodBeat.i(132994);
    g.ajD();
    g.ajA().aiF();
    if (this.Oeh == null) {
      this.Oeh = new cc(new cc.a()
      {
        public final boolean aCJ()
        {
          AppMethodBeat.i(132992);
          if (b.this.aJx().igt == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    cc localcc = this.Oeh;
    AppMethodBeat.o(132994);
    return localcc;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(176851);
    if (aj.cmR()) {
      aJx();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.Oei != null)
    {
      q localq = this.Oei;
      ad.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localq.igq.size()), Integer.valueOf(localq.igr.size()), localq.igt });
      localq.igq.clear();
      localq.igr.clear();
      this.Oei.appForegroundListener.dead();
    }
    if (this.Oeh != null) {
      this.Oeh.aCE();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */