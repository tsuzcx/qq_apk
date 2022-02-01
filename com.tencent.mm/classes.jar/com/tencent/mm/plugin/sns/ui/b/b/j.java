package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  extends a
{
  AnimatorSet Div;
  n.a RIR;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.RIR = ((n.a)paramBaseViewHolder);
      this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            j.this.RIR.Cxb.setScaleX(f);
            j.this.RIR.Cxb.setScaleY(f);
            j.this.RIR.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (j.this.RIR.mtE)
          {
            Log.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = j.this.Div.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          j.this.RIR.mtE = true;
          j.this.RIR.GBf.setAlpha(0.0F);
          j.this.RIR.QbY.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          j.this.RIR.GBf.setAlpha(f);
          j.this.RIR.QbY.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.RIw.setDuration(100L);
      this.RIw.setStartDelay(300L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          j.this.RIR.Cxb.setScaleX(1.0F);
          j.this.RIR.Cxb.setScaleY(1.0F);
          j.this.RIR.Cxb.setAlpha(1.0F);
          j.this.RIR.GBf.setAlpha(1.0F);
          j.this.RIR.QbY.setAlpha(1.0F);
          if (j.this.RIn != null) {
            j.this.RIn.onAnimationEnd();
          }
          j.this.RIR.mtE = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */