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

public final class m
  extends b
{
  AnimatorSet Div;
  ViewGroup RIA;
  LinearLayout.LayoutParams RIB;
  FrameLayout.LayoutParams RIC;
  p.b RIU;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  int[] bfh;
  
  public m(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.bfh = new int[2];
    this.activity = paramMMActivity;
    this.RIU = ((p.b)paramBaseViewHolder);
    this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          m.this.RIU.RNA.setScaleX(f);
          m.this.RIU.RNA.setScaleY(f);
          m.this.RIU.RNA.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.RIs.setDuration(400L);
    this.RIs.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (m.this.RIU.mtE)
        {
          Log.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = m.this.Div.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        m.this.RIU.mtE = true;
        m.this.RIU.RNA.getLocationInWindow(m.this.bfh);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(m.this.bfh[0]), Integer.valueOf(m.this.bfh[1]), Integer.valueOf(m.this.RIU.RNA.getWidth()), Integer.valueOf(m.this.RIU.RNA.getHeight()) });
        m.this.RIU.RKF.removeView(m.this.RIU.RNA);
        paramAnonymousAnimator = m.this.RIU.RKF.getLayoutParams();
        paramAnonymousAnimator.width = m.this.RIU.RNA.getWidth();
        paramAnonymousAnimator.height = (m.this.RIU.RNA.getHeight() + m.this.RIB.topMargin + m.this.RIB.bottomMargin);
        m.this.RIU.RKF.setLayoutParams(paramAnonymousAnimator);
        m.this.RIC = new FrameLayout.LayoutParams(-2, -2);
        m.this.RIC.leftMargin = m.this.bfh[0];
        m.this.RIC.rightMargin = (m.this.RIA.getWidth() - m.this.RIC.leftMargin - m.this.RIU.RNA.getWidth());
        m.this.RIC.topMargin = m.this.bfh[1];
        m.this.RIC.bottomMargin = (m.this.RIA.getHeight() - m.this.RIC.topMargin - m.this.RIU.RNA.getHeight());
        m.this.RIA.addView(m.this.RIU.RNA, m.this.RIC);
        AppMethodBeat.o(99999);
      }
    });
    this.RIw = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        m.this.RIU.GBf.setAlpha(f);
        m.this.RIU.QbY.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.RIw.setDuration(100L);
    this.RIB = ((LinearLayout.LayoutParams)this.RIU.RNA.getLayoutParams());
    this.RIA = ((FrameLayout)this.activity.getBodyView().getParent());
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)m.this.RIU.RNA.getParent()).removeView(m.this.RIU.RNA);
        m.this.RIU.RKF.addView(m.this.RIU.RNA, m.this.RIB);
        m.this.RIU.RNA.setScaleX(1.0F);
        m.this.RIU.RNA.setScaleY(1.0F);
        m.this.RIU.RNA.setAlpha(1.0F);
        m.this.RIU.GBf.setAlpha(1.0F);
        m.this.RIU.QbY.setAlpha(1.0F);
        if (m.this.RIn != null) {
          m.this.RIn.onAnimationEnd();
        }
        m.this.RIU.mtE = false;
        AppMethodBeat.o(100002);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100001);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(100001);
      }
    });
    AppMethodBeat.o(100003);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.m
 * JD-Core Version:    0.7.0.1
 */