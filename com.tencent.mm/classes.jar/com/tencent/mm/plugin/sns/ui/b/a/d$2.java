package com.tencent.mm.plugin.sns.ui.b.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.widget.a;

final class d$2
  implements Animation.AnimationListener
{
  d$2(d paramd, View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.pms.setVisibility(0);
    this.pmt.setVisibility(8);
    this.pmr.yY(this.pmu);
    paramAnimation = new a(this.pmr.context, this.pmv, 0.0F, this.bAT, this.bAU, false);
    paramAnimation.setDuration(187L);
    paramAnimation.setInterpolator(new DecelerateInterpolator());
    this.pmr.contentView.startAnimation(paramAnimation);
    this.pmr.pgy = false;
    this.pmr.aqU();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d.2
 * JD-Core Version:    0.7.0.1
 */