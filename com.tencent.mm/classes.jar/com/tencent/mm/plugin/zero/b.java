package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private cj SuO;
  private q SuP;
  
  public final q bnn()
  {
    AppMethodBeat.i(132993);
    h.aHH();
    h.aHE().aGH();
    if (this.SuP == null)
    {
      this.SuP = new q();
      this.SuP.appForegroundListener.alive();
    }
    q localq = this.SuP;
    AppMethodBeat.o(132993);
    return localq;
  }
  
  public final cj hfr()
  {
    AppMethodBeat.i(132994);
    h.aHH();
    h.aHE().aGH();
    if (this.SuO == null) {
      this.SuO = new cj(new cj.a()
      {
        public final boolean bfB()
        {
          AppMethodBeat.i(132992);
          if (b.this.bnn().lUH == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    cj localcj = this.SuO;
    AppMethodBeat.o(132994);
    return localcj;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(176851);
    if (MMApplicationContext.isMainProcess()) {
      bnn();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.SuP != null)
    {
      q localq = this.SuP;
      Log.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localq.lUE.size()), Integer.valueOf(localq.lUF.size()), localq.lUH });
      localq.lUE.clear();
      localq.lUF.clear();
      this.SuP.appForegroundListener.dead();
    }
    if (this.SuO != null) {
      this.SuO.bfw();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */