package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;

final class ab$c
  implements l
{
  private WeakReference<a> mZt;
  
  public final void eQA() {}
  
  public final void eQB() {}
  
  public final void eQC() {}
  
  public final void eQD()
  {
    AppMethodBeat.i(37124);
    ((m)g.ab(m.class)).atP();
    AppMethodBeat.o(37124);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(37125);
    ((m)g.ab(m.class)).atQ();
    AppMethodBeat.o(37125);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(37126);
    ad.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.mZt == null)
    {
      AppMethodBeat.o(37126);
      return;
    }
    a locala = (a)this.mZt.get();
    if (locala != null)
    {
      y.arz().tC(ab.e.cF(locala));
      ((h)locala.be(h.class)).b(this);
      ((m)g.ab(m.class)).uZ(ab.e.cF(locala));
    }
    AppMethodBeat.o(37126);
  }
  
  public final void eQG() {}
  
  final void n(a parama)
  {
    AppMethodBeat.i(37123);
    this.mZt = new WeakReference(parama);
    ((h)parama.be(h.class)).a(this);
    AppMethodBeat.o(37123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c
 * JD-Core Version:    0.7.0.1
 */