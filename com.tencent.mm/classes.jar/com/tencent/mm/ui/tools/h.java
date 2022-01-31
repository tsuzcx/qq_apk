package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.compatible.util.d;

public final class h
{
  @TargetApi(14)
  public static final void a(View paramView, long paramLong, float paramFloat1, float paramFloat2)
  {
    if ((paramView == null) || (d.gG(14))) {
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.animate().setListener(null);
    paramView.animate().setDuration(paramLong).translationX(paramFloat1).translationY(0.0F).setInterpolator(new AccelerateInterpolator(paramFloat2));
  }
  
  @TargetApi(14)
  public static final void a(View paramView, long paramLong, float paramFloat, a parama)
  {
    if ((paramView == null) || (d.gG(14))) {
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    if (parama == null)
    {
      paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F);
      return;
    }
    paramView.animate().setDuration(paramLong).translationX(paramFloat).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.wcV.ceX();
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.wcV.onAnimationEnd();
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  @TargetApi(11)
  public static void a(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramView == null) || (d.gG(11))) {
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
  }
  
  @TargetApi(11)
  public static final void p(View paramView, float paramFloat)
  {
    if ((paramView == null) || (d.gG(11))) {
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
  
  @TargetApi(14)
  public static final void q(View paramView, float paramFloat)
  {
    if ((paramView == null) || (d.gG(14))) {
      return;
    }
    Animator localAnimator = (Animator)paramView.getTag(a.g.property_anim);
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    paramView.animate().cancel();
    paramView.setTranslationX(paramFloat);
    paramView.setTranslationY(0.0F);
  }
  
  public static abstract interface a
  {
    public abstract void ceX();
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */