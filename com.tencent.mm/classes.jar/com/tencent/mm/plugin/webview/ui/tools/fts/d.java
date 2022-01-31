package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import org.xwalk.core.Log;

public final class d
  extends a
{
  public d(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9);
    paramView2.getViewTreeObserver().addOnPreDrawListener(new d.1(this, paramView2));
    paramView6.getViewTreeObserver().addOnPreDrawListener(new d.2(this, paramView6));
  }
  
  protected final void cfK()
  {
    Log.i("MicroMsg.FTS.SosAnimatorController", "search to init");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.rvs[0][0] - this.rvh >= 0.0F) {
      localValueAnimator.addUpdateListener(this.rvx);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rvl, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new d.3(this));
      localAnimatorSet.start();
      return;
      localValueAnimator.addUpdateListener(this.rvy);
    }
  }
  
  protected final void cfL()
  {
    Log.i("MicroMsg.FTS.SosAnimatorController", "init to search");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.rvs[0][0] - this.rvh >= 0.0F) {
      localValueAnimator.addUpdateListener(this.rvv);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rvl, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new d.4(this));
      localAnimatorSet.start();
      return;
      localValueAnimator.addUpdateListener(this.rvw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d
 * JD-Core Version:    0.7.0.1
 */