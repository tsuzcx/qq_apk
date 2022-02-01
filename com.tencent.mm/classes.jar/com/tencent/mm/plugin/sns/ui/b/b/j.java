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

public final class j
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  FrameLayout.LayoutParams AsW;
  LinearLayout.LayoutParams Atg;
  m.b Ats;
  int[] uCL;
  AnimatorSet yvH;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.Ats = ((m.b)paramBaseViewHolder);
    this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ad.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          j.this.Ats.AxF.setScaleX(f);
          j.this.Ats.AxF.setScaleY(f);
          j.this.Ats.AxF.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.AsN.setDuration(400L);
    this.AsN.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (j.this.Ats.grY)
        {
          ad.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = j.this.yvH.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        j.this.Ats.grY = true;
        j.this.Ats.AxF.getLocationInWindow(j.this.uCL);
        ad.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(j.this.uCL[0]), Integer.valueOf(j.this.uCL[1]), Integer.valueOf(j.this.Ats.AxF.getWidth()), Integer.valueOf(j.this.Ats.AxF.getHeight()) });
        j.this.Ats.Avb.removeView(j.this.Ats.AxF);
        paramAnonymousAnimator = j.this.Ats.Avb.getLayoutParams();
        paramAnonymousAnimator.width = j.this.Ats.AxF.getWidth();
        paramAnonymousAnimator.height = (j.this.Ats.AxF.getHeight() + j.this.Atg.topMargin + j.this.Atg.bottomMargin);
        j.this.Ats.Avb.setLayoutParams(paramAnonymousAnimator);
        j.this.AsW = new FrameLayout.LayoutParams(-2, -2);
        j.this.AsW.leftMargin = j.this.uCL[0];
        j.this.AsW.rightMargin = (j.this.AsP.getWidth() - j.this.AsW.leftMargin - j.this.Ats.AxF.getWidth());
        j.this.AsW.topMargin = j.this.uCL[1];
        j.this.AsW.bottomMargin = (j.this.AsP.getHeight() - j.this.AsW.topMargin - j.this.Ats.AxF.getHeight());
        j.this.AsP.addView(j.this.Ats.AxF, j.this.AsW);
        AppMethodBeat.o(99999);
      }
    });
    this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.Ats.sUS.setAlpha(f);
        j.this.Ats.AtN.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.AsO.setDuration(100L);
    this.Atg = ((LinearLayout.LayoutParams)this.Ats.AxF.getLayoutParams());
    this.AsP = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        ad.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.Ats.AxF.getParent()).removeView(j.this.Ats.AxF);
        j.this.Ats.Avb.addView(j.this.Ats.AxF, j.this.Atg);
        j.this.Ats.AxF.setScaleX(1.0F);
        j.this.Ats.AxF.setScaleY(1.0F);
        j.this.Ats.AxF.setAlpha(1.0F);
        j.this.Ats.sUS.setAlpha(1.0F);
        j.this.Ats.AtN.setAlpha(1.0F);
        if (j.this.AsL != null) {
          j.this.AsL.onAnimationEnd();
        }
        j.this.Ats.grY = false;
        AppMethodBeat.o(100002);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100001);
        ad.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(100001);
      }
    });
    AppMethodBeat.o(100003);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */