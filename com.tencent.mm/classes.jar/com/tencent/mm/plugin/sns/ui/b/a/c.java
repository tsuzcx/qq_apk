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
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class c
  extends a
{
  b AKa;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  LinearLayout.LayoutParams AKe;
  LinearLayout.LayoutParams AKf;
  LinearLayout.LayoutParams AKg;
  FrameLayout.LayoutParams AKh;
  int[] uOq;
  private AnimatorSet yLH;
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99904);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKa = ((b)parama);
    this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.AKa.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.AKh.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.AKh.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.AKh.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.AKh.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.AKd.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.AKd.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.AKa.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.AKa.contentView.setAlpha(f);
          c.this.AKa.AKU.setScaleX(f);
          c.this.AKa.AKU.setScaleY(f);
          c.this.AKa.AKU.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    this.AKb.setDuration(400L);
    this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.AKa.AKV.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    this.AKc.setDuration(100L);
    this.AKc.setStartDelay(300L);
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
        AppMethodBeat.i(99903);
        ae.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AKa.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AKa.AKU);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AKa.AKV);
        c.this.AKa.AKU.setScaleX(1.0F);
        c.this.AKa.AKU.setScaleY(1.0F);
        c.this.AKa.AKU.setAlpha(1.0F);
        ((ViewGroup)c.this.AKa.ArR).addView(c.this.AKa.contentView, c.this.AKe);
        ((ViewGroup)c.this.AKa.contentView).addView(c.this.AKa.AKU, c.this.AKf);
        ((ViewGroup)c.this.AKa.contentView).addView(c.this.AKa.AKV, c.this.AKg);
        c.this.AKa.contentView.setAlpha(1.0F);
        c.this.AKa.AKV.setAlpha(1.0F);
        if (c.this.AJZ != null) {
          c.this.AJZ.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        ae.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.AKa.contentView.getLocationInWindow(c.this.uOq);
        ae.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.uOq[0]), Integer.valueOf(c.this.uOq[1]) });
        c.this.AKh = new FrameLayout.LayoutParams(-2, -2);
        c.this.AKh.leftMargin = c.this.uOq[0];
        c.this.AKh.rightMargin = (c.this.AKd.getWidth() - c.this.AKh.leftMargin - c.this.AKa.contentView.getWidth());
        c.this.AKh.topMargin = (c.this.uOq[1] - al.jN(paramMMActivity));
        c.this.AKh.bottomMargin = (c.this.AKd.getHeight() - c.this.AKh.topMargin - c.this.AKa.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.AKa.AKU.getLocationInWindow((int[])localObject1);
        ae.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.AKd.getWidth() - paramAnonymousAnimator.leftMargin - c.this.AKa.AKU.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - al.jN(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.AKd.getHeight() - paramAnonymousAnimator.topMargin - c.this.AKa.AKU.getHeight());
        Object localObject2 = new int[2];
        c.this.AKa.AKV.getLocationInWindow((int[])localObject2);
        ae.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.AKd.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).AKV.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - al.jN(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.AKd.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).AKV.getHeight());
        localObject2 = c.this.AKa.ArR.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.AKa.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.AKa.contentView.getHeight() + c.this.AKe.topMargin + c.this.AKe.bottomMargin);
        c.this.AKa.ArR.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.AKa.AKV.setAlpha(0.0F);
        ((ViewGroup)c.this.AKa.ArR).removeView(c.this.AKa.contentView);
        c.this.AKd.addView(c.this.AKa.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.AKa.contentView).removeView(c.this.AKa.AKU);
        c.this.AKd.addView(c.this.AKa.AKU, paramAnonymousAnimator);
        ((ViewGroup)c.this.AKa.contentView).removeView(c.this.AKa.AKV);
        c.this.AKd.addView(c.this.AKa.AKV, (ViewGroup.LayoutParams)localObject1);
        c.this.AKa.AKU.setScaleX(0.0F);
        c.this.AKa.AKU.setScaleY(0.0F);
        c.this.AKa.AKU.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */