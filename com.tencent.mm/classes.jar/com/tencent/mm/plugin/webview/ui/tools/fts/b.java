package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  public b(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8);
  }
  
  private void ghc()
  {
    AppMethodBeat.i(80750);
    this.JoN.setPadding(this.JoM, 0, 0, 0);
    int i = this.zSm;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.JoN.getLayoutParams();
    localLayoutParams.leftMargin = (this.zSm - i);
    localLayoutParams.rightMargin = (this.zSm - i);
    localLayoutParams.width = (i * 2 + (int)this.JoU[2][0]);
    this.JoN.setLayoutParams(localLayoutParams);
    this.JoN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80743);
        b.this.JoN.setY(b.this.JoU[0][1]);
        b.this.JoN.setX(b.this.JoU[1][1]);
        AppMethodBeat.o(80743);
      }
    });
    AppMethodBeat.o(80750);
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(80748);
    if (paramb == this.JoW)
    {
      AppMethodBeat.o(80748);
      return;
    }
    switch (4.Jpg[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80748);
      return;
      gha();
      AppMethodBeat.o(80748);
      return;
      if (paramBoolean)
      {
        ghb();
        AppMethodBeat.o(80748);
        return;
      }
      ghc();
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(80747);
    a(paramb, true);
    AppMethodBeat.o(80747);
  }
  
  protected final void gha()
  {
    AppMethodBeat.i(80749);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.JoU[0][0] - this.JoK >= 0.0F) {
      localValueAnimator.addUpdateListener(this.Jpa);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.JoT, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setInterpolator(new DecelerateInterpolator());
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80742);
          b.this.isAnimating = false;
          if (b.this.JoX != null) {
            b.this.JoX.onAnimationEnd();
          }
          AppMethodBeat.o(80742);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80741);
          b.this.isAnimating = true;
          if (b.this.JoX != null) {
            b.this.JoX.onAnimationStart();
          }
          AppMethodBeat.o(80741);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80749);
      return;
      localValueAnimator.addUpdateListener(this.Jpb);
    }
  }
  
  protected final void ghb()
  {
    AppMethodBeat.i(80751);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.JoU[0][0] - this.JoK >= 0.0F) {
      localValueAnimator.addUpdateListener(this.JoY);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.JoT, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setInterpolator(new DecelerateInterpolator());
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80745);
          b.this.isAnimating = false;
          if (b.this.JoX != null) {
            b.this.JoX.onAnimationEnd();
          }
          AppMethodBeat.o(80745);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80744);
          b.this.isAnimating = true;
          if (b.this.JoX != null) {
            b.this.JoX.onAnimationStart();
          }
          AppMethodBeat.o(80744);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80751);
      return;
      localValueAnimator.addUpdateListener(this.JoZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b
 * JD-Core Version:    0.7.0.1
 */