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
import com.tencent.mm.plugin.sns.ui.item.r.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
  extends b
{
  int[] BdE;
  AnimatorSet IVc;
  r.b LiS;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  ViewGroup Liv;
  LinearLayout.LayoutParams Liw;
  FrameLayout.LayoutParams Lix;
  
  public p(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.BdE = new int[2];
    this.activity = paramMMActivity;
    this.LiS = ((r.b)paramBaseViewHolder);
    this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          p.this.LiS.LnX.setScaleX(f);
          p.this.LiS.LnX.setScaleY(f);
          p.this.LiS.LnX.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.Lif.setDuration(400L);
    this.Lif.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (p.this.LiS.jTm)
        {
          Log.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = p.this.IVc.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        p.this.LiS.jTm = true;
        p.this.LiS.LnX.getLocationInWindow(p.this.BdE);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(p.this.BdE[0]), Integer.valueOf(p.this.BdE[1]), Integer.valueOf(p.this.LiS.LnX.getWidth()), Integer.valueOf(p.this.LiS.LnX.getHeight()) });
        p.this.LiS.LkQ.removeView(p.this.LiS.LnX);
        paramAnonymousAnimator = p.this.LiS.LkQ.getLayoutParams();
        paramAnonymousAnimator.width = p.this.LiS.LnX.getWidth();
        paramAnonymousAnimator.height = (p.this.LiS.LnX.getHeight() + p.this.Liw.topMargin + p.this.Liw.bottomMargin);
        p.this.LiS.LkQ.setLayoutParams(paramAnonymousAnimator);
        p.this.Lix = new FrameLayout.LayoutParams(-2, -2);
        p.this.Lix.leftMargin = p.this.BdE[0];
        p.this.Lix.rightMargin = (p.this.Liv.getWidth() - p.this.Lix.leftMargin - p.this.LiS.LnX.getWidth());
        p.this.Lix.topMargin = p.this.BdE[1];
        p.this.Lix.bottomMargin = (p.this.Liv.getHeight() - p.this.Lix.topMargin - p.this.LiS.LnX.getHeight());
        p.this.Liv.addView(p.this.LiS.LnX, p.this.Lix);
        AppMethodBeat.o(99999);
      }
    });
    this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        p.this.LiS.AZc.setAlpha(f);
        p.this.LiS.JKr.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.Lig.setDuration(100L);
    this.Liw = ((LinearLayout.LayoutParams)this.LiS.LnX.getLayoutParams());
    this.Liv = ((FrameLayout)this.activity.getBodyView().getParent());
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)p.this.LiS.LnX.getParent()).removeView(p.this.LiS.LnX);
        p.this.LiS.LkQ.addView(p.this.LiS.LnX, p.this.Liw);
        p.this.LiS.LnX.setScaleX(1.0F);
        p.this.LiS.LnX.setScaleY(1.0F);
        p.this.LiS.LnX.setAlpha(1.0F);
        p.this.LiS.AZc.setAlpha(1.0F);
        p.this.LiS.JKr.setAlpha(1.0F);
        if (p.this.Lia != null) {
          p.this.Lia.onAnimationEnd();
        }
        p.this.LiS.jTm = false;
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
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.p
 * JD-Core Version:    0.7.0.1
 */