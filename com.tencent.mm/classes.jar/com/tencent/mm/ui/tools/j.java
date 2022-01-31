package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
{
  @TargetApi(14)
  public static final void a(View paramView, long paramLong, float paramFloat, a parama)
  {
    AppMethodBeat.i(107654);
    if ((paramView == null) || (d.fw(14)))
    {
      AppMethodBeat.o(107654);
      return;
    }
    Object localObject = (Animator)paramView.getTag(2131820653);
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    ab.i("Changelcai", "[animTran] duration:%s x:%s", new Object[] { Long.valueOf(paramLong), Float.valueOf(paramFloat) });
    paramView.animate().cancel();
    paramView.animate().setListener(null);
    localObject = AnimationUtils.loadInterpolator(paramView.getContext(), 2131034200);
    if (parama == null)
    {
      paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
      AppMethodBeat.o(107654);
      return;
    }
    paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107651);
        this.AvC.dfe();
        AppMethodBeat.o(107651);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107650);
        this.AvC.onAnimationEnd();
        AppMethodBeat.o(107650);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(107654);
  }
  
  @TargetApi(11)
  public static void a(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(107655);
    if ((paramView == null) || (d.fw(11)))
    {
      AppMethodBeat.o(107655);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(2131820653);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = AnimatorInflater.loadAnimator(paramView.getContext(), 2131099650);
    localAnimator.setTarget(paramView);
    if (paramAnimatorListener != null) {
      localAnimator.addListener(paramAnimatorListener);
    }
    localAnimator.start();
    paramView.setTag(2131820653, localAnimator);
    AppMethodBeat.o(107655);
  }
  
  @TargetApi(11)
  public static final void s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(107652);
    if ((paramView == null) || (d.fw(11)))
    {
      AppMethodBeat.o(107652);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(2131820653);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
    AppMethodBeat.o(107652);
  }
  
  @TargetApi(14)
  public static final void t(View paramView, float paramFloat)
  {
    AppMethodBeat.i(107653);
    if ((paramView == null) || (d.fw(14)))
    {
      AppMethodBeat.o(107653);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(2131820653);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.setTranslationX(paramFloat);
    paramView.setTranslationY(0.0F);
    AppMethodBeat.o(107653);
  }
  
  public static abstract interface a
  {
    public abstract void dfe();
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */