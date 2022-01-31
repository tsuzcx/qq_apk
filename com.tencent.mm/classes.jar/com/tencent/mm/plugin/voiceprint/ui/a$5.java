package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements Animation.AnimationListener
{
  a$5(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(26255);
    if (this.tsV != null) {
      this.tsV.cLp();
    }
    AppMethodBeat.o(26255);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(26254);
    if (this.tsV != null) {
      this.tsV.cLo();
    }
    AppMethodBeat.o(26254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.5
 * JD-Core Version:    0.7.0.1
 */