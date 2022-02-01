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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class j
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  FrameLayout.LayoutParams AsW;
  e Atf;
  LinearLayout.LayoutParams Atg;
  int[] uCL;
  private AnimatorSet yvH;
  
  public j(final MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99947);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.Atf = ((e)parama);
    this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          j.this.Atf.contentView.setScaleX(f);
          j.this.Atf.contentView.setScaleY(f);
          j.this.Atf.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.AsN.setDuration(400L);
    this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.Atf.AuE.setAlpha(f);
        j.this.Atf.AuD.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.AsO.setDuration(100L);
    this.Atg = ((LinearLayout.LayoutParams)this.Atf.contentView.getLayoutParams());
    this.AsP = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.Atf.contentView);
        ((ViewGroup)j.this.Atf.AaE).addView(j.this.Atf.contentView, j.this.Atg);
        j.this.Atf.contentView.setScaleX(1.0F);
        j.this.Atf.contentView.setScaleY(1.0F);
        j.this.Atf.contentView.setAlpha(1.0F);
        j.this.Atf.AuE.setAlpha(1.0F);
        j.this.Atf.AuD.setAlpha(1.0F);
        if (j.this.AsL != null) {
          j.this.AsL.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        j.this.Atf.contentView.getLocationInWindow(j.this.uCL);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.uCL[0]), Integer.valueOf(j.this.uCL[1]) });
        ((ViewGroup)j.this.Atf.AaE).removeView(j.this.Atf.contentView);
        paramAnonymousAnimator = j.this.Atf.AaE.getLayoutParams();
        paramAnonymousAnimator.width = j.this.Atf.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.Atf.contentView.getHeight() + j.this.Atg.topMargin + j.this.Atg.bottomMargin);
        j.this.Atf.AaE.setLayoutParams(paramAnonymousAnimator);
        j.this.AsW = new FrameLayout.LayoutParams(-2, -2);
        j.this.AsW.leftMargin = j.this.uCL[0];
        j.this.AsW.rightMargin = (j.this.AsP.getWidth() - j.this.AsW.leftMargin - j.this.Atf.contentView.getWidth());
        j.this.AsW.topMargin = (j.this.uCL[1] - al.jG(paramMMActivity));
        j.this.AsW.bottomMargin = (j.this.AsP.getHeight() - j.this.AsW.topMargin - j.this.Atf.contentView.getHeight());
        j.this.AsP.addView(j.this.Atf.contentView, j.this.AsW);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */