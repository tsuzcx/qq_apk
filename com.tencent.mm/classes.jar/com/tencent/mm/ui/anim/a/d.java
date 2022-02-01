package com.tencent.mm.ui.anim.a;

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
  Animator.AnimatorListener adLX;
  protected final WeakReference<ViewPropertyAnimator> adMi;
  protected boolean adMj;
  Interpolator mInterpolator;
  
  d(View paramView)
  {
    AppMethodBeat.i(251236);
    this.adMi = new WeakReference(paramView.animate());
    AppMethodBeat.o(251236);
  }
  
  public final b aX(Runnable paramRunnable)
  {
    AppMethodBeat.i(251289);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withEndAction(paramRunnable);
    }
    AppMethodBeat.o(251289);
    return this;
  }
  
  public final b aY(Runnable paramRunnable)
  {
    AppMethodBeat.i(251293);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.withStartAction(paramRunnable);
    }
    AppMethodBeat.o(251293);
    return this;
  }
  
  public final b d(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(251248);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.setInterpolator(paramInterpolator);
      this.mInterpolator = paramInterpolator;
    }
    AppMethodBeat.o(251248);
    return this;
  }
  
  public final b dR(float paramFloat)
  {
    AppMethodBeat.i(251270);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.rotation(paramFloat);
    }
    AppMethodBeat.o(251270);
    return this;
  }
  
  public final b dS(float paramFloat)
  {
    AppMethodBeat.i(251274);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationX(paramFloat);
    }
    AppMethodBeat.o(251274);
    return this;
  }
  
  public final b dT(float paramFloat)
  {
    AppMethodBeat.i(251278);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationY(paramFloat);
    }
    AppMethodBeat.o(251278);
    return this;
  }
  
  public final b dU(float paramFloat)
  {
    AppMethodBeat.i(251281);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleX(paramFloat);
    }
    AppMethodBeat.o(251281);
    return this;
  }
  
  public final b dV(float paramFloat)
  {
    AppMethodBeat.i(251285);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleY(paramFloat);
    }
    AppMethodBeat.o(251285);
    return this;
  }
  
  public void start()
  {
    AppMethodBeat.i(251265);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator1 = (ViewPropertyAnimator)this.adMi.get();
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
    localViewPropertyAnimator1.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251272);
        if (d.this.adLX != null) {
          d.this.adLX.onAnimationCancel(null);
        }
        d.this.mInterpolator = null;
        if (d.this.adLQ != null) {
          d.this.adLQ.remove(localValueAnimator);
        }
        AppMethodBeat.o(251272);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251267);
        d.this.adMj = false;
        d.this.mInterpolator = null;
        if (d.this.adLX != null) {
          d.this.adLX.onAnimationEnd(null);
        }
        if (d.this.adLQ != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.adLQ.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.adLQ.remove(localValueAnimator);
        }
        AppMethodBeat.o(251267);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251258);
        if (d.this.adLX != null) {
          d.this.adLX.onAnimationRepeat(null);
        }
        AppMethodBeat.o(251258);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251250);
        if (d.this.adLX != null) {
          d.this.adLX.onAnimationStart(null);
        }
        if (d.this.adLP != null)
        {
          paramAnonymousAnimator = (Runnable)d.this.adLP.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          d.this.adLP.remove(localValueAnimator);
        }
        AppMethodBeat.o(251250);
      }
    });
    ViewPropertyAnimator localViewPropertyAnimator2;
    if (localViewPropertyAnimator1 != null)
    {
      if (this.adMj) {
        localViewPropertyAnimator1.withLayer();
      }
      if (this.adLT != null)
      {
        localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localViewPropertyAnimator2 = (ViewPropertyAnimator)this.adMi.get();
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
          AppMethodBeat.i(251247);
          d.this.adLT.onUpdate(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          AppMethodBeat.o(251247);
        }
      });
      localValueAnimator.start();
      localViewPropertyAnimator1.start();
      AppMethodBeat.o(251265);
      return;
    }
  }
  
  public final b zE(long paramLong)
  {
    AppMethodBeat.i(251242);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.adMi.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setDuration(paramLong);
    }
    AppMethodBeat.o(251242);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.anim.a.d
 * JD-Core Version:    0.7.0.1
 */