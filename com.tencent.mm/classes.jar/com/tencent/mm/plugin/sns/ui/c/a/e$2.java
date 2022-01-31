package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.widget.a;

final class e$2
  implements Animation.AnimationListener
{
  e$2(e parame, View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(40104);
    this.sgB.setVisibility(0);
    this.sgC.setVisibility(8);
    this.sgA.Fi(this.sgD);
    paramAnimation = new a(this.sgA.context, this.sgE, 0.0F, this.cdQ, this.cdR, false);
    paramAnimation.setDuration(187L);
    paramAnimation.setInterpolator(new DecelerateInterpolator());
    this.sgA.contentView.startAnimation(paramAnimation);
    this.sgA.sdt = false;
    this.sgA.refreshView();
    AppMethodBeat.o(40104);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e.2
 * JD-Core Version:    0.7.0.1
 */