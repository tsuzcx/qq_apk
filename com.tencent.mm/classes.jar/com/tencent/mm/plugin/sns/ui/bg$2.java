package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class bg$2
  implements Animation.AnimationListener
{
  bg$2(bg parambg, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.ovR != null)
    {
      this.ovR.setVisibility(8);
      this.pkl.bHw();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg.2
 * JD-Core Version:    0.7.0.1
 */