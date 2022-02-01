package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends b
{
  AnimatorSet CPA;
  n.a EUE;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.EUE = ((n.a)paramBaseViewHolder);
      this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            i.this.EUE.ExX.setScaleX(f);
            i.this.EUE.ExX.setScaleY(f);
            i.this.EUE.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (i.this.EUE.hho)
          {
            Log.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = i.this;
            if (paramAnonymousAnimator.CPA != null) {
              paramAnonymousAnimator.CPA.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          i.this.EUE.hho = true;
          AppMethodBeat.o(99985);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          i.this.EUE.wnX.setAlpha(f);
          i.this.EUE.EVh.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.EUb.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          i.this.EUE.ExX.setScaleX(1.0F);
          i.this.EUE.ExX.setScaleY(1.0F);
          i.this.EUE.ExX.setAlpha(1.0F);
          i.this.EUE.wnX.setAlpha(1.0F);
          i.this.EUE.EVh.setAlpha(1.0F);
          if (i.this.ETY != null) {
            i.this.ETY.onAnimationEnd();
          }
          i.this.EUE.EZp.feu();
          i.this.EUE.EZp.Ejd.requestRender();
          i.this.EUE.hho = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */