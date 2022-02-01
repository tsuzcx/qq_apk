package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class j
  extends b
{
  private AnimatorSet IVc;
  private boolean JzI;
  private ValueAnimator Lig;
  e Lii;
  
  public j(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(216792);
    try
    {
      this.activity = paramMMActivity;
      this.Lii = ((e)paramb);
      this.JzI = paramBoolean;
      paramMMActivity = this.Lii.LjM.xYJ;
      int j = paramMMActivity.getHeight();
      int k = paramMMActivity.getWidth();
      paramb = new int[2];
      paramMMActivity.getLocationInWindow(paramb);
      int m = paramb[0];
      int n = paramb[1];
      paramb = ObjectAnimator.ofFloat(paramMMActivity, "alpha", new float[] { 1.0F, 0.0F });
      paramb.setDuration(400L);
      Object localObject = ao.ib(this.activity);
      int i1 = localObject[0];
      int i2 = localObject[1];
      int i = -90;
      if (this.JzI) {
        i = 90;
      }
      localObject = ObjectAnimator.ofFloat(paramMMActivity, "rotation", new float[] { 0.0F, i });
      ((ObjectAnimator)localObject).setDuration(400L);
      float f1 = 1.0F;
      if (j != 0) {
        f1 = i1 * 1.0F / j;
      }
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramMMActivity, "scaleX", new float[] { 1.0F, f1 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramMMActivity, "scaleY", new float[] { 1.0F, f1 });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator2.setDuration(400L);
      f1 = m;
      float f2 = k / 2.0F;
      float f3 = n;
      float f4 = j / 2.0F;
      float f5 = i1 / 2.0F;
      float f6 = i2 / 2.0F;
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramMMActivity, "translationX", new float[] { 0.0F, f5 - (f2 + f1) });
      paramMMActivity = ObjectAnimator.ofFloat(paramMMActivity, "translationY", new float[] { 0.0F, f6 - (f4 + f3) });
      localObjectAnimator3.setDuration(400L);
      paramMMActivity.setDuration(400L);
      this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(210846);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          j.this.Lii.LjM.AZc.setAlpha(f);
          j.this.Lii.LjM.JKr.setAlpha(f);
          AppMethodBeat.o(210846);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { paramb, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramMMActivity, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269368);
          Log.i("MicroMsg.FullCardAdDetailSimpleTwistClickAnimationNew", "onAnimation end");
          paramAnonymousAnimator = j.this;
          Log.i("MicroMsg.FullCardAdDetailSimpleTwistClickAnimationNew", "resetViewStatus");
          try
          {
            paramAnonymousAnimator.Lii.LjM.xYJ.setScaleX(1.0F);
            paramAnonymousAnimator.Lii.LjM.xYJ.setScaleY(1.0F);
            paramAnonymousAnimator.Lii.LjM.xYJ.setAlpha(1.0F);
            paramAnonymousAnimator.Lii.LjM.xYJ.setRotation(0.0F);
            paramAnonymousAnimator.Lii.LjM.xYJ.setTranslationX(0.0F);
            paramAnonymousAnimator.Lii.LjM.xYJ.setTranslationY(0.0F);
            paramAnonymousAnimator.Lii.LjM.AZc.setAlpha(1.0F);
            paramAnonymousAnimator.Lii.LjM.JKr.setAlpha(1.0F);
            if (paramAnonymousAnimator.Lii.LjM.JKF != null) {
              paramAnonymousAnimator.Lii.LjM.JKF.setAlpha(1.0F);
            }
            if (j.this.Lia != null) {
              j.this.Lia.onAnimationEnd();
            }
            AppMethodBeat.o(269368);
            return;
          }
          catch (Throwable paramAnonymousAnimator)
          {
            for (;;)
            {
              Log.e("MicroMsg.FullCardAdDetailSimpleTwistClickAnimationNew", "resetViewStatus exp=" + paramAnonymousAnimator.toString());
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269367);
          Log.i("MicroMsg.FullCardAdDetailSimpleTwistClickAnimationNew", "onAnimation start");
          AppMethodBeat.o(269367);
        }
      });
      AppMethodBeat.o(216792);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailSimpleTwistClickAnimationNew", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(216792);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(216793);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
      if ((this.Lii.LjM.JKF != null) && (this.Lii.LjM.JKF.getVisibility() == 0)) {
        this.Lii.LjM.JKF.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(216793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */