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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class c
  extends a
{
  b AsM;
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  LinearLayout.LayoutParams AsQ;
  LinearLayout.LayoutParams AsR;
  LinearLayout.LayoutParams AsS;
  FrameLayout.LayoutParams AsT;
  int[] uCL;
  private AnimatorSet yvH;
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99904);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.AsM = ((b)parama);
    this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.AsM.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.AsT.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.AsT.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.AsT.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.AsT.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.AsP.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.AsP.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.AsM.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.AsM.contentView.setAlpha(f);
          c.this.AsM.AtF.setScaleX(f);
          c.this.AsM.AtF.setScaleY(f);
          c.this.AsM.AtF.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    this.AsN.setDuration(400L);
    this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.AsM.AtG.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    this.AsO.setDuration(100L);
    this.AsO.setStartDelay(300L);
    this.AsQ = ((LinearLayout.LayoutParams)this.AsM.contentView.getLayoutParams());
    this.AsR = ((LinearLayout.LayoutParams)this.AsM.AtF.getLayoutParams());
    this.AsS = ((LinearLayout.LayoutParams)this.AsM.AtG.getLayoutParams());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.AsP = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99903);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AsM.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AsM.AtF);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.AsM.AtG);
        c.this.AsM.AtF.setScaleX(1.0F);
        c.this.AsM.AtF.setScaleY(1.0F);
        c.this.AsM.AtF.setAlpha(1.0F);
        ((ViewGroup)c.this.AsM.AaE).addView(c.this.AsM.contentView, c.this.AsQ);
        ((ViewGroup)c.this.AsM.contentView).addView(c.this.AsM.AtF, c.this.AsR);
        ((ViewGroup)c.this.AsM.contentView).addView(c.this.AsM.AtG, c.this.AsS);
        c.this.AsM.contentView.setAlpha(1.0F);
        c.this.AsM.AtG.setAlpha(1.0F);
        if (c.this.AsL != null) {
          c.this.AsL.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.AsM.contentView.getLocationInWindow(c.this.uCL);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.uCL[0]), Integer.valueOf(c.this.uCL[1]) });
        c.this.AsT = new FrameLayout.LayoutParams(-2, -2);
        c.this.AsT.leftMargin = c.this.uCL[0];
        c.this.AsT.rightMargin = (c.this.AsP.getWidth() - c.this.AsT.leftMargin - c.this.AsM.contentView.getWidth());
        c.this.AsT.topMargin = (c.this.uCL[1] - al.jG(paramMMActivity));
        c.this.AsT.bottomMargin = (c.this.AsP.getHeight() - c.this.AsT.topMargin - c.this.AsM.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.AsM.AtF.getLocationInWindow((int[])localObject1);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.AsP.getWidth() - paramAnonymousAnimator.leftMargin - c.this.AsM.AtF.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - al.jG(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.AsP.getHeight() - paramAnonymousAnimator.topMargin - c.this.AsM.AtF.getHeight());
        Object localObject2 = new int[2];
        c.this.AsM.AtG.getLocationInWindow((int[])localObject2);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.AsP.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).AtG.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - al.jG(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.AsP.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).AtG.getHeight());
        localObject2 = c.this.AsM.AaE.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.AsM.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.AsM.contentView.getHeight() + c.this.AsQ.topMargin + c.this.AsQ.bottomMargin);
        c.this.AsM.AaE.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.AsM.AtG.setAlpha(0.0F);
        ((ViewGroup)c.this.AsM.AaE).removeView(c.this.AsM.contentView);
        c.this.AsP.addView(c.this.AsM.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.AsM.contentView).removeView(c.this.AsM.AtF);
        c.this.AsP.addView(c.this.AsM.AtF, paramAnonymousAnimator);
        ((ViewGroup)c.this.AsM.contentView).removeView(c.this.AsM.AtG);
        c.this.AsP.addView(c.this.AsM.AtG, (ViewGroup.LayoutParams)localObject1);
        c.this.AsM.AtF.setScaleX(0.0F);
        c.this.AsM.AtF.setScaleY(0.0F);
        c.this.AsM.AtF.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */