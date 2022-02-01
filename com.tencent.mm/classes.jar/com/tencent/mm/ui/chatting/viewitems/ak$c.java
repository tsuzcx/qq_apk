package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.api.l;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.o;
import java.lang.ref.WeakReference;

final class ak$c
  implements o
{
  private WeakReference<a> vKQ;
  
  public final void jjf() {}
  
  public final void jjg() {}
  
  public final void jjh() {}
  
  public final void jji()
  {
    AppMethodBeat.i(37100);
    if (this.vKQ == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.vKQ.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().KJ(p.el(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(37101);
    if (this.vKQ == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.vKQ.get();
    if (locala != null) {
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().KI(p.el(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(37102);
    Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.vKQ == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.vKQ.get();
    if (locala != null)
    {
      ad.bCb().Jn(p.el(locala));
      ((l)locala.cm(l.class)).b(this);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).KK(p.el(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void jjl() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.vKQ = new WeakReference(parama);
    ((l)parama.cm(l.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.c
 * JD-Core Version:    0.7.0.1
 */