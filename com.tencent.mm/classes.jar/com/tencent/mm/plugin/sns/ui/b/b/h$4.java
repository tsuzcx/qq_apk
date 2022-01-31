package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;

final class h$4
  extends AnimatorListenerAdapter
{
  h$4(h paramh) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(145712);
    ab.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
    this.sfC.sfA.rMB.setScaleX(1.0F);
    this.sfC.sfA.rMB.setScaleY(1.0F);
    this.sfC.sfA.rMB.setAlpha(1.0F);
    this.sfC.sfA.sfT.setAlpha(1.0F);
    this.sfC.sfA.sfU.setAlpha(1.0F);
    if (this.sfC.seT != null) {
      this.sfC.seT.onAnimationEnd();
    }
    this.sfC.sfA.siz.crT();
    this.sfC.sfA.siz.rzX.requestRender();
    this.sfC.sfA.ezJ = false;
    AppMethodBeat.o(145712);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145711);
    ab.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
    AppMethodBeat.o(145711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h.4
 * JD-Core Version:    0.7.0.1
 */