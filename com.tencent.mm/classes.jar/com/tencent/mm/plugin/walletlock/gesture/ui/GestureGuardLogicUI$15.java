package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GestureGuardLogicUI$15
  implements Animation.AnimationListener
{
  GestureGuardLogicUI$15(GestureGuardLogicUI paramGestureGuardLogicUI, GestureGuardLogicUI.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(51600);
    GestureGuardLogicUI.s(this.uFf).setAnimationListener(null);
    if (this.uFi != null) {
      this.uFi.onDone();
    }
    AppMethodBeat.o(51600);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.15
 * JD-Core Version:    0.7.0.1
 */