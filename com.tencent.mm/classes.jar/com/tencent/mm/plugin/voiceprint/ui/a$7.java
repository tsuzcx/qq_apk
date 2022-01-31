package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$7
  implements Animation.AnimationListener
{
  a$7(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(26259);
    if (this.tsV != null) {
      this.tsV.cLp();
    }
    AppMethodBeat.o(26259);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(26258);
    if (this.tsV != null) {
      this.tsV.cLo();
    }
    AppMethodBeat.o(26258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.7
 * JD-Core Version:    0.7.0.1
 */