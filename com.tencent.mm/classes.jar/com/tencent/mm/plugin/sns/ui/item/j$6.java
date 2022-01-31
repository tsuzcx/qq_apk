package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.widget.a;

public final class j$6
  implements Animation.AnimationListener
{
  public j$6(j paramj, View paramView1, View paramView2, j.a parama, View paramView3, int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(40160);
    this.sgB.setVisibility(0);
    this.sgC.setVisibility(8);
    j.b(this.siH.siL);
    paramAnimation = new a(this.siI.getContext(), this.sgE, 0.0F, this.cdQ, this.cdR, false);
    paramAnimation.setDuration(187L);
    paramAnimation.setInterpolator(new DecelerateInterpolator());
    this.siI.startAnimation(paramAnimation);
    AppMethodBeat.o(40160);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.6
 * JD-Core Version:    0.7.0.1
 */