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
  
  private void eUk()
  {
    AppMethodBeat.i(80750);
    this.EhC.setPadding(this.EhB, 0, 0, 0);
    int i = this.wfJ;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.EhC.getLayoutParams();
    localLayoutParams.leftMargin = (this.wfJ - i);
    localLayoutParams.rightMargin = (this.wfJ - i);
    localLayoutParams.width = (i * 2 + (int)this.EhJ[2][0]);
    this.EhC.setLayoutParams(localLayoutParams);
    this.EhC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80743);
        b.this.EhC.setY(b.this.EhJ[0][1]);
        b.this.EhC.setX(b.this.EhJ[1][1]);
        AppMethodBeat.o(80743);
      }
    });
    AppMethodBeat.o(80750);
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(80748);
    if (paramb == this.EhL)
    {
      AppMethodBeat.o(80748);
      return;
    }
    switch (4.EhV[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80748);
      return;
      eUi();
      AppMethodBeat.o(80748);
      return;
      if (paramBoolean)
      {
        eUj();
        AppMethodBeat.o(80748);
        return;
      }
      eUk();
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(80747);
    a(paramb, true);
    AppMethodBeat.o(80747);
  }
  
  protected final void eUi()
  {
    AppMethodBeat.i(80749);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.EhJ[0][0] - this.Ehz >= 0.0F) {
      localValueAnimator.addUpdateListener(this.EhP);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.EhI, "alpha", new float[] { 0.0F, 1.0F });
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
          if (b.this.EhM != null) {
            b.this.EhM.onAnimationEnd();
          }
          AppMethodBeat.o(80742);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80741);
          b.this.isAnimating = true;
          if (b.this.EhM != null) {
            b.this.EhM.onAnimationStart();
          }
          AppMethodBeat.o(80741);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80749);
      return;
      localValueAnimator.addUpdateListener(this.EhQ);
    }
  }
  
  protected final void eUj()
  {
    AppMethodBeat.i(80751);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.EhJ[0][0] - this.Ehz >= 0.0F) {
      localValueAnimator.addUpdateListener(this.EhN);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.EhI, "alpha", new float[] { 1.0F, 0.0F });
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
          if (b.this.EhM != null) {
            b.this.EhM.onAnimationEnd();
          }
          AppMethodBeat.o(80745);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80744);
          b.this.isAnimating = true;
          if (b.this.EhM != null) {
            b.this.EhM.onAnimationStart();
          }
          AppMethodBeat.o(80744);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80751);
      return;
      localValueAnimator.addUpdateListener(this.EhO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b
 * JD-Core Version:    0.7.0.1
 */