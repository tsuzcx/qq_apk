package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4
  implements Animator.AnimatorListener
{
  c$4(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.vlZ.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(8592);
    this.vlZ.isAnimating = false;
    if (this.vlZ.vlK != null) {
      this.vlZ.vlK.onAnimationEnd();
    }
    AppMethodBeat.o(8592);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(8591);
    this.vlZ.isAnimating = true;
    if (this.vlZ.vlK != null) {
      this.vlZ.vlK.onAnimationStart();
    }
    AppMethodBeat.o(8591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c.4
 * JD-Core Version:    0.7.0.1
 */