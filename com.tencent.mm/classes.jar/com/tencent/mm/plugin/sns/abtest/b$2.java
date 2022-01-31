package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Animation.AnimationListener
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(35671);
    if (this.qYg.qXQ != null) {
      this.qYg.qXQ.setVisibility(0);
    }
    this.qYg.qYe = false;
    this.qYg.qYc = true;
    AppMethodBeat.o(35671);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.qYg.qYe = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b.2
 * JD-Core Version:    0.7.0.1
 */