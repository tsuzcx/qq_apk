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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

public final class d
  extends b
{
  int[] ssm;
  private AnimatorSet vWT;
  com.tencent.mm.plugin.sns.ui.c.a.b xOf;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  LinearLayout.LayoutParams xOj;
  LinearLayout.LayoutParams xOk;
  LinearLayout.LayoutParams xOl;
  FrameLayout.LayoutParams xOp;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    AppMethodBeat.i(99910);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOf = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.xOf.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.xOp.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.xOp.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.xOp.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.xOp.bottomMargin * f));
          d.this.xOf.contentView.setLayoutParams(paramAnonymousValueAnimator);
          d.this.xOf.xOY.setScaleX(f);
          d.this.xOf.xOY.setScaleY(f);
          d.this.xOf.xOY.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    this.xOg.setDuration(400L);
    this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.xOf.xOZ.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    this.xOh.setDuration(100L);
    this.xOj = ((LinearLayout.LayoutParams)this.xOf.contentView.getLayoutParams());
    this.xOk = ((LinearLayout.LayoutParams)this.xOf.xOY.getLayoutParams());
    this.xOl = ((LinearLayout.LayoutParams)this.xOf.xOZ.getLayoutParams());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.xOi = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.xOf.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.xOf.xOY);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.xOf.xOZ);
        d.this.xOf.xOY.setScaleX(1.0F);
        d.this.xOf.xOY.setScaleY(1.0F);
        d.this.xOf.xOY.setAlpha(1.0F);
        ((ViewGroup)d.this.xOf.xwu).addView(d.this.xOf.contentView, d.this.xOj);
        ((ViewGroup)d.this.xOf.contentView).addView(d.this.xOf.xOY, d.this.xOk);
        ((ViewGroup)d.this.xOf.contentView).addView(d.this.xOf.xOZ, d.this.xOl);
        d.this.xOf.xOZ.setAlpha(1.0F);
        if (d.this.xOe != null) {
          d.this.xOe.onAnimationEnd();
        }
        AppMethodBeat.o(99909);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.xOf.contentView.getLocationInWindow(d.this.ssm);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.ssm[0]), Integer.valueOf(d.this.ssm[1]) });
        d.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        d.this.xOp.leftMargin = d.this.ssm[0];
        d.this.xOp.rightMargin = (d.this.xOi.getWidth() - d.this.xOp.leftMargin - d.this.xOf.contentView.getWidth());
        d.this.xOp.topMargin = (d.this.ssm[1] - ai.iX(paramMMActivity));
        d.this.xOp.bottomMargin = (d.this.xOi.getHeight() - d.this.xOp.topMargin - d.this.xOf.contentView.getHeight());
        ad.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.xOp.leftMargin), Integer.valueOf(d.this.xOp.topMargin), Integer.valueOf(d.this.xOp.rightMargin), Integer.valueOf(d.this.xOp.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.xOf.xOY.getLocationInWindow((int[])localObject1);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.xOi.getWidth() - paramAnonymousAnimator.leftMargin - d.this.xOf.xOY.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ai.iX(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.xOi.getHeight() - paramAnonymousAnimator.topMargin - d.this.xOf.xOY.getHeight());
        Object localObject2 = new int[2];
        d.this.xOf.xOZ.getLocationInWindow((int[])localObject2);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.xOi.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).xOZ.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ai.iX(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.xOi.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).xOZ.getHeight());
        localObject2 = d.this.xOf.xwu.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.xOf.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.xOf.contentView.getHeight() + d.this.xOj.topMargin + d.this.xOj.bottomMargin);
        d.this.xOf.xwu.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.xOf.xwu).removeView(d.this.xOf.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.xOp.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.xOp.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.xOp.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.xOp.bottomMargin;
        d.this.xOi.addView(d.this.xOf.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.xOf.contentView).removeView(d.this.xOf.xOY);
        d.this.xOi.addView(d.this.xOf.xOY, paramAnonymousAnimator);
        ((ViewGroup)d.this.xOf.contentView).removeView(d.this.xOf.xOZ);
        d.this.xOi.addView(d.this.xOf.xOZ, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(99910);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */