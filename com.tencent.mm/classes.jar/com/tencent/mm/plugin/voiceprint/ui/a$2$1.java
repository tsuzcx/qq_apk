package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$1
  implements Animation.AnimationListener
{
  a$2$1(a.2 param2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(26250);
    ab.i("MicroMsg.VoiceViewAnimationHelper", "next end");
    if (this.tsY.tsW != null) {
      this.tsY.tsW.cLp();
    }
    AppMethodBeat.o(26250);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.2.1
 * JD-Core Version:    0.7.0.1
 */