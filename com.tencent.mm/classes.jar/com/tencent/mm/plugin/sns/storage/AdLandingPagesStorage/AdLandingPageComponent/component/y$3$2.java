package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$3$2
  implements Runnable
{
  y$3$2(y.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(145308);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setAnimationListener(new y.3.2.1(this));
    this.rxR.rxQ.rxJ.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(145308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.3.2
 * JD-Core Version:    0.7.0.1
 */