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
  Animator.AnimatorListener WfQ;
  protected final WeakReference<ViewPropertyAnimator> Wgb;
  protected boolean Wgc;
  Interpolator mInterpolator;
  
  d(View paramView)
  {
    AppMethodBeat.i(189090);
    this.Wgb = new WeakReference(paramView.animate());
    AppMethodBeat.o(189090);
  }
  
  public final b Vw(long paramLong)
  {
    AppMethodBeat.i(189095);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setDuration(paramLong);
    }
    AppMethodBeat.o(189095);
    return this;
  }
  
  public final b aP(Runnable paramRunnable)
  {
    AppMethodBeat.i(189118);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withEndAction(paramRunnable);
    }
    AppMethodBeat.o(189118);
    return this;
  }
  
  public final b aQ(Runnable paramRunnable)
  {
    AppMethodBeat.i(189121);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withStartAction(paramRunnable);
    }
    AppMethodBeat.o(189121);
    return this;
  }
  
  public final b c(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(189100);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.setInterpolator(paramInterpolator);
      this.mInterpolator = paramInterpolator;
    }
    AppMethodBeat.o(189100);
    return this;
  }
  
  public final b cE(float paramFloat)
  {
    AppMethodBeat.i(189105);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.rotation(paramFloat);
    }
    AppMethodBeat.o(189105);
    return this;
  }
  
  public final b cF(float paramFloat)
  {
    AppMethodBeat.i(189107);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationX(paramFloat);
    }
    AppMethodBeat.o(189107);
    return this;
  }
  
  public final b cG(float paramFloat)
  {
    AppMethodBeat.i(189110);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationY(paramFloat);
    }
    AppMethodBeat.o(189110);
    return this;
  }
  
  public final b cH(float paramFloat)
  {
    AppMethodBeat.i(189114);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleX(paramFloat);
    }
    AppMethodBeat.o(189114);
    return this;
  }
  
  public final b cI(float paramFloat)
  {
    AppMethodBeat.i(189116);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.Wgb.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleY(paramFloat);
    }
    AppMethodBeat.o(189116);
    return this;
  }
  
  public void start()
  {
    AppMethodBeat.i(189103);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator1 = (ViewPropertyAnimator)this.Wgb.get();
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
    localViewPropertyAnimator1.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200681);
        if (d.this.WfQ != null) {
          d.this.WfQ.onAnimationCancel(null);
        }
        d.this.mInterpolator = null;
        if (d.this.WfJ != null) {
          d.this.WfJ.remove(localValueAnimator);
        }
        AppMethodBeat.o(200681);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200680);
        d.this.Wgc = false;
        d.this.mInterpolator = null;
        if (d.this.WfQ != null) {
          d.this.WfQ.onAnimationEnd(null);
        }
        if (d.this.WfJ != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.WfJ.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.WfJ.remove(localValueAnimator);
        }
        AppMethodBeat.o(200680);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200677);
        if (d.this.WfQ != null) {
          d.this.WfQ.onAnimationRepeat(null);
        }
        AppMethodBeat.o(200677);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200675);
        if (d.this.WfQ != null) {
          d.this.WfQ.onAnimationStart(null);
        }
        if (d.this.WfI != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.WfI.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.WfI.remove(localValueAnimator);
        }
        AppMethodBeat.o(200675);
      }
    });
    ViewPropertyAnimator localViewPropertyAnimator2;
    if (localViewPropertyAnimator1 != null)
    {
      if (this.Wgc) {
        localViewPropertyAnimator1.withLayer();
      }
      if (this.WfM != null)
      {
        localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localViewPropertyAnimator2 = (ViewPropertyAnimator)this.Wgb.get();
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
          AppMethodBeat.i(203018);
          d.this.WfM.bB(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          AppMethodBeat.o(203018);
        }
      });
      localValueAnimator.start();
      localViewPropertyAnimator1.start();
      AppMethodBeat.o(189103);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */