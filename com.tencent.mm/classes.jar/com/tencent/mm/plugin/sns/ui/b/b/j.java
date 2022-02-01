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

public final class j
  extends b
{
  int[] tAc;
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  k.b zbB;
  FrameLayout.LayoutParams zbf;
  LinearLayout.LayoutParams zbp;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbB = ((k.b)paramBaseViewHolder);
    this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ac.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          j.this.zbB.zfH.setScaleX(f);
          j.this.zbB.zfH.setScaleY(f);
          j.this.zbB.zfH.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.zaW.setDuration(400L);
    this.zaW.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (j.this.zbB.fYC)
        {
          ac.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = j.this.xhG.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        j.this.zbB.fYC = true;
        j.this.zbB.zfH.getLocationInWindow(j.this.tAc);
        ac.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(j.this.tAc[0]), Integer.valueOf(j.this.tAc[1]), Integer.valueOf(j.this.zbB.zfH.getWidth()), Integer.valueOf(j.this.zbB.zfH.getHeight()) });
        j.this.zbB.zdl.removeView(j.this.zbB.zfH);
        paramAnonymousAnimator = j.this.zbB.zdl.getLayoutParams();
        paramAnonymousAnimator.width = j.this.zbB.zfH.getWidth();
        paramAnonymousAnimator.height = (j.this.zbB.zfH.getHeight() + j.this.zbp.topMargin + j.this.zbp.bottomMargin);
        j.this.zbB.zdl.setLayoutParams(paramAnonymousAnimator);
        j.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        j.this.zbf.leftMargin = j.this.tAc[0];
        j.this.zbf.rightMargin = (j.this.zaY.getWidth() - j.this.zbf.leftMargin - j.this.zbB.zfH.getWidth());
        j.this.zbf.topMargin = j.this.tAc[1];
        j.this.zbf.bottomMargin = (j.this.zaY.getHeight() - j.this.zbf.topMargin - j.this.zbB.zfH.getHeight());
        j.this.zaY.addView(j.this.zbB.zfH, j.this.zbf);
        AppMethodBeat.o(99999);
      }
    });
    this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.zbB.rXY.setAlpha(f);
        j.this.zbB.zbW.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.zaX.setDuration(100L);
    this.zbp = ((LinearLayout.LayoutParams)this.zbB.zfH.getLayoutParams());
    this.zaY = ((FrameLayout)this.activity.getBodyView().getParent());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        ac.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.zbB.zfH.getParent()).removeView(j.this.zbB.zfH);
        j.this.zbB.zdl.addView(j.this.zbB.zfH, j.this.zbp);
        j.this.zbB.zfH.setScaleX(1.0F);
        j.this.zbB.zfH.setScaleY(1.0F);
        j.this.zbB.zfH.setAlpha(1.0F);
        j.this.zbB.rXY.setAlpha(1.0F);
        j.this.zbB.zbW.setAlpha(1.0F);
        if (j.this.zaU != null) {
          j.this.zaU.onAnimationEnd();
        }
        j.this.zbB.fYC = false;
        AppMethodBeat.o(100002);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100001);
        ac.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(100001);
      }
    });
    AppMethodBeat.o(100003);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */