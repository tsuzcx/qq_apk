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
import com.tencent.mm.plugin.sns.ui.item.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends a
{
  m.b AKG;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  FrameLayout.LayoutParams AKk;
  LinearLayout.LayoutParams AKu;
  int[] uOq;
  AnimatorSet yLH;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKG = ((m.b)paramBaseViewHolder);
    this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ae.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          i.this.AKG.AOY.setScaleX(f);
          i.this.AKG.AOY.setScaleY(f);
          i.this.AKG.AOY.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.AKb.setDuration(400L);
    this.AKb.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (i.this.AKG.guz)
        {
          ae.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = i.this.yLH.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        i.this.AKG.guz = true;
        i.this.AKG.tgh.setAlpha(0.0F);
        i.this.AKG.ALc.setAlpha(0.0F);
        i.this.AKG.AOY.getLocationInWindow(i.this.uOq);
        ae.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.uOq[0]), Integer.valueOf(i.this.uOq[1]) });
        i.this.AKG.AMr.removeView(i.this.AKG.AOY);
        paramAnonymousAnimator = i.this.AKG.AMr.getLayoutParams();
        paramAnonymousAnimator.width = i.this.AKG.AOY.getWidth();
        paramAnonymousAnimator.height = (i.this.AKG.AOY.getHeight() + i.this.AKu.topMargin + i.this.AKu.bottomMargin);
        i.this.AKG.AMr.setLayoutParams(paramAnonymousAnimator);
        i.this.AKk = new FrameLayout.LayoutParams(-2, -2);
        i.this.AKk.leftMargin = i.this.uOq[0];
        i.this.AKk.rightMargin = (i.this.AKd.getWidth() - i.this.AKk.leftMargin - i.this.AKG.AOY.getWidth());
        i.this.AKk.topMargin = i.this.uOq[1];
        i.this.AKk.bottomMargin = (i.this.AKd.getHeight() - i.this.AKk.topMargin - i.this.AKG.AOY.getHeight());
        i.this.AKd.addView(i.this.AKG.AOY, i.this.AKk);
        AppMethodBeat.o(99992);
      }
    });
    this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.AKG.tgh.setAlpha(f);
        i.this.AKG.ALc.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.AKc.setDuration(100L);
    this.AKc.setStartDelay(300L);
    this.AKu = ((LinearLayout.LayoutParams)this.AKG.AOY.getLayoutParams());
    this.AKd = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        ae.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.AKG.AOY.getParent()).removeView(i.this.AKG.AOY);
        i.this.AKG.AMr.addView(i.this.AKG.AOY, i.this.AKu);
        i.this.AKG.AOY.setScaleX(1.0F);
        i.this.AKG.AOY.setScaleY(1.0F);
        i.this.AKG.AOY.setAlpha(1.0F);
        i.this.AKG.tgh.setAlpha(1.0F);
        i.this.AKG.ALc.setAlpha(1.0F);
        if (i.this.AJZ != null) {
          i.this.AJZ.onAnimationEnd();
        }
        i.this.AKG.guz = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        ae.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */