package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class y$3$2$1
  implements Animation.AnimationListener
{
  y$3$2$1(y.3.2 param2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(145307);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "hide rollTipView");
    this.rxS.rxR.rxQ.rxJ.setVisibility(8);
    this.rxS.rxR.rxQ.abj("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
    this.rxS.rxR.rxQ.rxN = false;
    AppMethodBeat.o(145307);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.3.2.1
 * JD-Core Version:    0.7.0.1
 */