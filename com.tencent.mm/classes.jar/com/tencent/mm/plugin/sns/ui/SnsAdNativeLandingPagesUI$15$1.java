package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SnsAdNativeLandingPagesUI$15$1
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsAdNativeLandingPagesUI$15$1(SnsAdNativeLandingPagesUI.15 param15, RecyclerView paramRecyclerView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(38642);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(this.rNa.rMW).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(this.rNa.rMW)) });
    Object localObject1 = null;
    Object localObject2 = SnsAdNativeLandingPagesUI.d(this.rNa.rMW);
    int i;
    if (localObject2 != null)
    {
      localObject1 = ((y)localObject2).crs();
      if (localObject1 != null)
      {
        localObject1 = ((p)localObject1).rrf;
        localObject1 = a.gv((String)localObject1, "scene_ad_landing");
        localObject2 = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.e(this.rNa.rMW).getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.e(this.rNa.rMW).getHeight()).append(", shootImg.w=");
        if (localObject1 == null) {
          break label235;
        }
        i = ((Bitmap)localObject1).getWidth();
        label150:
        localObject2 = ((StringBuilder)localObject2).append(i).append(", shootImg.h=");
        if (localObject1 == null) {
          break label240;
        }
        i = ((Bitmap)localObject1).getHeight();
        label170:
        ab.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
      }
    }
    else
    {
      if (!SnsAdNativeLandingPagesUI.f(this.rNa.rMW)) {
        break label245;
      }
      al.p(new SnsAdNativeLandingPagesUI.15.1.1(this, (Bitmap)localObject1), 50L);
    }
    for (;;)
    {
      this.jiz.getViewTreeObserver().removeOnPreDrawListener(this);
      AppMethodBeat.o(38642);
      return false;
      localObject1 = "";
      break;
      label235:
      i = 0;
      break label150;
      label240:
      i = 0;
      break label170;
      label245:
      SnsAdNativeLandingPagesUI.i(this.rNa.rMW).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.15.1
 * JD-Core Version:    0.7.0.1
 */