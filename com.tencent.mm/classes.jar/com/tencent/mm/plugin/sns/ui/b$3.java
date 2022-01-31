package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class b$3
  implements Animation.AnimationListener
{
  b$3(b paramb, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.ovR != null)
    {
      this.ovR.clearAnimation();
      this.ovR.setVisibility(8);
      this.oMj.bEx();
    }
    this.oMj.ovC = false;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.oMj.ovC = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.3
 * JD-Core Version:    0.7.0.1
 */