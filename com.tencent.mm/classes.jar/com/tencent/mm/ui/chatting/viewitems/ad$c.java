package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class ad$c
  implements l
{
  private WeakReference<a> ojW;
  
  public final void fAs() {}
  
  public final void fAt() {}
  
  public final void fAu() {}
  
  public final void fAv()
  {
    AppMethodBeat.i(37124);
    ((m)g.ab(m.class)).aDZ();
    AppMethodBeat.o(37124);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(37125);
    ((m)g.ab(m.class)).aEa();
    AppMethodBeat.o(37125);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(37126);
    ae.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.ojW == null)
    {
      AppMethodBeat.o(37126);
      return;
    }
    a locala = (a)this.ojW.get();
    if (locala != null)
    {
      z.aBG().Bq(ad.e.cH(locala));
      ((j)locala.bh(j.class)).b(this);
      ((m)g.ab(m.class)).CG(ad.e.cH(locala));
    }
    AppMethodBeat.o(37126);
  }
  
  public final void fAy() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37123);
    this.ojW = new WeakReference(parama);
    ((j)parama.bh(j.class)).a(this);
    AppMethodBeat.o(37123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.c
 * JD-Core Version:    0.7.0.1
 */