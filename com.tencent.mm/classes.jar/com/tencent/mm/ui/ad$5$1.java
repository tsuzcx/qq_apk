package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ad$5$1
  implements Animation.AnimationListener
{
  ad$5$1(ad.5 param5) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ad.b(this.uQc.uPW);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    ad.a(this.uQc.uPW);
    this.uQc.uPW.z(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ad.5.1
 * JD-Core Version:    0.7.0.1
 */