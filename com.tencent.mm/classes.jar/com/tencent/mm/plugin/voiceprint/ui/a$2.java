package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements Animation.AnimationListener
{
  a$2(a.a parama, int paramInt, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.pNc != null) {
      this.pNc.bPi();
    }
    y.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
    paramAnimation = new TranslateAnimation(0, this.pNd, 0, 0.0F, 1, 0.0F, 1, 0.0F);
    paramAnimation.setDuration(200L);
    paramAnimation.setStartOffset(0L);
    paramAnimation.setRepeatMode(-1);
    paramAnimation.setRepeatCount(0);
    paramAnimation.setFillAfter(true);
    paramAnimation.setAnimationListener(new a.2.1(this));
    this.izj.startAnimation(paramAnimation);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a.2
 * JD-Core Version:    0.7.0.1
 */