package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private ck akjE;
  private v akjF;
  
  public final v bKY()
  {
    AppMethodBeat.i(132993);
    h.baF();
    h.baC().aZJ();
    if (this.akjF == null)
    {
      this.akjF = new v();
      this.akjF.appForegroundListener.alive();
    }
    v localv = this.akjF;
    AppMethodBeat.o(132993);
    return localv;
  }
  
  public final ck iGh()
  {
    AppMethodBeat.i(132994);
    h.baF();
    h.baC().aZJ();
    if (this.akjE == null) {
      this.akjE = new ck(new ck.a()
      {
        public final boolean bDt()
        {
          AppMethodBeat.i(132992);
          if (b.this.bKY().oNA == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    ck localck = this.akjE;
    AppMethodBeat.o(132994);
    return localck;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(176851);
    if (MMApplicationContext.isMainProcess()) {
      bKY();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.akjF != null)
    {
      v localv = this.akjF;
      Log.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localv.oNx.size()), Integer.valueOf(localv.oNy.size()), localv.oNA });
      localv.oNx.clear();
      localv.oNy.clear();
      this.akjF.appForegroundListener.dead();
    }
    if (this.akjE != null) {
      this.akjE.bDo();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */