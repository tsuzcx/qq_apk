package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.event.IListener;
import java.util.Collection;
import java.util.Iterator;

public final class n
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final n XWP;
  private final IListener XWQ;
  private final p wUJ;
  
  static
  {
    AppMethodBeat.i(152052);
    XWP = new n();
    AppMethodBeat.o(152052);
  }
  
  public n()
  {
    AppMethodBeat.i(152049);
    this.wUJ = new n.1(this);
    this.XWQ = new PinResDownloaderCore.2(this, f.hfK);
    AppMethodBeat.o(152049);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(152050);
    paramc = q.iJL().iterator();
    while (paramc.hasNext()) {
      ((g)paramc.next()).iJh();
    }
    h.baD().a(this.wUJ);
    this.XWQ.alive();
    AppMethodBeat.o(152050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152051);
    h.baD().b(this.wUJ);
    this.XWQ.dead();
    Iterator localIterator = q.iJL().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onAccountRelease();
    }
    AppMethodBeat.o(152051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.n
 * JD-Core Version:    0.7.0.1
 */