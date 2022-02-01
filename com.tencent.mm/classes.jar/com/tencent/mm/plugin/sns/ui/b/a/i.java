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
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.plugin.sns.ui.c.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;

public final class i
  extends a
{
  private AnimatorSet Div;
  ViewGroup RIA;
  LinearLayout.LayoutParams RIB;
  FrameLayout.LayoutParams RIC;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  h RIz;
  int[] bfh;
  
  public i(final MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(99941);
    this.bfh = new int[2];
    this.activity = paramMMActivity;
    this.RIz = ((h)paramb);
    this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          i.this.RIz.contentView.setScaleX(f);
          i.this.RIz.contentView.setScaleY(f);
          i.this.RIz.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.RIs.setDuration(400L);
    this.RIw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.RIz.RKf.setAlpha(f);
        i.this.RIz.RKe.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.RIw.setDuration(100L);
    this.RIw.setStartDelay(300L);
    this.RIB = ((LinearLayout.LayoutParams)this.RIz.contentView.getLayoutParams());
    this.RIA = ((FrameLayout)this.activity.getBodyView().getParent());
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.activity.getBodyView().getParent()).removeView(i.this.RIz.contentView);
        ((ViewGroup)i.this.RIz.RoA).addView(i.this.RIz.contentView, i.this.RIB);
        i.this.RIz.contentView.setScaleX(1.0F);
        i.this.RIz.contentView.setScaleY(1.0F);
        i.this.RIz.contentView.setAlpha(1.0F);
        i.this.RIz.RKe.setAlpha(1.0F);
        i.this.RIz.RKf.setAlpha(1.0F);
        if (i.this.RIn != null) {
          i.this.RIn.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        i.this.RIz.RKf.setAlpha(0.0F);
        i.this.RIz.RKe.setAlpha(0.0F);
        i.this.RIz.contentView.getLocationInWindow(i.this.bfh);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.bfh[0]), Integer.valueOf(i.this.bfh[1]) });
        ((ViewGroup)i.this.RIz.RoA).removeView(i.this.RIz.contentView);
        paramAnonymousAnimator = i.this.RIz.RoA.getLayoutParams();
        paramAnonymousAnimator.width = i.this.RIz.contentView.getWidth();
        paramAnonymousAnimator.height = (i.this.RIz.contentView.getHeight() + i.this.RIB.topMargin + i.this.RIB.bottomMargin);
        i.this.RIz.RoA.setLayoutParams(paramAnonymousAnimator);
        i.this.RIC = new FrameLayout.LayoutParams(-2, -2);
        i.this.RIC.leftMargin = i.this.bfh[0];
        i.this.RIC.rightMargin = (i.this.RIA.getWidth() - i.this.RIC.leftMargin - i.this.RIz.contentView.getWidth());
        i.this.RIC.topMargin = (i.this.bfh[1] - aw.getStatusBarHeight(paramMMActivity));
        i.this.RIC.bottomMargin = (i.this.RIA.getHeight() - i.this.RIC.topMargin - i.this.RIz.contentView.getHeight());
        i.this.RIA.addView(i.this.RIz.contentView, i.this.RIC);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */