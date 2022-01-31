package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

final class c$3
  implements Animator.AnimatorListener
{
  c$3(c paramc) {}
  
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
    this.rvJ.rvl.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c.3
 * JD-Core Version:    0.7.0.1
 */