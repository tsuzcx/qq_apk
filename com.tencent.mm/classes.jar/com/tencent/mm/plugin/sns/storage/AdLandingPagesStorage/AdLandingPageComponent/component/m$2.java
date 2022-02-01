package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class m$2
  implements Animator.AnimatorListener
{
  m$2(m paramm) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(200198);
    ac.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
    AppMethodBeat.o(200198);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(200197);
    this.yng.vc.start();
    ac.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
    AppMethodBeat.o(200197);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(200199);
    ac.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
    AppMethodBeat.o(200199);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(200196);
    ac.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
    AppMethodBeat.o(200196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.2
 * JD-Core Version:    0.7.0.1
 */