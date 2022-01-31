package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class a$2
  implements Animation.AnimationListener
{
  a$2(a parama, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.startAnimation(a.b(this.nbA));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a.2
 * JD-Core Version:    0.7.0.1
 */