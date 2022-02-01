package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class p$2
  implements Animator.AnimatorListener
{
  p$2(p paramp) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(307029);
    Log.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
    AppMethodBeat.o(307029);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(307027);
    this.QPk.cis.start();
    Log.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
    AppMethodBeat.o(307027);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(307032);
    Log.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
    AppMethodBeat.o(307032);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(307019);
    Log.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
    AppMethodBeat.o(307019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p.2
 * JD-Core Version:    0.7.0.1
 */