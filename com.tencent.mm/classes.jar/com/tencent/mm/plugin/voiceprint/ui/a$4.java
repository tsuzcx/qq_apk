package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  implements Animation.AnimationListener
{
  a$4(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(26253);
    if (this.tsV != null) {
      this.tsV.cLp();
    }
    AppMethodBeat.o(26253);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.4
 * JD-Core Version:    0.7.0.1
 */