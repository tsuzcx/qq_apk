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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class j
  extends b
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  FrameLayout.LayoutParams AKk;
  e AKt;
  LinearLayout.LayoutParams AKu;
  int[] uOq;
  private AnimatorSet yLH;
  
  public j(final MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99947);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKt = ((e)parama);
    this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          j.this.AKt.contentView.setScaleX(f);
          j.this.AKt.contentView.setScaleY(f);
          j.this.AKt.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.AKb.setDuration(400L);
    this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.AKt.ALU.setAlpha(f);
        j.this.AKt.ALT.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.AKc.setDuration(100L);
    this.AKu = ((LinearLayout.LayoutParams)this.AKt.contentView.getLayoutParams());
    this.AKd = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        ae.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.AKt.contentView);
        ((ViewGroup)j.this.AKt.ArR).addView(j.this.AKt.contentView, j.this.AKu);
        j.this.AKt.contentView.setScaleX(1.0F);
        j.this.AKt.contentView.setScaleY(1.0F);
        j.this.AKt.contentView.setAlpha(1.0F);
        j.this.AKt.ALU.setAlpha(1.0F);
        j.this.AKt.ALT.setAlpha(1.0F);
        if (j.this.AJZ != null) {
          j.this.AJZ.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        ae.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        j.this.AKt.contentView.getLocationInWindow(j.this.uOq);
        ae.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.uOq[0]), Integer.valueOf(j.this.uOq[1]) });
        ((ViewGroup)j.this.AKt.ArR).removeView(j.this.AKt.contentView);
        paramAnonymousAnimator = j.this.AKt.ArR.getLayoutParams();
        paramAnonymousAnimator.width = j.this.AKt.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.AKt.contentView.getHeight() + j.this.AKu.topMargin + j.this.AKu.bottomMargin);
        j.this.AKt.ArR.setLayoutParams(paramAnonymousAnimator);
        j.this.AKk = new FrameLayout.LayoutParams(-2, -2);
        j.this.AKk.leftMargin = j.this.uOq[0];
        j.this.AKk.rightMargin = (j.this.AKd.getWidth() - j.this.AKk.leftMargin - j.this.AKt.contentView.getWidth());
        j.this.AKk.topMargin = (j.this.uOq[1] - al.jN(paramMMActivity));
        j.this.AKk.bottomMargin = (j.this.AKd.getHeight() - j.this.AKk.topMargin - j.this.AKt.contentView.getHeight());
        j.this.AKd.addView(j.this.AKt.contentView, j.this.AKk);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */