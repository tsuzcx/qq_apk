package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class m$2
  implements Animator.AnimatorListener
{
  m$2(m paramm) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(187398);
    ad.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
    AppMethodBeat.o(187398);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(187397);
    this.xar.uc.start();
    ad.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
    AppMethodBeat.o(187397);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(187399);
    ad.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
    AppMethodBeat.o(187399);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(187396);
    ad.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
    AppMethodBeat.o(187396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.2
 * JD-Core Version:    0.7.0.1
 */