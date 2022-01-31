package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class b$5
  implements Animation.AnimationListener
{
  b$5(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(35676);
    al.d(new b.5.1(this));
    this.qYg.qYe = false;
    AppMethodBeat.o(35676);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.qYg.qYe = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b.5
 * JD-Core Version:    0.7.0.1
 */