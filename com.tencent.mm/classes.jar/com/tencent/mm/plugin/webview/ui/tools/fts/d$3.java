package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements Animator.AnimatorListener
{
  d$3(d paramd) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.vma.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(8601);
    this.vma.isAnimating = false;
    if (this.vma.vlK != null) {
      this.vma.vlK.onAnimationEnd();
    }
    AppMethodBeat.o(8601);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(8600);
    this.vma.isAnimating = true;
    if (this.vma.vlK != null) {
      this.vma.vlK.onAnimationStart();
    }
    this.vma.vlA.setVisibility(0);
    AppMethodBeat.o(8600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.3
 * JD-Core Version:    0.7.0.1
 */