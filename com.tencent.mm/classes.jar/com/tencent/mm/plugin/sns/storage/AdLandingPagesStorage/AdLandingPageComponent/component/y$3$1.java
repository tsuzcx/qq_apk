package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$3$1
  implements Animation.AnimationListener
{
  y$3$1(y.3 param3) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(145306);
    this.rxR.rxQ.rxK.setVisibility(8);
    this.rxR.rxQ.rxK.setImageDrawable(null);
    this.rxR.rxQ.rxJ.setVisibility(0);
    paramAnimation = ObjectAnimator.ofFloat(this.rxR.rxQ.rxJ, "alpha", new float[] { 0.0F, 1.0F });
    paramAnimation.setDuration(400L);
    paramAnimation.start();
    AppMethodBeat.o(145306);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.3.1
 * JD-Core Version:    0.7.0.1
 */