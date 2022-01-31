package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class c$4
  implements Animator.AnimatorListener
{
  c$4(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.rvJ.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.rvJ.isAnimating = false;
    if (this.rvJ.rvu != null) {
      this.rvJ.rvu.onAnimationEnd();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.rvJ.isAnimating = true;
    if (this.rvJ.rvu != null) {
      this.rvJ.rvu.onAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c.4
 * JD-Core Version:    0.7.0.1
 */