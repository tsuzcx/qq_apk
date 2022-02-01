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
import com.tencent.mm.plugin.sns.ui.item.p.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class l
  extends a
{
  AnimatorSet Div;
  ViewGroup RIA;
  LinearLayout.LayoutParams RIB;
  FrameLayout.LayoutParams RIC;
  p.b RIU;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  int[] bfh;
  
  public l(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.bfh = new int[2];
    this.activity = paramMMActivity;
    this.RIU = ((p.b)paramBaseViewHolder);
    this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          l.this.RIU.RNA.setScaleX(f);
          l.this.RIU.RNA.setScaleY(f);
          l.this.RIU.RNA.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.RIs.setDuration(400L);
    this.RIs.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (l.this.RIU.mtE)
        {
          Log.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = l.this.Div.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        l.this.RIU.mtE = true;
        l.this.RIU.GBf.setAlpha(0.0F);
        l.this.RIU.QbY.setAlpha(0.0F);
        l.this.RIU.RNA.getLocationInWindow(l.this.bfh);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(l.this.bfh[0]), Integer.valueOf(l.this.bfh[1]) });
        l.this.RIU.RKF.removeView(l.this.RIU.RNA);
        paramAnonymousAnimator = l.this.RIU.RKF.getLayoutParams();
        paramAnonymousAnimator.width = l.this.RIU.RNA.getWidth();
        paramAnonymousAnimator.height = (l.this.RIU.RNA.getHeight() + l.this.RIB.topMargin + l.this.RIB.bottomMargin);
        l.this.RIU.RKF.setLayoutParams(paramAnonymousAnimator);
        l.this.RIC = new FrameLayout.LayoutParams(-2, -2);
        l.this.RIC.leftMargin = l.this.bfh[0];
        l.this.RIC.rightMargin = (l.this.RIA.getWidth() - l.this.RIC.leftMargin - l.this.RIU.RNA.getWidth());
        l.this.RIC.topMargin = l.this.bfh[1];
        l.this.RIC.bottomMargin = (l.this.RIA.getHeight() - l.this.RIC.topMargin - l.this.RIU.RNA.getHeight());
        l.this.RIA.addView(l.this.RIU.RNA, l.this.RIC);
        AppMethodBeat.o(99992);
      }
    });
    this.RIw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.RIU.GBf.setAlpha(f);
        l.this.RIU.QbY.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.RIw.setDuration(100L);
    this.RIw.setStartDelay(300L);
    this.RIB = ((LinearLayout.LayoutParams)this.RIU.RNA.getLayoutParams());
    this.RIA = ((FrameLayout)this.activity.getBodyView().getParent());
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)l.this.RIU.RNA.getParent()).removeView(l.this.RIU.RNA);
        l.this.RIU.RKF.addView(l.this.RIU.RNA, l.this.RIB);
        l.this.RIU.RNA.setScaleX(1.0F);
        l.this.RIU.RNA.setScaleY(1.0F);
        l.this.RIU.RNA.setAlpha(1.0F);
        l.this.RIU.GBf.setAlpha(1.0F);
        l.this.RIU.QbY.setAlpha(1.0F);
        if (l.this.RIn != null) {
          l.this.RIn.onAnimationEnd();
        }
        l.this.RIU.mtE = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.l
 * JD-Core Version:    0.7.0.1
 */