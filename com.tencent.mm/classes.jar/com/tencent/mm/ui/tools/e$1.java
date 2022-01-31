package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class e$1
  implements Animator.AnimatorListener
{
  e$1(e parame, e.b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.wcP.wcN = this.wcP.wcL;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.wcO != null) {
      this.wcO.onAnimationEnd();
    }
    this.wcP.wcN = this.wcP.wcL;
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (this.wcO != null) {
      this.wcO.onAnimationStart();
    }
    this.wcP.wcN = this.wcP.wcK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.1
 * JD-Core Version:    0.7.0.1
 */