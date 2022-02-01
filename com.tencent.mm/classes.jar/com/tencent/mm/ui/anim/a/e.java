package com.tencent.mm.ui.anim.a;

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
    AppMethodBeat.i(251239);
    if ((ViewPropertyAnimator)this.adMi.get() != null) {
      this.adLT = parama;
    }
    AppMethodBeat.o(251239);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(251249);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (this.adLR != null)
    {
      this.adLP.put(localValueAnimator, this.adLR);
      this.adLR = null;
    }
    if (this.adLS != null)
    {
      this.adLQ.put(localValueAnimator, this.adLS);
      this.adLS = null;
    }
    localViewPropertyAnimator.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251273);
        if (e.this.adLX != null) {
          e.this.adLX.onAnimationCancel(null);
        }
        if (e.this.adLQ != null) {
          e.this.adLQ.remove(localValueAnimator);
        }
        AppMethodBeat.o(251273);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251268);
        e.this.adMj = false;
        if (e.this.adLX != null) {
          e.this.adLX.onAnimationEnd(null);
        }
        if (e.this.adLQ != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.adLQ.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.adLQ.remove(localValueAnimator);
        }
        if ((e.this.adLQ != null) && (e.this.adLQ.isEmpty())) {
          e.this.adLX = null;
        }
        e.this.adLT = null;
        AppMethodBeat.o(251268);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251262);
        if (e.this.adLX != null) {
          e.this.adLX.onAnimationRepeat(null);
        }
        AppMethodBeat.o(251262);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251254);
        if (e.this.adLX != null) {
          e.this.adLX.onAnimationStart(null);
        }
        if (e.this.adLP != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.adLP.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.adLP.remove(localValueAnimator);
        }
        AppMethodBeat.o(251254);
      }
    });
    if (localViewPropertyAnimator != null)
    {
      if (this.adMj) {
        localViewPropertyAnimator.withLayer();
      }
      if (this.adLT != null) {
        localViewPropertyAnimator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(251251);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (e.this.adLT != null) {
              e.this.adLT.onUpdate(f);
            }
            AppMethodBeat.o(251251);
          }
        });
      }
      localViewPropertyAnimator.start();
    }
    AppMethodBeat.o(251249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.anim.a.e
 * JD-Core Version:    0.7.0.1
 */