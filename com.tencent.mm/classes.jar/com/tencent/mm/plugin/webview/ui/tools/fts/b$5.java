package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class b$5
  implements Animator.AnimatorListener
{
  b$5(b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.rvH.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.rvH.isAnimating = false;
    if (this.rvH.rvu != null) {
      this.rvH.rvu.onAnimationEnd();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.rvH.isAnimating = true;
    if (this.rvH.rvu != null) {
      this.rvH.rvu.onAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b.5
 * JD-Core Version:    0.7.0.1
 */