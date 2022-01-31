package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.u.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

final class p$c
  implements m
{
  private WeakReference<a> vDl;
  
  public final void cyM() {}
  
  public final void cyN() {}
  
  public final void cyO() {}
  
  public final void cyP()
  {
    if (this.vDl == null) {}
    a locala;
    do
    {
      return;
      locala = (a)this.vDl.get();
    } while (locala == null);
    ((e)g.r(e.class)).Jm().jt(o.aX(locala));
  }
  
  public final void cyQ()
  {
    if (this.vDl == null) {}
    a locala;
    do
    {
      return;
      locala = (a)this.vDl.get();
    } while (locala == null);
    ((e)g.r(e.class)).Jm().js(o.aX(locala));
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
    u.Hc().ii(o.aX(locala));
    ((f)locala.ac(f.class)).b(this);
    ((e)g.r(e.class)).ju(o.aX(locala));
  }
  
  public final void cyS() {}
  
  final void j(a parama)
  {
    this.vDl = new WeakReference(parama);
    ((f)parama.ac(f.class)).a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.c
 * JD-Core Version:    0.7.0.1
 */