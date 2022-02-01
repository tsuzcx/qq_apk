package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.n;
import java.lang.ref.WeakReference;

final class am$c
  implements n
{
  private WeakReference<a> sFk;
  
  public final void hGU() {}
  
  public final void hGV() {}
  
  public final void hGW() {}
  
  public final void hGX()
  {
    AppMethodBeat.i(37124);
    ((m)h.ae(m.class)).bgV();
    AppMethodBeat.o(37124);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(37125);
    ((m)h.ae(m.class)).bgW();
    AppMethodBeat.o(37125);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(37126);
    Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.sFk == null)
    {
      AppMethodBeat.o(37126);
      return;
    }
    a locala = (a)this.sFk.get();
    if (locala != null)
    {
      ad.beh().Ro(am.e.cP(locala));
      ((j)locala.bC(j.class)).b(this);
      ((m)h.ae(m.class)).SK(am.e.cP(locala));
    }
    AppMethodBeat.o(37126);
  }
  
  public final void hHa() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37123);
    this.sFk = new WeakReference(parama);
    ((j)parama.bC(j.class)).a(this);
    AppMethodBeat.o(37123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.c
 * JD-Core Version:    0.7.0.1
 */