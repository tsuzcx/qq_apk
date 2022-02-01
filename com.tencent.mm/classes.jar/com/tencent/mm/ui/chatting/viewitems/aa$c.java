package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class aa$c
  implements l
{
  private WeakReference<a> mZt;
  
  public final void eQA() {}
  
  public final void eQB() {}
  
  public final void eQC() {}
  
  public final void eQD()
  {
    AppMethodBeat.i(37100);
    if (this.mZt == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.mZt.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().uW(m.cF(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(37101);
    if (this.mZt == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.mZt.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().uV(m.cF(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(37102);
    ad.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.mZt == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.mZt.get();
    if (locala != null)
    {
      y.arz().tC(m.cF(locala));
      ((h)locala.be(h.class)).b(this);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).uX(m.cF(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void eQG() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.mZt = new WeakReference(parama);
    ((h)parama.be(h.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.c
 * JD-Core Version:    0.7.0.1
 */