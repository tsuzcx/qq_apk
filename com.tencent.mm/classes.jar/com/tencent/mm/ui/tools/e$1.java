package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements Animator.AnimatorListener
{
  e$1(e parame, e.b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.Avj.Avh = this.Avj.Avf;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(107641);
    if (this.Avi != null) {
      this.Avi.onAnimationEnd();
    }
    this.Avj.Avh = this.Avj.Avf;
    AppMethodBeat.o(107641);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(107640);
    if (this.Avi != null) {
      this.Avi.onAnimationStart();
    }
    this.Avj.Avh = this.Avj.Ave;
    AppMethodBeat.o(107640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.1
 * JD-Core Version:    0.7.0.1
 */