package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class d
  extends b
{
  protected final WeakReference<ViewPropertyAnimator> OMC;
  protected boolean OMD;
  Animator.AnimatorListener OMr;
  Interpolator mInterpolator;
  
  d(View paramView)
  {
    AppMethodBeat.i(205184);
    this.OMC = new WeakReference(paramView.animate());
    AppMethodBeat.o(205184);
  }
  
  public final b aJ(Runnable paramRunnable)
  {
    AppMethodBeat.i(205192);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withEndAction(paramRunnable);
    }
    AppMethodBeat.o(205192);
    return this;
  }
  
  public final b aK(Runnable paramRunnable)
  {
    AppMethodBeat.i(205193);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withStartAction(paramRunnable);
    }
    AppMethodBeat.o(205193);
    return this;
  }
  
  public final b c(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(205186);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.setInterpolator(paramInterpolator);
      this.mInterpolator = paramInterpolator;
    }
    AppMethodBeat.o(205186);
    return this;
  }
  
  public final b cn(float paramFloat)
  {
    AppMethodBeat.i(205188);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationX(paramFloat);
    }
    AppMethodBeat.o(205188);
    return this;
  }
  
  public final b co(float paramFloat)
  {
    AppMethodBeat.i(205189);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationY(paramFloat);
    }
    AppMethodBeat.o(205189);
    return this;
  }
  
  public final b cp(float paramFloat)
  {
    AppMethodBeat.i(205190);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleX(paramFloat);
    }
    AppMethodBeat.o(205190);
    return this;
  }
  
  public final b cq(float paramFloat)
  {
    AppMethodBeat.i(205191);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleY(paramFloat);
    }
    AppMethodBeat.o(205191);
    return this;
  }
  
  public final b gKg()
  {
    AppMethodBeat.i(205185);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setDuration(250L);
    }
    AppMethodBeat.o(205185);
    return this;
  }
  
  public void start()
  {
    AppMethodBeat.i(205187);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator1 = (ViewPropertyAnimator)this.OMC.get();
    if (this.OMl != null)
    {
      this.OMj.put(localValueAnimator, this.OMl);
      this.OMl = null;
    }
    if (this.OMm != null)
    {
      this.OMk.put(localValueAnimator, this.OMm);
      this.OMm = null;
    }
    localViewPropertyAnimator1.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205182);
        if (d.this.OMr != null) {
          d.this.OMr.onAnimationCancel(null);
        }
        d.this.mInterpolator = null;
        if (d.this.OMk != null) {
          d.this.OMk.remove(localValueAnimator);
        }
        AppMethodBeat.o(205182);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205181);
        d.this.OMD = false;
        d.this.mInterpolator = null;
        if (d.this.OMr != null) {
          d.this.OMr.onAnimationEnd(null);
        }
        if (d.this.OMk != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.OMk.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.OMk.remove(localValueAnimator);
        }
        AppMethodBeat.o(205181);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205180);
        if (d.this.OMr != null) {
          d.this.OMr.onAnimationRepeat(null);
        }
        AppMethodBeat.o(205180);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205179);
        if (d.this.OMr != null) {
          d.this.OMr.onAnimationStart(null);
        }
        if (d.this.OMj != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.OMj.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.OMj.remove(localValueAnimator);
        }
        AppMethodBeat.o(205179);
      }
    });
    ViewPropertyAnimator localViewPropertyAnimator2;
    if (localViewPropertyAnimator1 != null)
    {
      if (this.OMD) {
        localViewPropertyAnimator1.withLayer();
      }
      if (this.OMn != null)
      {
        localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localViewPropertyAnimator2 = (ViewPropertyAnimator)this.OMC.get();
        if (localViewPropertyAnimator2 == null) {
          break label221;
        }
      }
    }
    label221:
    for (long l = localViewPropertyAnimator2.getDuration();; l = -1L)
    {
      localValueAnimator.setDuration(l);
      if (this.mInterpolator != null) {
        localValueAnimator.setInterpolator(this.mInterpolator);
      }
      localValueAnimator.setStartDelay(localViewPropertyAnimator1.getStartDelay());
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(205183);
          d.this.OMn.by(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          AppMethodBeat.o(205183);
        }
      });
      localValueAnimator.start();
      localViewPropertyAnimator1.start();
      AppMethodBeat.o(205187);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */