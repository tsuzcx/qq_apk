package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class i
  extends a
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  FrameLayout.LayoutParams AKk;
  e AKt;
  LinearLayout.LayoutParams AKu;
  int[] uOq;
  private AnimatorSet yLH;
  
  public i(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99941);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKt = ((e)parama);
    this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          i.this.AKt.contentView.setScaleX(f);
          i.this.AKt.contentView.setScaleY(f);
          i.this.AKt.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.AKb.setDuration(400L);
    this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.AKt.ALU.setAlpha(f);
        i.this.AKt.ALT.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.AKc.setDuration(100L);
    this.AKc.setStartDelay(300L);
    this.AKu = ((LinearLayout.LayoutParams)this.AKt.contentView.getLayoutParams());
    this.AKd = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        ae.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.activity.getBodyView().getParent()).removeView(i.this.AKt.contentView);
        ((ViewGroup)i.this.AKt.ArR).addView(i.this.AKt.contentView, i.this.AKu);
        i.this.AKt.contentView.setScaleX(1.0F);
        i.this.AKt.contentView.setScaleY(1.0F);
        i.this.AKt.contentView.setAlpha(1.0F);
        i.this.AKt.ALT.setAlpha(1.0F);
        i.this.AKt.ALU.setAlpha(1.0F);
        if (i.this.AJZ != null) {
          i.this.AJZ.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        ae.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        i.this.AKt.ALU.setAlpha(0.0F);
        i.this.AKt.ALT.setAlpha(0.0F);
        i.this.AKt.contentView.getLocationInWindow(i.this.uOq);
        ae.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.uOq[0]), Integer.valueOf(i.this.uOq[1]) });
        ((ViewGroup)i.this.AKt.ArR).removeView(i.this.AKt.contentView);
        paramAnonymousAnimator = i.this.AKt.ArR.getLayoutParams();
        paramAnonymousAnimator.width = i.this.AKt.contentView.getWidth();
        paramAnonymousAnimator.height = (i.this.AKt.contentView.getHeight() + i.this.AKu.topMargin + i.this.AKu.bottomMargin);
        i.this.AKt.ArR.setLayoutParams(paramAnonymousAnimator);
        i.this.AKk = new FrameLayout.LayoutParams(-2, -2);
        i.this.AKk.leftMargin = i.this.uOq[0];
        i.this.AKk.rightMargin = (i.this.AKd.getWidth() - i.this.AKk.leftMargin - i.this.AKt.contentView.getWidth());
        i.this.AKk.topMargin = (i.this.uOq[1] - al.jN(paramMMActivity));
        i.this.AKk.bottomMargin = (i.this.AKd.getHeight() - i.this.AKk.topMargin - i.this.AKt.contentView.getHeight());
        i.this.AKd.addView(i.this.AKt.contentView, i.this.AKk);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */