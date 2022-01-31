package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.y;

final class a$c
  implements Runnable
{
  a.b oID;
  int ofg;
  volatile boolean stop = false;
  
  public a$c(a parama)
  {
    y.i("MicroMsg.SightPlayController", "make sure drawJob alive");
  }
  
  public final void run()
  {
    if (this.stop)
    {
      y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()) });
      return;
    }
    this.oIA.G(a.B(this.oIA));
    if (a.r(this.oIA) == 0L)
    {
      o.g(this.oID, 0L);
      return;
    }
    long l = this.oIA.oes - (System.currentTimeMillis() - a.r(this.oIA));
    if (l > 0L)
    {
      o.g(this.oID, l);
      return;
    }
    o.g(this.oID, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.c
 * JD-Core Version:    0.7.0.1
 */