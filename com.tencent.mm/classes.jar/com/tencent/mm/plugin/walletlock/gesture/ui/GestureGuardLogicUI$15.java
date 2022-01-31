package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class GestureGuardLogicUI$15
  implements Animation.AnimationListener
{
  GestureGuardLogicUI$15(GestureGuardLogicUI paramGestureGuardLogicUI, GestureGuardLogicUI.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    GestureGuardLogicUI.s(this.qPX).setAnimationListener(null);
    if (this.qQa != null) {
      this.qQa.onDone();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.15
 * JD-Core Version:    0.7.0.1
 */