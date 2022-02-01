package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class e
  extends d
{
  e(View paramView)
  {
    super(paramView);
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(198989);
    if ((ViewPropertyAnimator)this.Wgb.get() != null) {
      this.WfM = parama;
    }
    AppMethodBeat.o(198989);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(198992);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (this.WfK != null)
    {
      this.WfI.put(localValueAnimator, this.WfK);
      this.WfK = null;
    }
    if (this.WfL != null)
    {
      this.WfJ.put(localValueAnimator, this.WfL);
      this.WfL = null;
    }
    localViewPropertyAnimator.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203608);
        if (e.this.WfQ != null) {
          e.this.WfQ.onAnimationCancel(null);
        }
        if (e.this.WfJ != null) {
          e.this.WfJ.remove(localValueAnimator);
        }
        AppMethodBeat.o(203608);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203607);
        e.this.Wgc = false;
        if (e.this.WfQ != null) {
          e.this.WfQ.onAnimationEnd(null);
        }
        if (e.this.WfJ != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.WfJ.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.WfJ.remove(localValueAnimator);
        }
        if ((e.this.WfJ != null) && (e.this.WfJ.isEmpty())) {
          e.this.WfQ = null;
        }
        e.this.WfM = null;
        AppMethodBeat.o(203607);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203606);
        if (e.this.WfQ != null) {
          e.this.WfQ.onAnimationRepeat(null);
        }
        AppMethodBeat.o(203606);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203605);
        if (e.this.WfQ != null) {
          e.this.WfQ.onAnimationStart(null);
        }
        if (e.this.WfI != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.WfI.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.WfI.remove(localValueAnimator);
        }
        AppMethodBeat.o(203605);
      }
    });
    if (localViewPropertyAnimator != null)
    {
      if (this.Wgc) {
        localViewPropertyAnimator.withLayer();
      }
      if (this.WfM != null) {
        localViewPropertyAnimator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(191047);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (e.this.WfM != null) {
              e.this.WfM.bB(f);
            }
            AppMethodBeat.o(191047);
          }
        });
      }
      localViewPropertyAnimator.start();
    }
    AppMethodBeat.o(198992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */