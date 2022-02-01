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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private cb Lwi;
  private p Lwj;
  
  public final p azv()
  {
    AppMethodBeat.i(132993);
    g.afC();
    g.afz().aeD();
    if (this.Lwj == null)
    {
      this.Lwj = new p();
      this.Lwj.appForegroundListener.alive();
    }
    p localp = this.Lwj;
    AppMethodBeat.o(132993);
    return localp;
  }
  
  public final cb euv()
  {
    AppMethodBeat.i(132994);
    g.afC();
    g.afz().aeD();
    if (this.Lwi == null) {
      this.Lwi = new cb(new cb.a()
      {
        public final boolean asP()
        {
          AppMethodBeat.i(132992);
          if (b.this.azv().hmB == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    cb localcb = this.Lwi;
    AppMethodBeat.o(132994);
    return localcb;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(176851);
    if (aj.cbe()) {
      azv();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.Lwj != null)
    {
      p localp = this.Lwj;
      ad.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localp.hmy.size()), Integer.valueOf(localp.hmz.size()), localp.hmB });
      localp.hmy.clear();
      localp.hmz.clear();
      this.Lwj.appForegroundListener.dead();
    }
    if (this.Lwi != null) {
      this.Lwi.asK();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */