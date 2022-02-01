package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.z.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class ac$c
  implements l
{
  private WeakReference<a> oeg;
  
  public final void fws() {}
  
  public final void fwt() {}
  
  public final void fwu() {}
  
  public final void fwv()
  {
    AppMethodBeat.i(37100);
    if (this.oeg == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.oeg.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDE().Cb(n.cG(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(37101);
    if (this.oeg == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.oeg.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDE().Ca(n.cG(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(37102);
    ad.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.oeg == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.oeg.get();
    if (locala != null)
    {
      y.aBq().AG(n.cG(locala));
      ((j)locala.bh(j.class)).b(this);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).Cc(n.cG(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void fwy() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.oeg = new WeakReference(parama);
    ((j)parama.bh(j.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.c
 * JD-Core Version:    0.7.0.1
 */