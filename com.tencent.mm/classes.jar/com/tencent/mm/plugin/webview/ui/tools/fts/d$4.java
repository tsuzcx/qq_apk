package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements Animator.AnimatorListener
{
  d$4(d paramd) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.vma.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(8603);
    this.vma.isAnimating = false;
    if (this.vma.vlK != null) {
      this.vma.vlK.onAnimationEnd();
    }
    AppMethodBeat.o(8603);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(8602);
    this.vma.isAnimating = true;
    if (this.vma.vlK != null) {
      this.vma.vlK.onAnimationStart();
    }
    AppMethodBeat.o(8602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.4
 * JD-Core Version:    0.7.0.1
 */