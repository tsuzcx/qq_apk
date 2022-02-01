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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  d.a zbv;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.zbv = ((d.a)paramBaseViewHolder);
      this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.zbv.yGK.setScaleX(f);
            e.this.zbv.yGK.setScaleY(f);
            e.this.zbv.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.zbv.fYC)
          {
            ac.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.xhG.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.zbv.fYC = true;
          e.this.zbv.rXY.setAlpha(0.0F);
          e.this.zbv.zbW.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.zbv.rXY.setAlpha(f);
          e.this.zbv.zbW.setAlpha(f);
          AppMethodBeat.o(99965);
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
          AppMethodBeat.i(99967);
          ac.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.zbv.yGK.setScaleX(1.0F);
          e.this.zbv.yGK.setScaleY(1.0F);
          e.this.zbv.yGK.setAlpha(1.0F);
          e.this.zbv.rXY.setAlpha(1.0F);
          e.this.zbv.zbW.setAlpha(1.0F);
          if (e.this.zaU != null) {
            e.this.zaU.onAnimationEnd();
          }
          e.this.zbv.fYC = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          ac.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */