package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Matrix;

final class a$a$2
  implements Animator.AnimatorListener
{
  a$a$2(a.a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.wxy.bur = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.wxy.wxw != null) {
      this.wxy.wxw.tW();
    }
    this.wxy.bur = true;
    this.wxy.wxs.wxk.set(this.wxy.wxs.bzW);
    this.wxy.wxs.wxq = (this.wxy.wxs.d(this.wxy.wxs.wxk) * 1.0F);
    if (this.wxy.wxv)
    {
      this.wxy.wxs.wxp = (this.wxy.wxs.d(this.wxy.wxs.wxk) * 3.0F);
      a.a.a(this.wxy);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (this.wxy.wxw != null) {
      this.wxy.wxw.onStart();
    }
    this.wxy.bur = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b.a.a.2
 * JD-Core Version:    0.7.0.1
 */