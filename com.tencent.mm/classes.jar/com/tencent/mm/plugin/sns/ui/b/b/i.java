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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends a
{
  int[] tAc;
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  k.b zbB;
  FrameLayout.LayoutParams zbf;
  LinearLayout.LayoutParams zbp;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbB = ((k.b)paramBaseViewHolder);
    this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ac.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          i.this.zbB.zfH.setScaleX(f);
          i.this.zbB.zfH.setScaleY(f);
          i.this.zbB.zfH.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.zaW.setDuration(400L);
    this.zaW.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (i.this.zbB.fYC)
        {
          ac.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = i.this.xhG.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        i.this.zbB.fYC = true;
        i.this.zbB.rXY.setAlpha(0.0F);
        i.this.zbB.zbW.setAlpha(0.0F);
        i.this.zbB.zfH.getLocationInWindow(i.this.tAc);
        ac.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.tAc[0]), Integer.valueOf(i.this.tAc[1]) });
        i.this.zbB.zdl.removeView(i.this.zbB.zfH);
        paramAnonymousAnimator = i.this.zbB.zdl.getLayoutParams();
        paramAnonymousAnimator.width = i.this.zbB.zfH.getWidth();
        paramAnonymousAnimator.height = (i.this.zbB.zfH.getHeight() + i.this.zbp.topMargin + i.this.zbp.bottomMargin);
        i.this.zbB.zdl.setLayoutParams(paramAnonymousAnimator);
        i.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        i.this.zbf.leftMargin = i.this.tAc[0];
        i.this.zbf.rightMargin = (i.this.zaY.getWidth() - i.this.zbf.leftMargin - i.this.zbB.zfH.getWidth());
        i.this.zbf.topMargin = i.this.tAc[1];
        i.this.zbf.bottomMargin = (i.this.zaY.getHeight() - i.this.zbf.topMargin - i.this.zbB.zfH.getHeight());
        i.this.zaY.addView(i.this.zbB.zfH, i.this.zbf);
        AppMethodBeat.o(99992);
      }
    });
    this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.zbB.rXY.setAlpha(f);
        i.this.zbB.zbW.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.zaX.setDuration(100L);
    this.zaX.setStartDelay(300L);
    this.zbp = ((LinearLayout.LayoutParams)this.zbB.zfH.getLayoutParams());
    this.zaY = ((FrameLayout)this.activity.getBodyView().getParent());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        ac.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.zbB.zfH.getParent()).removeView(i.this.zbB.zfH);
        i.this.zbB.zdl.addView(i.this.zbB.zfH, i.this.zbp);
        i.this.zbB.zfH.setScaleX(1.0F);
        i.this.zbB.zfH.setScaleY(1.0F);
        i.this.zbB.zfH.setAlpha(1.0F);
        i.this.zbB.rXY.setAlpha(1.0F);
        i.this.zbB.zbW.setAlpha(1.0F);
        if (i.this.zaU != null) {
          i.this.zaU.onAnimationEnd();
        }
        i.this.zbB.fYC = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        ac.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */