package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ViewAnimHelper$4
  implements Animator.AnimatorListener
{
  ViewAnimHelper$4(Animator.AnimatorListener paramAnimatorListener) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(143615);
    if (this.xck != null) {
      this.xck.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(143615);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(143614);
    if (this.xck != null) {
      this.xck.onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(143614);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(143616);
    if (this.xck != null) {
      this.xck.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(143616);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(143613);
    if (this.xck != null) {
      this.xck.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(143613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper.4
 * JD-Core Version:    0.7.0.1
 */