package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.y.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class ac$c
  implements l
{
  private WeakReference<a> ojW;
  
  public final void fAs() {}
  
  public final void fAt() {}
  
  public final void fAu() {}
  
  public final void fAv()
  {
    AppMethodBeat.i(37100);
    if (this.ojW == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.ojW.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDU().CD(n.cH(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(37101);
    if (this.ojW == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.ojW.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDU().CC(n.cH(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(37102);
    ae.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.ojW == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.ojW.get();
    if (locala != null)
    {
      z.aBG().Bq(n.cH(locala));
      ((j)locala.bh(j.class)).b(this);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).CE(n.cH(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void fAy() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.ojW = new WeakReference(parama);
    ((j)parama.bh(j.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.c
 * JD-Core Version:    0.7.0.1
 */