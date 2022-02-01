package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
{
  public static final void E(View paramView, float paramFloat)
  {
    AppMethodBeat.i(143107);
    if ((paramView == null) || (d.rc(11)))
    {
      AppMethodBeat.o(143107);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
    AppMethodBeat.o(143107);
  }
  
  public static final void a(View paramView, long paramLong, float paramFloat, a parama)
  {
    AppMethodBeat.i(143109);
    if ((paramView == null) || (d.rc(14)))
    {
      AppMethodBeat.o(143109);
      return;
    }
    Object localObject = (Animator)paramView.getTag(a.g.property_anim);
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    Log.i("Changelcai", "[animTran] duration:%s x:%s", new Object[] { Long.valueOf(paramLong), Float.valueOf(paramFloat) });
    paramView.animate().cancel();
    paramView.animate().setListener(null);
    localObject = AnimationUtils.loadInterpolator(paramView.getContext(), a.a.mm_decelerate_interpolator);
    if (parama == null)
    {
      paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
      AppMethodBeat.o(143109);
      return;
    }
    paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251114);
        k.this.aXe();
        AppMethodBeat.o(251114);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(251111);
        k.this.onAnimationEnd();
        AppMethodBeat.o(251111);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(143109);
  }
  
  public static void a(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(143110);
    if ((paramView == null) || (d.rc(11)))
    {
      AppMethodBeat.o(143110);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = AnimatorInflater.loadAnimator(paramView.getContext(), a.b.fade_in_property_anim);
    localAnimator.setTarget(paramView);
    if (paramAnimatorListener != null) {
      localAnimator.addListener(paramAnimatorListener);
    }
    localAnimator.start();
    paramView.setTag(a.g.property_anim, localAnimator);
    AppMethodBeat.o(143110);
  }
  
  public static final void r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(143108);
    if ((paramView == null) || (d.rc(14)))
    {
      AppMethodBeat.o(143108);
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.setTranslationX(paramFloat);
    paramView.setTranslationY(0.0F);
    AppMethodBeat.o(143108);
  }
  
  public static abstract interface a
  {
    public abstract void aXe();
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */