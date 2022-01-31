package com.tencent.mm.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$11
  implements Animation.AnimationListener
{
  a$11(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(116383);
    this.AQD.getActionBar().setVisibility(0);
    this.AQD.getFooterBg().setVisibility(0);
    AppMethodBeat.o(116383);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.a.11
 * JD-Core Version:    0.7.0.1
 */