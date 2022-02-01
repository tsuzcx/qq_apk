package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class ab$c
  implements l
{
  private WeakReference<a> nBR;
  
  public final void fgg() {}
  
  public final void fgh() {}
  
  public final void fgi() {}
  
  public final void fgj()
  {
    AppMethodBeat.i(37100);
    if (this.nBR == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.nBR.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAB().zc(m.cE(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(37101);
    if (this.nBR == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.nBR.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAB().zb(m.cE(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(37102);
    ac.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.nBR == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.nBR.get();
    if (locala != null)
    {
      y.ayq().xI(m.cE(locala));
      ((h)locala.bf(h.class)).b(this);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).zd(m.cE(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void fgm() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.nBR = new WeakReference(parama);
    ((h)parama.bf(h.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c
 * JD-Core Version:    0.7.0.1
 */