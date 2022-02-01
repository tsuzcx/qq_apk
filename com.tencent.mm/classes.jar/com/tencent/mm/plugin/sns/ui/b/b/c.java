package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  extends a
{
  a.a Atj;
  AnimatorSet yvH;
  
  public c(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99954);
    this.activity = paramMMActivity;
    this.Atj = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99949);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          c.this.Atj.Awu.setScaleX(f);
          c.this.Atj.Awu.setScaleY(f);
          c.this.Atj.Awu.setAlpha(f);
        }
        AppMethodBeat.o(99949);
      }
    });
    paramMMActivity.setDuration(400L);
    paramMMActivity.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99950);
        if (c.this.Atj.grY)
        {
          ad.i("MicroMsg.CardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = c.this.yvH.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99950);
          return;
        }
        c.this.Atj.grY = true;
        AppMethodBeat.o(99950);
      }
    });
    paramBaseViewHolder = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramBaseViewHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99951);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.Atj.Awv.setAlpha(f);
        AppMethodBeat.o(99951);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    paramBaseViewHolder.setStartDelay(300L);
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99953);
        ad.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
        c.this.Atj.Awu.setScaleX(1.0F);
        c.this.Atj.Awu.setScaleY(1.0F);
        c.this.Atj.Awu.setAlpha(1.0F);
        c.this.Atj.Awv.setAlpha(1.0F);
        if (c.this.AsL != null) {
          c.this.AsL.onAnimationEnd();
        }
        c.this.Atj.grY = false;
        AppMethodBeat.o(99953);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99952);
        ad.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
        c.this.Atj.Awv.setAlpha(0.0F);
        AppMethodBeat.o(99952);
      }
    });
    AppMethodBeat.o(99954);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99955);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c
 * JD-Core Version:    0.7.0.1
 */