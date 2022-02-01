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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class i
  extends a
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  FrameLayout.LayoutParams AsW;
  e Atf;
  LinearLayout.LayoutParams Atg;
  int[] uCL;
  private AnimatorSet yvH;
  
  public i(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99941);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.Atf = ((e)parama);
    this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          i.this.Atf.contentView.setScaleX(f);
          i.this.Atf.contentView.setScaleY(f);
          i.this.Atf.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.AsN.setDuration(400L);
    this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.Atf.AuE.setAlpha(f);
        i.this.Atf.AuD.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.AsO.setDuration(100L);
    this.AsO.setStartDelay(300L);
    this.Atg = ((LinearLayout.LayoutParams)this.Atf.contentView.getLayoutParams());
    this.AsP = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.activity.getBodyView().getParent()).removeView(i.this.Atf.contentView);
        ((ViewGroup)i.this.Atf.AaE).addView(i.this.Atf.contentView, i.this.Atg);
        i.this.Atf.contentView.setScaleX(1.0F);
        i.this.Atf.contentView.setScaleY(1.0F);
        i.this.Atf.contentView.setAlpha(1.0F);
        i.this.Atf.AuD.setAlpha(1.0F);
        i.this.Atf.AuE.setAlpha(1.0F);
        if (i.this.AsL != null) {
          i.this.AsL.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        i.this.Atf.AuE.setAlpha(0.0F);
        i.this.Atf.AuD.setAlpha(0.0F);
        i.this.Atf.contentView.getLocationInWindow(i.this.uCL);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.uCL[0]), Integer.valueOf(i.this.uCL[1]) });
        ((ViewGroup)i.this.Atf.AaE).removeView(i.this.Atf.contentView);
        paramAnonymousAnimator = i.this.Atf.AaE.getLayoutParams();
        paramAnonymousAnimator.width = i.this.Atf.contentView.getWidth();
        paramAnonymousAnimator.height = (i.this.Atf.contentView.getHeight() + i.this.Atg.topMargin + i.this.Atg.bottomMargin);
        i.this.Atf.AaE.setLayoutParams(paramAnonymousAnimator);
        i.this.AsW = new FrameLayout.LayoutParams(-2, -2);
        i.this.AsW.leftMargin = i.this.uCL[0];
        i.this.AsW.rightMargin = (i.this.AsP.getWidth() - i.this.AsW.leftMargin - i.this.Atf.contentView.getWidth());
        i.this.AsW.topMargin = (i.this.uCL[1] - al.jG(paramMMActivity));
        i.this.AsW.bottomMargin = (i.this.AsP.getHeight() - i.this.AsW.topMargin - i.this.Atf.contentView.getHeight());
        i.this.AsP.addView(i.this.Atf.contentView, i.this.AsW);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */