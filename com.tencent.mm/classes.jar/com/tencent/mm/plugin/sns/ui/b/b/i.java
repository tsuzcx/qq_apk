package com.tencent.mm.plugin.sns.ui.b.b;

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
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends b
{
  private AnimatorSet IVc;
  private boolean JzI;
  g.a LiE;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(268579);
    try
    {
      this.JzI = paramBoolean;
      this.activity = paramMMActivity;
      paramBoolean = paramBaseViewHolder instanceof g.a;
      if (!paramBoolean)
      {
        AppMethodBeat.o(268579);
        return;
      }
      this.LiE = ((g.a)paramBaseViewHolder);
      paramBaseViewHolder = this.LiE.xYJ;
      int j = paramBaseViewHolder.getHeight();
      int k = paramBaseViewHolder.getWidth();
      paramMMActivity = new int[2];
      paramBaseViewHolder.getLocationInWindow(paramMMActivity);
      int m = paramMMActivity[0];
      int n = paramMMActivity[1];
      paramMMActivity = ObjectAnimator.ofFloat(paramBaseViewHolder, "alpha", new float[] { 1.0F, 0.0F });
      paramMMActivity.setDuration(400L);
      Object localObject = ao.ib(this.activity);
      int i1 = localObject[0];
      int i2 = localObject[1];
      int i = -90;
      if (this.JzI) {
        i = 90;
      }
      localObject = ObjectAnimator.ofFloat(paramBaseViewHolder, "rotation", new float[] { 0.0F, i });
      ((ObjectAnimator)localObject).setDuration(400L);
      float f1 = 1.0F;
      if (j != 0) {
        f1 = i1 * 1.0F / j;
      }
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramBaseViewHolder, "scaleX", new float[] { 1.0F, f1 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramBaseViewHolder, "scaleY", new float[] { 1.0F, f1 });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator2.setDuration(400L);
      f1 = m;
      float f2 = k / 2.0F;
      float f3 = n;
      float f4 = j / 2.0F;
      float f5 = i1 / 2.0F;
      float f6 = i2 / 2.0F;
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramBaseViewHolder, "translationX", new float[] { 0.0F, f5 - (f2 + f1) });
      paramBaseViewHolder = ObjectAnimator.ofFloat(paramBaseViewHolder, "translationY", new float[] { 0.0F, f6 - (f4 + f3) });
      localObjectAnimator3.setDuration(400L);
      paramBaseViewHolder.setDuration(400L);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(225272);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          i.this.LiE.AZc.setAlpha(f);
          i.this.LiE.JKr.setAlpha(f);
          AppMethodBeat.o(225272);
        }
      });
      localValueAnimator.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { paramMMActivity, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramBaseViewHolder, localValueAnimator });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269557);
          i.this.fYt();
          if (i.this.Lia != null) {
            i.this.Lia.onAnimationEnd();
          }
          i.this.LiE.jTm = false;
          AppMethodBeat.o(269557);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      AppMethodBeat.o(268579);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SimpleTwistClickAnimation", "init exp=" + paramMMActivity.toString());
      fYt();
      AppMethodBeat.o(268579);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(268581);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
      if (this.LiE.JKF.getVisibility() == 0) {
        this.LiE.JKF.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(268581);
  }
  
  protected final void fYt()
  {
    AppMethodBeat.i(268580);
    Log.i("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus");
    try
    {
      this.LiE.xYJ.setScaleX(1.0F);
      this.LiE.xYJ.setScaleY(1.0F);
      this.LiE.xYJ.setAlpha(1.0F);
      this.LiE.xYJ.setRotation(0.0F);
      this.LiE.xYJ.setTranslationX(0.0F);
      this.LiE.xYJ.setTranslationY(0.0F);
      this.LiE.AZc.setAlpha(1.0F);
      this.LiE.JKr.setAlpha(1.0F);
      this.LiE.JKF.setAlpha(1.0F);
      AppMethodBeat.o(268580);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus exp=" + localThrowable.toString());
      AppMethodBeat.o(268580);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */