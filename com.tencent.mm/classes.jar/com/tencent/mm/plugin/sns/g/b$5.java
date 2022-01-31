package com.tencent.mm.plugin.sns.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$5
  implements Animation.AnimationListener
{
  b$5(b paramb, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(36760);
    if (this.rkM != null)
    {
      this.rkM.clearAnimation();
      this.rkM.setVisibility(8);
      this.rkL.cpX();
    }
    this.rkL.rkx = false;
    AppMethodBeat.o(36760);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.rkL.rkx = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b.5
 * JD-Core Version:    0.7.0.1
 */