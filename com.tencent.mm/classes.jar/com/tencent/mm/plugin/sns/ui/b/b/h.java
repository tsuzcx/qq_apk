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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  i.a zby;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.zby = ((i.a)paramBaseViewHolder);
      this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.zby.yGK.setScaleX(f);
            h.this.zby.yGK.setScaleY(f);
            h.this.zby.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (h.this.zby.fYC)
          {
            ac.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = h.this;
            if (paramAnonymousAnimator.xhG != null) {
              paramAnonymousAnimator.xhG.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          h.this.zby.fYC = true;
          AppMethodBeat.o(99985);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.zby.rXY.setAlpha(f);
          h.this.zby.zbW.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.zaX.setDuration(100L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          ac.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          h.this.zby.yGK.setScaleX(1.0F);
          h.this.zby.yGK.setScaleY(1.0F);
          h.this.zby.yGK.setAlpha(1.0F);
          h.this.zby.rXY.setAlpha(1.0F);
          h.this.zby.zbW.setAlpha(1.0F);
          if (h.this.zaU != null) {
            h.this.zaU.onAnimationEnd();
          }
          h.this.zby.zft.dLJ();
          h.this.zby.zft.ysx.requestRender();
          h.this.zby.fYC = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          ac.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */