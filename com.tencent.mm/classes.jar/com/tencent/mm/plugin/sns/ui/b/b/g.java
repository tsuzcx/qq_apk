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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
  extends a
{
  AnimatorSet vWT;
  i.a xOI;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.xOI = ((i.a)paramBaseViewHolder);
      this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.xOI.xtU.setScaleX(f);
            g.this.xOI.xtU.setScaleY(f);
            g.this.xOI.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (g.this.xOI.fUH)
          {
            ad.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = g.this.vWT.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          g.this.xOI.fUH = true;
          g.this.xOI.qXs.setAlpha(0.0F);
          g.this.xOI.xPg.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.xOI.qXs.setAlpha(f);
          g.this.xOI.xPg.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.xOh.setDuration(100L);
      this.xOh.setStartDelay(300L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          ad.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          g.this.xOI.xtU.setScaleX(1.0F);
          g.this.xOI.xtU.setScaleY(1.0F);
          g.this.xOI.xtU.setAlpha(1.0F);
          g.this.xOI.qXs.setAlpha(1.0F);
          g.this.xOI.xPg.setAlpha(1.0F);
          if (g.this.xOe != null) {
            g.this.xOe.onAnimationEnd();
          }
          g.this.xOI.fUH = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          ad.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */