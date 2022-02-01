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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class c
  extends a
{
  private AnimatorSet CPA;
  b ETZ;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  LinearLayout.LayoutParams EUd;
  LinearLayout.LayoutParams EUe;
  LinearLayout.LayoutParams EUf;
  FrameLayout.LayoutParams EUg;
  int[] wrA;
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99904);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.ETZ = ((b)parama);
    this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.ETZ.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.EUg.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.EUg.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.EUg.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.EUg.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.EUc.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.EUc.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.ETZ.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.ETZ.contentView.setAlpha(f);
          c.this.ETZ.EUV.setScaleX(f);
          c.this.ETZ.EUV.setScaleY(f);
          c.this.ETZ.EUV.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    this.EUa.setDuration(400L);
    this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.ETZ.EUW.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    this.EUb.setDuration(100L);
    this.EUb.setStartDelay(300L);
    this.EUd = ((LinearLayout.LayoutParams)this.ETZ.contentView.getLayoutParams());
    this.EUe = ((LinearLayout.LayoutParams)this.ETZ.EUV.getLayoutParams());
    this.EUf = ((LinearLayout.LayoutParams)this.ETZ.EUW.getLayoutParams());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.EUc = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99903);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.ETZ.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.ETZ.EUV);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.ETZ.EUW);
        c.this.ETZ.EUV.setScaleX(1.0F);
        c.this.ETZ.EUV.setScaleY(1.0F);
        c.this.ETZ.EUV.setAlpha(1.0F);
        ((ViewGroup)c.this.ETZ.EAV).addView(c.this.ETZ.contentView, c.this.EUd);
        ((ViewGroup)c.this.ETZ.contentView).addView(c.this.ETZ.EUV, c.this.EUe);
        ((ViewGroup)c.this.ETZ.contentView).addView(c.this.ETZ.EUW, c.this.EUf);
        c.this.ETZ.contentView.setAlpha(1.0F);
        c.this.ETZ.EUW.setAlpha(1.0F);
        if (c.this.ETY != null) {
          c.this.ETY.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.ETZ.contentView.getLocationInWindow(c.this.wrA);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.wrA[0]), Integer.valueOf(c.this.wrA[1]) });
        c.this.EUg = new FrameLayout.LayoutParams(-2, -2);
        c.this.EUg.leftMargin = c.this.wrA[0];
        c.this.EUg.rightMargin = (c.this.EUc.getWidth() - c.this.EUg.leftMargin - c.this.ETZ.contentView.getWidth());
        c.this.EUg.topMargin = (c.this.wrA[1] - ao.getStatusBarHeight(paramMMActivity));
        c.this.EUg.bottomMargin = (c.this.EUc.getHeight() - c.this.EUg.topMargin - c.this.ETZ.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.ETZ.EUV.getLocationInWindow((int[])localObject1);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.EUc.getWidth() - paramAnonymousAnimator.leftMargin - c.this.ETZ.EUV.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ao.getStatusBarHeight(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.EUc.getHeight() - paramAnonymousAnimator.topMargin - c.this.ETZ.EUV.getHeight());
        Object localObject2 = new int[2];
        c.this.ETZ.EUW.getLocationInWindow((int[])localObject2);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.EUc.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).EUW.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ao.getStatusBarHeight(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.EUc.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).EUW.getHeight());
        localObject2 = c.this.ETZ.EAV.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.ETZ.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.ETZ.contentView.getHeight() + c.this.EUd.topMargin + c.this.EUd.bottomMargin);
        c.this.ETZ.EAV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.ETZ.EUW.setAlpha(0.0F);
        ((ViewGroup)c.this.ETZ.EAV).removeView(c.this.ETZ.contentView);
        c.this.EUc.addView(c.this.ETZ.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.ETZ.contentView).removeView(c.this.ETZ.EUV);
        c.this.EUc.addView(c.this.ETZ.EUV, paramAnonymousAnimator);
        ((ViewGroup)c.this.ETZ.contentView).removeView(c.this.ETZ.EUW);
        c.this.EUc.addView(c.this.ETZ.EUW, (ViewGroup.LayoutParams)localObject1);
        c.this.ETZ.EUV.setScaleX(0.0F);
        c.this.ETZ.EUV.setScaleY(0.0F);
        c.this.ETZ.EUV.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */