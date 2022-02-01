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
import com.tencent.mm.plugin.sns.ui.c.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;

public final class j
  extends b
{
  private AnimatorSet Div;
  ViewGroup RIA;
  LinearLayout.LayoutParams RIB;
  FrameLayout.LayoutParams RIC;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  h RIz;
  int[] bfh;
  
  public j(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(99947);
    this.bfh = new int[2];
    this.activity = paramMMActivity;
    this.RIz = ((h)paramb);
    this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          j.this.RIz.contentView.setScaleX(f);
          j.this.RIz.contentView.setScaleY(f);
          j.this.RIz.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.RIs.setDuration(400L);
    this.RIw = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.RIz.RKf.setAlpha(f);
        j.this.RIz.RKe.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.RIw.setDuration(100L);
    this.RIB = ((LinearLayout.LayoutParams)this.RIz.contentView.getLayoutParams());
    this.RIA = ((FrameLayout)this.activity.getBodyView().getParent());
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.RIz.contentView);
        ((ViewGroup)j.this.RIz.RoA).addView(j.this.RIz.contentView, j.this.RIB);
        j.this.RIz.contentView.setScaleX(1.0F);
        j.this.RIz.contentView.setScaleY(1.0F);
        j.this.RIz.contentView.setAlpha(1.0F);
        j.this.RIz.RKf.setAlpha(1.0F);
        j.this.RIz.RKe.setAlpha(1.0F);
        if (j.this.RIn != null) {
          j.this.RIn.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        j.this.RIz.contentView.getLocationInWindow(j.this.bfh);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.bfh[0]), Integer.valueOf(j.this.bfh[1]) });
        ((ViewGroup)j.this.RIz.RoA).removeView(j.this.RIz.contentView);
        paramAnonymousAnimator = j.this.RIz.RoA.getLayoutParams();
        paramAnonymousAnimator.width = j.this.RIz.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.RIz.contentView.getHeight() + j.this.RIB.topMargin + j.this.RIB.bottomMargin);
        j.this.RIz.RoA.setLayoutParams(paramAnonymousAnimator);
        j.this.RIC = new FrameLayout.LayoutParams(-2, -2);
        j.this.RIC.leftMargin = j.this.bfh[0];
        j.this.RIC.rightMargin = (j.this.RIA.getWidth() - j.this.RIC.leftMargin - j.this.RIz.contentView.getWidth());
        j.this.RIC.topMargin = (j.this.bfh[1] - aw.getStatusBarHeight(paramMMActivity));
        j.this.RIC.bottomMargin = (j.this.RIA.getHeight() - j.this.RIC.topMargin - j.this.RIz.contentView.getHeight());
        j.this.RIA.addView(j.this.RIz.contentView, j.this.RIC);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */