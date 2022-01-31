package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class b$2
  implements Animation.AnimationListener
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.ojV.ojF != null) {
      this.ojV.ojF.setVisibility(0);
    }
    this.ojV.ojT = false;
    this.ojV.ojR = true;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.ojV.ojT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b.2
 * JD-Core Version:    0.7.0.1
 */