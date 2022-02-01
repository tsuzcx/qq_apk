package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends a
{
  int[] ssm;
  AnimatorSet vWT;
  k.b xOL;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  FrameLayout.LayoutParams xOp;
  LinearLayout.LayoutParams xOz;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOL = ((k.b)paramBaseViewHolder);
    this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ad.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          i.this.xOL.xSM.setScaleX(f);
          i.this.xOL.xSM.setScaleY(f);
          i.this.xOL.xSM.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.xOg.setDuration(400L);
    this.xOg.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (i.this.xOL.fUH)
        {
          ad.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = i.this.vWT.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        i.this.xOL.fUH = true;
        i.this.xOL.qXs.setAlpha(0.0F);
        i.this.xOL.xPg.setAlpha(0.0F);
        i.this.xOL.xSM.getLocationInWindow(i.this.ssm);
        ad.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.ssm[0]), Integer.valueOf(i.this.ssm[1]) });
        i.this.xOL.xQv.removeView(i.this.xOL.xSM);
        paramAnonymousAnimator = i.this.xOL.xQv.getLayoutParams();
        paramAnonymousAnimator.width = i.this.xOL.xSM.getWidth();
        paramAnonymousAnimator.height = (i.this.xOL.xSM.getHeight() + i.this.xOz.topMargin + i.this.xOz.bottomMargin);
        i.this.xOL.xQv.setLayoutParams(paramAnonymousAnimator);
        i.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        i.this.xOp.leftMargin = i.this.ssm[0];
        i.this.xOp.rightMargin = (i.this.xOi.getWidth() - i.this.xOp.leftMargin - i.this.xOL.xSM.getWidth());
        i.this.xOp.topMargin = i.this.ssm[1];
        i.this.xOp.bottomMargin = (i.this.xOi.getHeight() - i.this.xOp.topMargin - i.this.xOL.xSM.getHeight());
        i.this.xOi.addView(i.this.xOL.xSM, i.this.xOp);
        AppMethodBeat.o(99992);
      }
    });
    this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.xOL.qXs.setAlpha(f);
        i.this.xOL.xPg.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.xOh.setDuration(100L);
    this.xOh.setStartDelay(300L);
    this.xOz = ((LinearLayout.LayoutParams)this.xOL.xSM.getLayoutParams());
    this.xOi = ((FrameLayout)this.activity.getBodyView().getParent());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        ad.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.xOL.xSM.getParent()).removeView(i.this.xOL.xSM);
        i.this.xOL.xQv.addView(i.this.xOL.xSM, i.this.xOz);
        i.this.xOL.xSM.setScaleX(1.0F);
        i.this.xOL.xSM.setScaleY(1.0F);
        i.this.xOL.xSM.setAlpha(1.0F);
        i.this.xOL.qXs.setAlpha(1.0F);
        i.this.xOL.xPg.setAlpha(1.0F);
        if (i.this.xOe != null) {
          i.this.xOe.onAnimationEnd();
        }
        i.this.xOL.fUH = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        ad.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */