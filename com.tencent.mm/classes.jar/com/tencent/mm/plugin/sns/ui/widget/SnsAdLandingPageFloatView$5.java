package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.sdk.b.a;

public final class SnsAdLandingPageFloatView$5
  extends AnimatorListenerAdapter
{
  public SnsAdLandingPageFloatView$5(SnsAdLandingPageFloatView paramSnsAdLandingPageFloatView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40444);
    SnsAdLandingPageFloatView.a(this.smM).setVisibility(8);
    SnsAdLandingPageFloatView.a(this.smM, false);
    paramAnimator = new rf();
    paramAnimator.cHL.cHM = SnsAdLandingPageFloatView.b(this.smM);
    paramAnimator.cHL.state = 123;
    a.ymk.l(paramAnimator);
    AppMethodBeat.o(40444);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40443);
    SnsAdLandingPageFloatView.a(this.smM, true);
    SnsAdLandingPageFloatView.c(this.smM);
    this.smM.onPause();
    paramAnimator = new rf();
    paramAnimator.cHL.cHM = SnsAdLandingPageFloatView.b(this.smM);
    paramAnimator.cHL.state = 122;
    a.ymk.l(paramAnimator);
    AppMethodBeat.o(40443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.5
 * JD-Core Version:    0.7.0.1
 */