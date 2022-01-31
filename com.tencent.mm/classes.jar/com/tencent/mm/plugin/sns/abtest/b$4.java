package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class b$4
  implements Animation.AnimationListener
{
  b$4(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(35674);
    al.d(new b.4.1(this));
    this.qYg.qYe = false;
    AppMethodBeat.o(35674);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.qYg.qYe = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b.4
 * JD-Core Version:    0.7.0.1
 */