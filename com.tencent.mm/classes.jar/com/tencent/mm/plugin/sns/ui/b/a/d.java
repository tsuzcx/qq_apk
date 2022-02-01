package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class d
  extends b
{
  com.tencent.mm.plugin.sns.ui.c.a.b AKa;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  LinearLayout.LayoutParams AKe;
  LinearLayout.LayoutParams AKf;
  LinearLayout.LayoutParams AKg;
  FrameLayout.LayoutParams AKk;
  int[] uOq;
  private AnimatorSet yLH;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    AppMethodBeat.i(99910);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKa = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.AKa.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.AKk.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.AKk.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.AKk.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.AKk.bottomMargin * f));
          d.this.AKa.contentView.setLayoutParams(paramAnonymousValueAnimator);
          d.this.AKa.AKU.setScaleX(f);
          d.this.AKa.AKU.setScaleY(f);
          d.this.AKa.AKU.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    this.AKb.setDuration(400L);
    this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.AKa.AKV.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    this.AKc.setDuration(100L);
    this.AKe = ((LinearLayout.LayoutParams)this.AKa.contentView.getLayoutParams());
    this.AKf = ((LinearLayout.LayoutParams)this.AKa.AKU.getLayoutParams());
    this.AKg = ((LinearLayout.LayoutParams)this.AKa.AKV.getLayoutParams());
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
    this.AKd = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        ae.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AKa.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AKa.AKU);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AKa.AKV);
        d.this.AKa.AKU.setScaleX(1.0F);
        d.this.AKa.AKU.setScaleY(1.0F);
        d.this.AKa.AKU.setAlpha(1.0F);
        ((ViewGroup)d.this.AKa.ArR).addView(d.this.AKa.contentView, d.this.AKe);
        ((ViewGroup)d.this.AKa.contentView).addView(d.this.AKa.AKU, d.this.AKf);
        ((ViewGroup)d.this.AKa.contentView).addView(d.this.AKa.AKV, d.this.AKg);
        d.this.AKa.AKV.setAlpha(1.0F);
        if (d.this.AJZ != null) {
          d.this.AJZ.onAnimationEnd();
        }
        AppMethodBeat.o(99909);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        ae.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.AKa.contentView.getLocationInWindow(d.this.uOq);
        ae.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.uOq[0]), Integer.valueOf(d.this.uOq[1]) });
        d.this.AKk = new FrameLayout.LayoutParams(-2, -2);
        d.this.AKk.leftMargin = d.this.uOq[0];
        d.this.AKk.rightMargin = (d.this.AKd.getWidth() - d.this.AKk.leftMargin - d.this.AKa.contentView.getWidth());
        d.this.AKk.topMargin = (d.this.uOq[1] - al.jN(paramMMActivity));
        d.this.AKk.bottomMargin = (d.this.AKd.getHeight() - d.this.AKk.topMargin - d.this.AKa.contentView.getHeight());
        ae.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.AKk.leftMargin), Integer.valueOf(d.this.AKk.topMargin), Integer.valueOf(d.this.AKk.rightMargin), Integer.valueOf(d.this.AKk.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.AKa.AKU.getLocationInWindow((int[])localObject1);
        ae.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.AKd.getWidth() - paramAnonymousAnimator.leftMargin - d.this.AKa.AKU.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - al.jN(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.AKd.getHeight() - paramAnonymousAnimator.topMargin - d.this.AKa.AKU.getHeight());
        Object localObject2 = new int[2];
        d.this.AKa.AKV.getLocationInWindow((int[])localObject2);
        ae.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.AKd.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).AKV.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - al.jN(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.AKd.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).AKV.getHeight());
        localObject2 = d.this.AKa.ArR.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.AKa.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.AKa.contentView.getHeight() + d.this.AKe.topMargin + d.this.AKe.bottomMargin);
        d.this.AKa.ArR.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.AKa.ArR).removeView(d.this.AKa.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.AKk.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.AKk.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.AKk.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.AKk.bottomMargin;
        d.this.AKd.addView(d.this.AKa.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.AKa.contentView).removeView(d.this.AKa.AKU);
        d.this.AKd.addView(d.this.AKa.AKU, paramAnonymousAnimator);
        ((ViewGroup)d.this.AKa.contentView).removeView(d.this.AKa.AKV);
        d.this.AKd.addView(d.this.AKa.AKV, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(99910);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */