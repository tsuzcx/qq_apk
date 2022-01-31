package com.tencent.mm.plugin.sns.ui.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

final class b$2
  extends AnimatorListenerAdapter
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.plg.plf != null) {
      this.plg.plf.onAnimationEnd();
    }
    this.plg.view.setVisibility(8);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.plg.view.getLayoutParams();
    paramAnimator.leftMargin = this.plg.plb;
    paramAnimator.topMargin = this.plg.plc;
    ViewGroup localViewGroup = (ViewGroup)this.plg.view.getParent();
    paramAnimator.rightMargin = (localViewGroup.getWidth() - this.plg.pld - paramAnimator.leftMargin);
    paramAnimator.bottomMargin = (localViewGroup.getHeight() - this.plg.ple - paramAnimator.topMargin);
    this.plg.view.setLayoutParams(paramAnimator);
    this.plg.view.setVisibility(0);
    if (this.plg.plf != null) {
      this.plg.plf.onAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.2
 * JD-Core Version:    0.7.0.1
 */