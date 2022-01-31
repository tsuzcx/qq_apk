package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class be$2
  implements Animation.AnimationListener
{
  be$2(be parambe, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(39882);
    if (this.rkM != null)
    {
      this.rkM.setVisibility(8);
      this.scP.ctC();
    }
    AppMethodBeat.o(39882);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be.2
 * JD-Core Version:    0.7.0.1
 */