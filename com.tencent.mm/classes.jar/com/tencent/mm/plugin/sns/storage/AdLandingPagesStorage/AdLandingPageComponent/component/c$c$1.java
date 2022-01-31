package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.y;

final class c$c$1
  implements Runnable
{
  c$c$1(c.c paramc) {}
  
  public final void run()
  {
    if (this.oFn.oFi == 1)
    {
      c.c localc = this.oFn;
      y.d("AdLandingCarouselComp", "onDraggin first visible " + localc.oFe.oFb.gY() + ", last visible " + localc.oFe.oFb.ha());
      c.a(localc.oFe);
      this.oFn.heQ.postDelayed(this.oFn.oFm, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.c.1
 * JD-Core Version:    0.7.0.1
 */