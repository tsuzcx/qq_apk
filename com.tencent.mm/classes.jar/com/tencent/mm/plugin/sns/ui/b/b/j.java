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
import com.tencent.mm.plugin.sns.ui.item.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  extends b
{
  int[] ssm;
  AnimatorSet vWT;
  k.b xOL;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  FrameLayout.LayoutParams xOp;
  LinearLayout.LayoutParams xOz;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOL = ((k.b)paramBaseViewHolder);
    this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ad.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          j.this.xOL.xSM.setScaleX(f);
          j.this.xOL.xSM.setScaleY(f);
          j.this.xOL.xSM.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.xOg.setDuration(400L);
    this.xOg.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (j.this.xOL.fUH)
        {
          ad.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = j.this.vWT.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        j.this.xOL.fUH = true;
        j.this.xOL.xSM.getLocationInWindow(j.this.ssm);
        ad.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(j.this.ssm[0]), Integer.valueOf(j.this.ssm[1]), Integer.valueOf(j.this.xOL.xSM.getWidth()), Integer.valueOf(j.this.xOL.xSM.getHeight()) });
        j.this.xOL.xQv.removeView(j.this.xOL.xSM);
        paramAnonymousAnimator = j.this.xOL.xQv.getLayoutParams();
        paramAnonymousAnimator.width = j.this.xOL.xSM.getWidth();
        paramAnonymousAnimator.height = (j.this.xOL.xSM.getHeight() + j.this.xOz.topMargin + j.this.xOz.bottomMargin);
        j.this.xOL.xQv.setLayoutParams(paramAnonymousAnimator);
        j.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        j.this.xOp.leftMargin = j.this.ssm[0];
        j.this.xOp.rightMargin = (j.this.xOi.getWidth() - j.this.xOp.leftMargin - j.this.xOL.xSM.getWidth());
        j.this.xOp.topMargin = j.this.ssm[1];
        j.this.xOp.bottomMargin = (j.this.xOi.getHeight() - j.this.xOp.topMargin - j.this.xOL.xSM.getHeight());
        j.this.xOi.addView(j.this.xOL.xSM, j.this.xOp);
        AppMethodBeat.o(99999);
      }
    });
    this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.xOL.qXs.setAlpha(f);
        j.this.xOL.xPg.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.xOh.setDuration(100L);
    this.xOz = ((LinearLayout.LayoutParams)this.xOL.xSM.getLayoutParams());
    this.xOi = ((FrameLayout)this.activity.getBodyView().getParent());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        ad.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.xOL.xSM.getParent()).removeView(j.this.xOL.xSM);
        j.this.xOL.xQv.addView(j.this.xOL.xSM, j.this.xOz);
        j.this.xOL.xSM.setScaleX(1.0F);
        j.this.xOL.xSM.setScaleY(1.0F);
        j.this.xOL.xSM.setAlpha(1.0F);
        j.this.xOL.qXs.setAlpha(1.0F);
        j.this.xOL.xPg.setAlpha(1.0F);
        if (j.this.xOe != null) {
          j.this.xOe.onAnimationEnd();
        }
        j.this.xOL.fUH = false;
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
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */