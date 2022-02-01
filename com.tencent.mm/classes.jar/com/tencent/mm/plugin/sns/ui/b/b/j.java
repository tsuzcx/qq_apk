package com.tencent.mm.plugin.sns.ui.b.b;

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
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class j
  extends b
{
  private AnimatorSet IVc;
  private boolean JzI;
  h.a LiG;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(218458);
    try
    {
      this.JzI = paramBoolean;
      this.activity = paramMMActivity;
      paramBoolean = paramBaseViewHolder instanceof h.a;
      if (!paramBoolean)
      {
        AppMethodBeat.o(218458);
        return;
      }
      this.LiG = ((h.a)paramBaseViewHolder);
      paramBaseViewHolder = this.LiG.Lnh.xYJ;
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
          AppMethodBeat.i(267624);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          j.this.LiG.Lnh.AZc.setAlpha(f);
          j.this.LiG.Lnh.JKr.setAlpha(f);
          AppMethodBeat.o(267624);
        }
      });
      localValueAnimator.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { paramMMActivity, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramBaseViewHolder, localValueAnimator });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(245968);
          j.this.fYt();
          if (j.this.Lia != null) {
            j.this.Lia.onAnimationEnd();
          }
          j.this.LiG.jTm = false;
          AppMethodBeat.o(245968);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      AppMethodBeat.o(218458);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdSimpleTwistClickAnimationNew", "init exp=" + paramMMActivity.toString());
      fYt();
      AppMethodBeat.o(218458);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(218461);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
      if ((this.LiG.Lnh.JKF != null) && (this.LiG.Lnh.JKF.getVisibility() == 0)) {
        this.LiG.Lnh.JKF.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(218461);
  }
  
  protected final void fYt()
  {
    AppMethodBeat.i(218460);
    Log.i("MicroMsg.FullCardAdSimpleTwistClickAnimationNew", "resetViewStatus");
    try
    {
      this.LiG.Lnh.xYJ.setScaleX(1.0F);
      this.LiG.Lnh.xYJ.setScaleY(1.0F);
      this.LiG.Lnh.xYJ.setAlpha(1.0F);
      this.LiG.Lnh.xYJ.setRotation(0.0F);
      this.LiG.Lnh.xYJ.setTranslationX(0.0F);
      this.LiG.Lnh.xYJ.setTranslationY(0.0F);
      this.LiG.Lnh.AZc.setAlpha(1.0F);
      this.LiG.Lnh.JKr.setAlpha(1.0F);
      if (this.LiG.Lnh.JKF != null) {
        this.LiG.Lnh.JKF.setAlpha(1.0F);
      }
      AppMethodBeat.o(218460);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FullCardAdSimpleTwistClickAnimationNew", "resetViewStatus exp=" + localThrowable.toString());
      AppMethodBeat.o(218460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */