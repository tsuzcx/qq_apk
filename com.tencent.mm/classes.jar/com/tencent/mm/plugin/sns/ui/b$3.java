package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Animation.AnimationListener
{
  b$3(b paramb, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(38066);
    if (this.rkM != null)
    {
      this.rkM.clearAnimation();
      this.rkM.setVisibility(8);
      this.rDU.cpX();
    }
    this.rDU.rkx = false;
    AppMethodBeat.o(38066);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.rDU.rkx = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.3
 * JD-Core Version:    0.7.0.1
 */