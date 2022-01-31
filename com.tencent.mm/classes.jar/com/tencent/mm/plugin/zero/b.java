package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private by vIS;
  private o vIT;
  
  public final o aio()
  {
    AppMethodBeat.i(58743);
    g.RM();
    g.RJ().QQ();
    if (this.vIT == null)
    {
      this.vIT = new o();
      this.vIT.appForegroundListener.alive();
    }
    o localo = this.vIT;
    AppMethodBeat.o(58743);
    return localo;
  }
  
  public final by dkL()
  {
    AppMethodBeat.i(58744);
    g.RM();
    g.RJ().QQ();
    if (this.vIS == null) {
      this.vIS = new by(new b.1(this));
    }
    by localby = this.vIS;
    AppMethodBeat.o(58744);
    return localby;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(58745);
    if (this.vIT != null)
    {
      o localo = this.vIT;
      ab.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localo.fJv.size()), Integer.valueOf(localo.fJw.size()), localo.fJy });
      localo.fJv.clear();
      localo.fJw.clear();
      this.vIT.appForegroundListener.dead();
    }
    if (this.vIS != null) {
      this.vIS.abj();
    }
    AppMethodBeat.o(58745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */