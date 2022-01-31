package com.tencent.mm.plugin.sns.ui.c;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.widget.a;

public final class j$6
  implements Animation.AnimationListener
{
  public j$6(j paramj, View paramView1, View paramView2, j.a parama, View paramView3, int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.pms.setVisibility(0);
    this.pmt.setVisibility(8);
    j.b(this.pof.poj);
    paramAnimation = new a(this.pog.getContext(), this.pmv, 0.0F, this.bAT, this.bAU, false);
    paramAnimation.setDuration(187L);
    paramAnimation.setInterpolator(new DecelerateInterpolator());
    this.pog.startAnimation(paramAnimation);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.j.6
 * JD-Core Version:    0.7.0.1
 */