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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends b
{
  private AnimatorSet CPA;
  private boolean DsW;
  f.a EUA;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(203885);
    try
    {
      this.DsW = paramBoolean;
      this.activity = paramMMActivity;
      paramBoolean = paramBaseViewHolder instanceof f.a;
      if (!paramBoolean)
      {
        AppMethodBeat.o(203885);
        return;
      }
      this.EUA = ((f.a)paramBaseViewHolder);
      paramBaseViewHolder = this.EUA.ExX;
      int j = paramBaseViewHolder.getHeight();
      int k = paramBaseViewHolder.getWidth();
      paramMMActivity = new int[2];
      paramBaseViewHolder.getLocationInWindow(paramMMActivity);
      int m = paramMMActivity[0];
      int n = paramMMActivity[1];
      paramMMActivity = ObjectAnimator.ofFloat(paramBaseViewHolder, "alpha", new float[] { 1.0F, 0.0F });
      paramMMActivity.setDuration(400L);
      Object localObject = ap.ha(this.activity);
      int i1 = localObject[0];
      int i2 = localObject[1];
      int i = -90;
      if (this.DsW) {
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
          AppMethodBeat.i(203883);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.EUA.wnX.setAlpha(f);
          g.this.EUA.EVh.setAlpha(f);
          AppMethodBeat.o(203883);
        }
      });
      localValueAnimator.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { paramMMActivity, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramBaseViewHolder, localValueAnimator });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(203884);
          g.this.fkk();
          if (g.this.ETY != null) {
            g.this.ETY.onAnimationEnd();
          }
          g.this.EUA.hho = false;
          AppMethodBeat.o(203884);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      AppMethodBeat.o(203885);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SimpleTwistClickAnimation", "init exp=" + paramMMActivity.toString());
      fkk();
      AppMethodBeat.o(203885);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(203887);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
      if (this.EUA.EVy.getVisibility() == 0) {
        this.EUA.EVy.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(203887);
  }
  
  protected final void fkk()
  {
    AppMethodBeat.i(203886);
    Log.i("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus");
    try
    {
      this.EUA.ExX.setScaleX(1.0F);
      this.EUA.ExX.setScaleY(1.0F);
      this.EUA.ExX.setAlpha(1.0F);
      this.EUA.ExX.setRotation(0.0F);
      this.EUA.ExX.setTranslationX(0.0F);
      this.EUA.ExX.setTranslationY(0.0F);
      this.EUA.wnX.setAlpha(1.0F);
      this.EUA.EVh.setAlpha(1.0F);
      this.EUA.EVy.setAlpha(1.0F);
      AppMethodBeat.o(203886);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus exp=" + localThrowable.toString());
      AppMethodBeat.o(203886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */