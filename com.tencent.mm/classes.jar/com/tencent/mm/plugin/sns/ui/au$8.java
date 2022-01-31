package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class au$8
  implements Animation.AnimationListener
{
  au$8(au paramau) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.pep.pef != null)
    {
      this.pep.pef.clearAnimation();
      this.pep.pef.setVisibility(8);
    }
    this.pep.pef = null;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.8
 * JD-Core Version:    0.7.0.1
 */