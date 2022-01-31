package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class h$4
  extends AnimatorListenerAdapter
{
  h$4(h paramh) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(145698);
    ab.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
    this.sfq.sfo.rMB.setScaleX(1.0F);
    this.sfq.sfo.rMB.setScaleY(1.0F);
    this.sfq.sfo.rMB.setAlpha(1.0F);
    this.sfq.sfo.sgi.setAlpha(1.0F);
    this.sfq.sfo.sgj.setAlpha(1.0F);
    if (this.sfq.seT != null) {
      this.sfq.seT.onAnimationEnd();
    }
    this.sfq.sfo.rxI.crT();
    this.sfq.sfo.rxI.rzX.requestRender();
    AppMethodBeat.o(145698);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145697);
    ab.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
    AppMethodBeat.o(145697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h.4
 * JD-Core Version:    0.7.0.1
 */