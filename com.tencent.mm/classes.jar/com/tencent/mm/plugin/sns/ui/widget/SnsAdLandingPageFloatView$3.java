package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.sdk.b.a;

public final class SnsAdLandingPageFloatView$3
  extends AnimatorListenerAdapter
{
  public SnsAdLandingPageFloatView$3(SnsAdLandingPageFloatView paramSnsAdLandingPageFloatView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40441);
    SnsAdLandingPageFloatView.a(this.smM, false);
    paramAnimator = new rf();
    paramAnimator.cHL.cHM = SnsAdLandingPageFloatView.b(this.smM);
    paramAnimator.cHL.state = 121;
    a.ymk.l(paramAnimator);
    AppMethodBeat.o(40441);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40440);
    SnsAdLandingPageFloatView.a(this.smM, true);
    this.smM.onResume();
    paramAnimator = new rf();
    paramAnimator.cHL.cHM = SnsAdLandingPageFloatView.b(this.smM);
    paramAnimator.cHL.state = 120;
    a.ymk.l(paramAnimator);
    AppMethodBeat.o(40440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.3
 * JD-Core Version:    0.7.0.1
 */