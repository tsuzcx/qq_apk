package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
  extends a
{
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  i.a zby;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.zby = ((i.a)paramBaseViewHolder);
      this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.zby.yGK.setScaleX(f);
            g.this.zby.yGK.setScaleY(f);
            g.this.zby.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (g.this.zby.fYC)
          {
            ac.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = g.this.xhG.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          g.this.zby.fYC = true;
          g.this.zby.rXY.setAlpha(0.0F);
          g.this.zby.zbW.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.zby.rXY.setAlpha(f);
          g.this.zby.zbW.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.zaX.setDuration(100L);
      this.zaX.setStartDelay(300L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          ac.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          g.this.zby.yGK.setScaleX(1.0F);
          g.this.zby.yGK.setScaleY(1.0F);
          g.this.zby.yGK.setAlpha(1.0F);
          g.this.zby.rXY.setAlpha(1.0F);
          g.this.zby.zbW.setAlpha(1.0F);
          if (g.this.zaU != null) {
            g.this.zaU.onAnimationEnd();
          }
          g.this.zby.fYC = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          ac.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */