package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class br$4
  implements Animation.AnimationListener
{
  br$4(br parambr, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(99760);
    if (this.zpx != null)
    {
      this.zpx.clearAnimation();
      this.zpx.setVisibility(8);
      this.AqE.edR();
    }
    this.AqE.zpi = false;
    AppMethodBeat.o(99760);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.AqE.zpi = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.4
 * JD-Core Version:    0.7.0.1
 */