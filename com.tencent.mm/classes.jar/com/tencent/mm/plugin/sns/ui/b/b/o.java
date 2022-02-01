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

public final class o
  extends a
{
  int[] BdE;
  AnimatorSet IVc;
  r.b LiS;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  ViewGroup Liv;
  LinearLayout.LayoutParams Liw;
  FrameLayout.LayoutParams Lix;
  
  public o(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.BdE = new int[2];
    this.activity = paramMMActivity;
    this.LiS = ((r.b)paramBaseViewHolder);
    this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          o.this.LiS.LnX.setScaleX(f);
          o.this.LiS.LnX.setScaleY(f);
          o.this.LiS.LnX.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.Lif.setDuration(400L);
    this.Lif.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (o.this.LiS.jTm)
        {
          Log.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = o.this.IVc.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        o.this.LiS.jTm = true;
        o.this.LiS.AZc.setAlpha(0.0F);
        o.this.LiS.JKr.setAlpha(0.0F);
        o.this.LiS.LnX.getLocationInWindow(o.this.BdE);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(o.this.BdE[0]), Integer.valueOf(o.this.BdE[1]) });
        o.this.LiS.LkQ.removeView(o.this.LiS.LnX);
        paramAnonymousAnimator = o.this.LiS.LkQ.getLayoutParams();
        paramAnonymousAnimator.width = o.this.LiS.LnX.getWidth();
        paramAnonymousAnimator.height = (o.this.LiS.LnX.getHeight() + o.this.Liw.topMargin + o.this.Liw.bottomMargin);
        o.this.LiS.LkQ.setLayoutParams(paramAnonymousAnimator);
        o.this.Lix = new FrameLayout.LayoutParams(-2, -2);
        o.this.Lix.leftMargin = o.this.BdE[0];
        o.this.Lix.rightMargin = (o.this.Liv.getWidth() - o.this.Lix.leftMargin - o.this.LiS.LnX.getWidth());
        o.this.Lix.topMargin = o.this.BdE[1];
        o.this.Lix.bottomMargin = (o.this.Liv.getHeight() - o.this.Lix.topMargin - o.this.LiS.LnX.getHeight());
        o.this.Liv.addView(o.this.LiS.LnX, o.this.Lix);
        AppMethodBeat.o(99992);
      }
    });
    this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        o.this.LiS.AZc.setAlpha(f);
        o.this.LiS.JKr.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.Lig.setDuration(100L);
    this.Lig.setStartDelay(300L);
    this.Liw = ((LinearLayout.LayoutParams)this.LiS.LnX.getLayoutParams());
    this.Liv = ((FrameLayout)this.activity.getBodyView().getParent());
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)o.this.LiS.LnX.getParent()).removeView(o.this.LiS.LnX);
        o.this.LiS.LkQ.addView(o.this.LiS.LnX, o.this.Liw);
        o.this.LiS.LnX.setScaleX(1.0F);
        o.this.LiS.LnX.setScaleY(1.0F);
        o.this.LiS.LnX.setAlpha(1.0F);
        o.this.LiS.AZc.setAlpha(1.0F);
        o.this.LiS.JKr.setAlpha(1.0F);
        if (o.this.Lia != null) {
          o.this.Lia.onAnimationEnd();
        }
        o.this.LiS.jTm = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.o
 * JD-Core Version:    0.7.0.1
 */