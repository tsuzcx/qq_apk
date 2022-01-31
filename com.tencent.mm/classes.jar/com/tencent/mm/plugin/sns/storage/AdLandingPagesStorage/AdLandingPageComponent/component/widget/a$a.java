package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.h.a.si;
import com.tencent.mm.h.a.si.a;
import com.tencent.mm.sdk.b.c;
import java.lang.ref.WeakReference;

final class a$a
  extends c<si>
{
  int hkH = 0;
  int ofa = 0;
  int ofb = 0;
  WeakReference<a> ofc;
  
  public a$a(a parama)
  {
    super(0);
    this.ofc = new WeakReference(parama);
    this.udX = si.class.getName().hashCode();
  }
  
  private void a(si paramsi)
  {
    this.ofa = paramsi.cbT.cbW;
    this.ofb = paramsi.cbT.cbU;
    this.hkH = paramsi.cbT.cbV;
  }
  
  private boolean bBg()
  {
    if (this.ofc.get() == null) {
      return false;
    }
    int i = a.D((a)this.ofc.get()) + this.ofa;
    return (i >= this.ofb) && (i <= this.hkH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.a
 * JD-Core Version:    0.7.0.1
 */