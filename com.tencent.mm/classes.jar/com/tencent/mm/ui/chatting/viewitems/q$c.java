package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

final class q$c
  implements m
{
  private WeakReference<a> vDl;
  
  public final void cyM() {}
  
  public final void cyN() {}
  
  public final void cyO() {}
  
  public final void cyP()
  {
    ((k)g.r(k.class)).Jq();
  }
  
  public final void cyQ()
  {
    ((k)g.r(k.class)).Jr();
  }
  
  public final void cyR()
  {
    y.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
    if (this.vDl == null) {}
    a locala;
    do
    {
      return;
      locala = (a)this.vDl.get();
    } while (locala == null);
    u.Hc().ii(q.e.aX(locala));
    ((f)locala.ac(f.class)).b(this);
    ((k)g.r(k.class)).jw(q.e.aX(locala));
  }
  
  public final void cyS() {}
  
  final void j(a parama)
  {
    this.vDl = new WeakReference(parama);
    ((f)parama.ac(f.class)).a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */