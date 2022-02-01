package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;

final class al$c
  implements com.tencent.mm.ui.n
{
  private WeakReference<a> sFk;
  
  public final void hGU() {}
  
  public final void hGV() {}
  
  public final void hGW() {}
  
  public final void hGX()
  {
    AppMethodBeat.i(37100);
    if (this.sFk == null)
    {
      AppMethodBeat.o(37100);
      return;
    }
    a locala = (a)this.sFk.get();
    if (locala != null) {
      ((g)h.ae(g.class)).bgQ().SH(com.tencent.mm.plugin.appbrand.ac.n.cP(locala));
    }
    AppMethodBeat.o(37100);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(37101);
    if (this.sFk == null)
    {
      AppMethodBeat.o(37101);
      return;
    }
    a locala = (a)this.sFk.get();
    if (locala != null) {
      ((g)h.ae(g.class)).bgQ().SG(com.tencent.mm.plugin.appbrand.ac.n.cP(locala));
    }
    AppMethodBeat.o(37101);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(37102);
    Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.sFk == null)
    {
      AppMethodBeat.o(37102);
      return;
    }
    a locala = (a)this.sFk.get();
    if (locala != null)
    {
      ad.beh().Ro(com.tencent.mm.plugin.appbrand.ac.n.cP(locala));
      ((j)locala.bC(j.class)).b(this);
      ((g)h.ae(g.class)).SI(com.tencent.mm.plugin.appbrand.ac.n.cP(locala));
    }
    AppMethodBeat.o(37102);
  }
  
  public final void hHa() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37099);
    this.sFk = new WeakReference(parama);
    ((j)parama.bC(j.class)).a(this);
    AppMethodBeat.o(37099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.c
 * JD-Core Version:    0.7.0.1
 */