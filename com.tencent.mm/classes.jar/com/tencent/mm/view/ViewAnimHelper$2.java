package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ViewAnimHelper$2
  implements Animator.AnimatorListener
{
  ViewAnimHelper$2(Animator.AnimatorListener paramAnimatorListener) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(164327);
    if (this.yqm != null) {
      this.yqm.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(164327);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(164326);
    if (this.yqm != null) {
      this.yqm.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(164326);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(164328);
    if (this.yqm != null) {
      this.yqm.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(164328);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(164325);
    if (this.yqm != null) {
      this.yqm.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(164325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper.2
 * JD-Core Version:    0.7.0.1
 */