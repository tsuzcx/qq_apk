package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Animation.AnimationListener
{
  a$1(a.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.pNb != null) {
      this.pNb.bPj();
    }
    y.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.1
 * JD-Core Version:    0.7.0.1
 */