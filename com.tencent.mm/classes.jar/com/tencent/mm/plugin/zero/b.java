package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.ce.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private ce Jiq;
  private q LGh;
  
  public final q aJQ()
  {
    AppMethodBeat.i(132993);
    g.ajS();
    g.ajP().aiU();
    if (this.LGh == null)
    {
      this.LGh = new q();
      this.LGh.appForegroundListener.alive();
    }
    q localq = this.LGh;
    AppMethodBeat.o(132993);
    return localq;
  }
  
  public final ce fcq()
  {
    AppMethodBeat.i(132994);
    g.ajS();
    g.ajP().aiU();
    if (this.Jiq == null) {
      this.Jiq = new ce(new ce.a()
      {
        public final boolean aCZ()
        {
          AppMethodBeat.i(132992);
          if (b.this.aJQ().ijm == null)
          {
            AppMethodBeat.o(132992);
            return true;
          }
          AppMethodBeat.o(132992);
          return false;
        }
      });
    }
    ce localce = this.Jiq;
    AppMethodBeat.o(132994);
    return localce;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(176851);
    if (ak.coh()) {
      aJQ();
    }
    AppMethodBeat.o(176851);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132995);
    if (this.LGh != null)
    {
      q localq = this.LGh;
      ae.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localq.ijj.size()), Integer.valueOf(localq.ijk.size()), localq.ijm });
      localq.ijj.clear();
      localq.ijk.clear();
      this.LGh.appForegroundListener.dead();
    }
    if (this.Jiq != null) {
      this.Jiq.aCU();
    }
    AppMethodBeat.o(132995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */