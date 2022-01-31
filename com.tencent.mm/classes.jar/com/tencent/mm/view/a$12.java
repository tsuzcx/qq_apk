package com.tencent.mm.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$12
  implements Animation.AnimationListener
{
  a$12(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(116384);
    this.AQD.getActionBar().setVisibility(8);
    this.AQD.getFooterBg().setVisibility(8);
    AppMethodBeat.o(116384);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.12
 * JD-Core Version:    0.7.0.1
 */