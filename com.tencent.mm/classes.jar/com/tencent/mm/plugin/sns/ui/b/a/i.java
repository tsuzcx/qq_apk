package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends b
{
  private AnimatorSet IVc;
  private boolean JzI;
  d Lie;
  private ValueAnimator Lig;
  
  public i(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(268321);
    try
    {
      this.activity = paramMMActivity;
      this.Lie = ((d)paramb);
      this.JzI = paramBoolean;
      paramMMActivity = this.Lie.xYJ;
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
          AppMethodBeat.i(228907);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          i.this.Lie.AZc.setAlpha(f);
          i.this.Lie.JKr.setAlpha(f);
          AppMethodBeat.o(228907);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { paramb, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramMMActivity, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269130);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          paramAnonymousAnimator = i.this;
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus");
          try
          {
            paramAnonymousAnimator.Lie.xYJ.setScaleX(1.0F);
            paramAnonymousAnimator.Lie.xYJ.setScaleY(1.0F);
            paramAnonymousAnimator.Lie.xYJ.setAlpha(1.0F);
            paramAnonymousAnimator.Lie.xYJ.setRotation(0.0F);
            paramAnonymousAnimator.Lie.xYJ.setTranslationX(0.0F);
            paramAnonymousAnimator.Lie.xYJ.setTranslationY(0.0F);
            paramAnonymousAnimator.Lie.AZc.setAlpha(1.0F);
            paramAnonymousAnimator.Lie.JKr.setAlpha(1.0F);
            paramAnonymousAnimator.Lie.JKF.setAlpha(1.0F);
            if (i.this.Lia != null) {
              i.this.Lia.onAnimationEnd();
            }
            AppMethodBeat.o(269130);
            return;
          }
          catch (Throwable paramAnonymousAnimator)
          {
            for (;;)
            {
              Log.e("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus exp=" + paramAnonymousAnimator.toString());
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269129);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(269129);
        }
      });
      AppMethodBeat.o(268321);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(268321);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(268323);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
      if (this.Lie.JKF.getVisibility() == 0) {
        this.Lie.JKF.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(268323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */