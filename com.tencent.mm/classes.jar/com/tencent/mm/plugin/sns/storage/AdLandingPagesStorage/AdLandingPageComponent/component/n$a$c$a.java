package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$c$a
  implements a.a
{
  private n$a$c$a(n.a.c paramc) {}
  
  public final void bCA()
  {
    y.i("LogStateTransitionState", "paused");
    n.a(this.oGr.oGp.oGd).Ff(7);
  }
  
  public final void bCB() {}
  
  public final void bCC()
  {
    n.a(this.oGr.oGp.oGd).Ff(9);
  }
  
  public final void bCD()
  {
    n.a(this.oGr.oGp.oGd).Ff(8);
  }
  
  public final void bCE() {}
  
  public final void start() {}
  
  public final void xE(int paramInt)
  {
    n.a locala = n.a(this.oGr.oGp.oGd);
    d.c localc = locala.ujd;
    if (localc != null) {
      localc.sendMessage(Message.obtain(locala.ujd, 1, paramInt, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.c.a
 * JD-Core Version:    0.7.0.1
 */