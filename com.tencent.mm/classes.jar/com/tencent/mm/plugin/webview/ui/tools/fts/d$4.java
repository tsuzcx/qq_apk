package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class d$4
  implements Animator.AnimatorListener
{
  d$4(d paramd) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.rvK.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.rvK.isAnimating = false;
    if (this.rvK.rvu != null) {
      this.rvK.rvu.onAnimationEnd();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.rvK.isAnimating = true;
    if (this.rvK.rvu != null) {
      this.rvK.rvu.onAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.4
 * JD-Core Version:    0.7.0.1
 */