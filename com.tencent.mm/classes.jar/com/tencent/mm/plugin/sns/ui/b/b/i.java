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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends a
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  FrameLayout.LayoutParams AsW;
  LinearLayout.LayoutParams Atg;
  m.b Ats;
  int[] uCL;
  AnimatorSet yvH;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.Ats = ((m.b)paramBaseViewHolder);
    this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ad.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          i.this.Ats.AxF.setScaleX(f);
          i.this.Ats.AxF.setScaleY(f);
          i.this.Ats.AxF.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.AsN.setDuration(400L);
    this.AsN.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (i.this.Ats.grY)
        {
          ad.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = i.this.yvH.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        i.this.Ats.grY = true;
        i.this.Ats.sUS.setAlpha(0.0F);
        i.this.Ats.AtN.setAlpha(0.0F);
        i.this.Ats.AxF.getLocationInWindow(i.this.uCL);
        ad.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.uCL[0]), Integer.valueOf(i.this.uCL[1]) });
        i.this.Ats.Avb.removeView(i.this.Ats.AxF);
        paramAnonymousAnimator = i.this.Ats.Avb.getLayoutParams();
        paramAnonymousAnimator.width = i.this.Ats.AxF.getWidth();
        paramAnonymousAnimator.height = (i.this.Ats.AxF.getHeight() + i.this.Atg.topMargin + i.this.Atg.bottomMargin);
        i.this.Ats.Avb.setLayoutParams(paramAnonymousAnimator);
        i.this.AsW = new FrameLayout.LayoutParams(-2, -2);
        i.this.AsW.leftMargin = i.this.uCL[0];
        i.this.AsW.rightMargin = (i.this.AsP.getWidth() - i.this.AsW.leftMargin - i.this.Ats.AxF.getWidth());
        i.this.AsW.topMargin = i.this.uCL[1];
        i.this.AsW.bottomMargin = (i.this.AsP.getHeight() - i.this.AsW.topMargin - i.this.Ats.AxF.getHeight());
        i.this.AsP.addView(i.this.Ats.AxF, i.this.AsW);
        AppMethodBeat.o(99992);
      }
    });
    this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.Ats.sUS.setAlpha(f);
        i.this.Ats.AtN.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.AsO.setDuration(100L);
    this.AsO.setStartDelay(300L);
    this.Atg = ((LinearLayout.LayoutParams)this.Ats.AxF.getLayoutParams());
    this.AsP = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        ad.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.Ats.AxF.getParent()).removeView(i.this.Ats.AxF);
        i.this.Ats.Avb.addView(i.this.Ats.AxF, i.this.Atg);
        i.this.Ats.AxF.setScaleX(1.0F);
        i.this.Ats.AxF.setScaleY(1.0F);
        i.this.Ats.AxF.setAlpha(1.0F);
        i.this.Ats.sUS.setAlpha(1.0F);
        i.this.Ats.AtN.setAlpha(1.0F);
        if (i.this.AsL != null) {
          i.this.AsL.onAnimationEnd();
        }
        i.this.Ats.grY = false;
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
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */