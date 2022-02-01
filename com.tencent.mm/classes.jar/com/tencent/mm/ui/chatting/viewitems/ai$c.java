package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

final class ai$c
  implements m
{
  private WeakReference<a> pvS;
  
  public final void cFx()
  {
    AppMethodBeat.i(37100);
    if (this.pvS == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.pvS.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().Lo(n.cO(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(37101);
    if (this.pvS == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.pvS.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().Ln(n.cO(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void gIk() {}
  
  public final void gIl() {}
  
  public final void gIm() {}
  
  public final void gIn()
  {
    AppMethodBeat.i(37102);
    Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.pvS == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.pvS.get();
    if (locala != null)
    {
      ad.aVe().JW(n.cO(locala));
      ((j)locala.bh(j.class)).b(this);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).Lp(n.cO(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void gIo() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.pvS = new WeakReference(parama);
    ((j)parama.bh(j.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.c
 * JD-Core Version:    0.7.0.1
 */