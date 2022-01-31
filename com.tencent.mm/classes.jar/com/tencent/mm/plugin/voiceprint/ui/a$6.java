package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$6
  implements Animation.AnimationListener
{
  a$6(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(26257);
    if (this.tsV != null) {
      this.tsV.cLp();
    }
    AppMethodBeat.o(26257);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(26256);
    if (this.tsV != null) {
      this.tsV.cLo();
    }
    AppMethodBeat.o(26256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.6
 * JD-Core Version:    0.7.0.1
 */