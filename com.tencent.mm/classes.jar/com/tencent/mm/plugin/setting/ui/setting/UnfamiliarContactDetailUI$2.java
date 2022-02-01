package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class UnfamiliarContactDetailUI$2
  implements Animation.AnimationListener
{
  UnfamiliarContactDetailUI$2(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(74569);
    UnfamiliarContactDetailUI.l(this.Dfg).setVisibility(0);
    AppMethodBeat.o(74569);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.2
 * JD-Core Version:    0.7.0.1
 */