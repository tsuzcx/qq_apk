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
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  AnimatorSet vWT;
  i.a xOI;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.xOI = ((i.a)paramBaseViewHolder);
      this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.xOI.xtU.setScaleX(f);
            h.this.xOI.xtU.setScaleY(f);
            h.this.xOI.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (h.this.xOI.fUH)
          {
            ad.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = h.this;
            if (paramAnonymousAnimator.vWT != null) {
              paramAnonymousAnimator.vWT.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          h.this.xOI.fUH = true;
          AppMethodBeat.o(99985);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.xOI.qXs.setAlpha(f);
          h.this.xOI.xPg.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.xOh.setDuration(100L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          ad.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          h.this.xOI.xtU.setScaleX(1.0F);
          h.this.xOI.xtU.setScaleY(1.0F);
          h.this.xOI.xtU.setAlpha(1.0F);
          h.this.xOI.qXs.setAlpha(1.0F);
          h.this.xOI.xPg.setAlpha(1.0F);
          if (h.this.xOe != null) {
            h.this.xOe.onAnimationEnd();
          }
          h.this.xOI.xSy.dxk();
          h.this.xOI.xSy.xfJ.requestRender();
          h.this.xOI.fUH = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          ad.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */