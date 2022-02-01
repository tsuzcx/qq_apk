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
  
  private void eFo()
  {
    AppMethodBeat.i(80750);
    this.CDR.setPadding(this.CDQ, 0, 0, 0);
    int i = this.vaA;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CDR.getLayoutParams();
    localLayoutParams.leftMargin = (this.vaA - i);
    localLayoutParams.rightMargin = (this.vaA - i);
    localLayoutParams.width = (i * 2 + (int)this.CDY[2][0]);
    this.CDR.setLayoutParams(localLayoutParams);
    this.CDR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80743);
        b.this.CDR.setY(b.this.CDY[0][1]);
        b.this.CDR.setX(b.this.CDY[1][1]);
        AppMethodBeat.o(80743);
      }
    });
    AppMethodBeat.o(80750);
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(80748);
    if (paramb == this.CEa)
    {
      AppMethodBeat.o(80748);
      return;
    }
    switch (4.CEk[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80748);
      return;
      eFm();
      AppMethodBeat.o(80748);
      return;
      if (paramBoolean)
      {
        eFn();
        AppMethodBeat.o(80748);
        return;
      }
      eFo();
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(80747);
    a(paramb, true);
    AppMethodBeat.o(80747);
  }
  
  protected final void eFm()
  {
    AppMethodBeat.i(80749);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.CDY[0][0] - this.CDO >= 0.0F) {
      localValueAnimator.addUpdateListener(this.CEe);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.CDX, "alpha", new float[] { 0.0F, 1.0F });
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
          if (b.this.CEb != null) {
            b.this.CEb.onAnimationEnd();
          }
          AppMethodBeat.o(80742);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80741);
          b.this.isAnimating = true;
          if (b.this.CEb != null) {
            b.this.CEb.onAnimationStart();
          }
          AppMethodBeat.o(80741);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80749);
      return;
      localValueAnimator.addUpdateListener(this.CEf);
    }
  }
  
  protected final void eFn()
  {
    AppMethodBeat.i(80751);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.CDY[0][0] - this.CDO >= 0.0F) {
      localValueAnimator.addUpdateListener(this.CEc);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.CDX, "alpha", new float[] { 1.0F, 0.0F });
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
          if (b.this.CEb != null) {
            b.this.CEb.onAnimationEnd();
          }
          AppMethodBeat.o(80745);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80744);
          b.this.isAnimating = true;
          if (b.this.CEb != null) {
            b.this.CEb.onAnimationStart();
          }
          AppMethodBeat.o(80744);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80751);
      return;
      localValueAnimator.addUpdateListener(this.CEd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b
 * JD-Core Version:    0.7.0.1
 */