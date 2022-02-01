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
    AppMethodBeat.i(205199);
    if ((ViewPropertyAnimator)this.OMC.get() != null) {
      this.OMn = parama;
    }
    AppMethodBeat.o(205199);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(205200);
    System.currentTimeMillis();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.OMC.get();
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
    localViewPropertyAnimator.setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205197);
        if (e.this.OMr != null) {
          e.this.OMr.onAnimationCancel(null);
        }
        if (e.this.OMk != null) {
          e.this.OMk.remove(localValueAnimator);
        }
        AppMethodBeat.o(205197);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205196);
        e.this.OMD = false;
        if (e.this.OMr != null) {
          e.this.OMr.onAnimationEnd(null);
        }
        if (e.this.OMk != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.OMk.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.OMk.remove(localValueAnimator);
        }
        AppMethodBeat.o(205196);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205195);
        if (e.this.OMr != null) {
          e.this.OMr.onAnimationRepeat(null);
        }
        AppMethodBeat.o(205195);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(205194);
        if (e.this.OMr != null) {
          e.this.OMr.onAnimationStart(null);
        }
        if (e.this.OMj != null)
        {
          paramAnonymousAnimator = (Runnable)e.this.OMj.get(localValueAnimator);
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.run();
          }
          e.this.OMj.remove(localValueAnimator);
        }
        AppMethodBeat.o(205194);
      }
    });
    if (localViewPropertyAnimator != null)
    {
      if (this.OMD) {
        localViewPropertyAnimator.withLayer();
      }
      if (this.OMn != null) {
        localViewPropertyAnimator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(205198);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            e.this.OMn.by(f);
            AppMethodBeat.o(205198);
          }
        });
      }
      localViewPropertyAnimator.start();
    }
    AppMethodBeat.o(205200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */