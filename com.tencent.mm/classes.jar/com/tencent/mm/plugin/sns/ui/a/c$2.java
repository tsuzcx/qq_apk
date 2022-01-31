package com.tencent.mm.plugin.sns.ui.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class c$2
  extends AnimatorListenerAdapter
{
  c$2(c paramc) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.plh.plf != null) {
      this.plh.plf.onAnimationEnd();
    }
    this.plh.view.setVisibility(8);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (this.plh.plf != null) {
      this.plh.plf.onAnimationStart();
    }
    this.plh.view.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c.2
 * JD-Core Version:    0.7.0.1
 */