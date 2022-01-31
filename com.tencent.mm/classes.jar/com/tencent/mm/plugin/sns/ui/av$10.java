package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class av$10
  implements Animation.AnimationListener
{
  av$10(av paramav) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(39412);
    if (this.rXd.rWS != null)
    {
      this.rXd.rWS.clearAnimation();
      this.rXd.rWS.setVisibility(8);
    }
    this.rXd.rWS = null;
    AppMethodBeat.o(39412);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.10
 * JD-Core Version:    0.7.0.1
 */