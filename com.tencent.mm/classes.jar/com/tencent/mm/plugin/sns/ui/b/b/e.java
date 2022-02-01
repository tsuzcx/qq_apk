package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  AnimatorSet vWT;
  d.a xOF;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.xOF = ((d.a)paramBaseViewHolder);
      this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.xOF.xtU.setScaleX(f);
            e.this.xOF.xtU.setScaleY(f);
            e.this.xOF.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.xOF.fUH)
          {
            ad.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.vWT.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.xOF.fUH = true;
          e.this.xOF.qXs.setAlpha(0.0F);
          e.this.xOF.xPg.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.xOF.qXs.setAlpha(f);
          e.this.xOF.xPg.setAlpha(f);
          AppMethodBeat.o(99965);
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
          AppMethodBeat.i(99967);
          ad.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.xOF.xtU.setScaleX(1.0F);
          e.this.xOF.xtU.setScaleY(1.0F);
          e.this.xOF.xtU.setAlpha(1.0F);
          e.this.xOF.qXs.setAlpha(1.0F);
          e.this.xOF.xPg.setAlpha(1.0F);
          if (e.this.xOe != null) {
            e.this.xOe.onAnimationEnd();
          }
          e.this.xOF.fUH = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          ad.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */