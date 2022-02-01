package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "hideAnimator", "Landroid/animation/Animator;", "isAnimating", "", "()Z", "isAnimatingHide", "isAnimatingShow", "showAnimator", "getTargetView", "()Landroid/view/View;", "setTargetView", "createHideAlphaAnimationSet", "width", "", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "createHideTransAnimationSet", "createShowAnimationSet", "createTranslateAnimationSet", "show", "isDockLeft", "playHideAnimation", "", "withTransAnimation", "withAlphaAnimation", "playHideTranslateAnimation", "playShowAnimation", "playShowTranslateAnimation", "Companion", "HideAnimatorListenerAdapter", "ShowAnimatorListenerAdapter", "plugin-multitask_release"})
public final class b
{
  public static final b.a Aaf;
  public Animator oWg;
  public Animator oWh;
  public View targetView;
  
  static
  {
    AppMethodBeat.i(200419);
    Aaf = new b.a((byte)0);
    AppMethodBeat.o(200419);
  }
  
  public b(View paramView)
  {
    this.targetView = paramView;
  }
  
  private Animator a(int paramInt, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200418);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { 0.0F, -paramInt });
    p.g(localObject, "ObjectAnimator.ofFloat(t…, 0.0f, -width.toFloat())");
    localObject = (Animator)localObject;
    ((Animator)localObject).setDuration(500L);
    ((Animator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localAnimatorSet.playTogether(new Animator[] { localObject });
    localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
    paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
    AppMethodBeat.o(200418);
    return paramAnimatorListenerAdapter;
  }
  
  public final Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200417);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { -paramInt, 0.0F });; localObject = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { paramInt, 0.0F }))
      {
        localObject = (Animator)localObject;
        p.g(localObject, "translationAnimator");
        ((ObjectAnimator)localObject).setDuration(800L);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
        AppMethodBeat.o(200417);
        return paramAnimatorListenerAdapter;
      }
    }
    if (paramBoolean2) {}
    for (Object localObject = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { 0.0F, -paramInt });; localObject = ObjectAnimator.ofFloat(this.targetView, "translationX", new float[] { 0.0F, paramInt }))
    {
      localObject = (Animator)localObject;
      break;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200415);
    if (this.targetView == null)
    {
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200415);
        return;
      }
      AppMethodBeat.o(200415);
      return;
    }
    if (chI())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200415);
        return;
      }
      AppMethodBeat.o(200415);
      return;
    }
    if (chJ())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      Animator localAnimator = this.oWh;
      if (localAnimator != null) {
        localAnimator.cancel();
      }
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.targetView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.oWg = a(true, paramInt, paramBoolean, (AnimatorListenerAdapter)new c(this.targetView, paramAnimatorListenerAdapter));
    paramAnimatorListenerAdapter = this.oWg;
    if (paramAnimatorListenerAdapter != null) {
      paramAnimatorListenerAdapter.start();
    }
    paramAnimatorListenerAdapter = this.targetView;
    if (paramAnimatorListenerAdapter != null) {
      paramAnimatorListenerAdapter.setAlpha(1.0F);
    }
    paramAnimatorListenerAdapter = this.targetView;
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.setVisibility(0);
      AppMethodBeat.o(200415);
      return;
    }
    AppMethodBeat.o(200415);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200416);
    if (this.targetView == null)
    {
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200416);
        return;
      }
      AppMethodBeat.o(200416);
      return;
    }
    if (chJ())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200416);
        return;
      }
      AppMethodBeat.o(200416);
      return;
    }
    Object localObject1;
    if (chI())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      localObject1 = this.oWg;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
    }
    if (paramBoolean1) {
      this.oWh = a(paramInt, (AnimatorListenerAdapter)new b(this.targetView, paramAnimatorListenerAdapter));
    }
    for (;;)
    {
      paramAnimatorListenerAdapter = this.oWh;
      if (paramAnimatorListenerAdapter == null) {
        break;
      }
      paramAnimatorListenerAdapter.start();
      AppMethodBeat.o(200416);
      return;
      if (paramBoolean2)
      {
        paramAnimatorListenerAdapter = (AnimatorListenerAdapter)new b(this.targetView, paramAnimatorListenerAdapter);
        localObject1 = new AnimatorSet();
        Object localObject2 = ObjectAnimator.ofFloat(this.targetView, "alpha", new float[] { 1.0F, 0.0F });
        p.g(localObject2, "ObjectAnimator.ofFloat(t…iew, \"alpha\", 1.0f, 0.0f)");
        localObject2 = (Animator)localObject2;
        ((Animator)localObject2).setDuration(500L);
        ((Animator)localObject2).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
        ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2 });
        ((AnimatorSet)localObject1).addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        this.oWh = ((Animator)localObject1);
      }
      else
      {
        this.oWh = a(paramInt, (AnimatorListenerAdapter)new b(this.targetView, paramAnimatorListenerAdapter));
      }
    }
    AppMethodBeat.o(200416);
  }
  
  public final boolean chI()
  {
    AppMethodBeat.i(200413);
    Animator localAnimator = this.oWg;
    if (localAnimator != null)
    {
      boolean bool = localAnimator.isRunning();
      AppMethodBeat.o(200413);
      return bool;
    }
    AppMethodBeat.o(200413);
    return false;
  }
  
  public final boolean chJ()
  {
    AppMethodBeat.i(200414);
    Animator localAnimator = this.oWh;
    if (localAnimator != null)
    {
      boolean bool = localAnimator.isRunning();
      AppMethodBeat.o(200414);
      return bool;
    }
    AppMethodBeat.o(200414);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$HideAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    private final AnimatorListenerAdapter oWj;
    private final View targetView;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.oWj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(200401);
      p.h(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(200401);
        return;
      }
      AppMethodBeat.o(200401);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200402);
      p.h(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        AppMethodBeat.o(200402);
        return;
      }
      AppMethodBeat.o(200402);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(200405);
      p.h(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
        AppMethodBeat.o(200405);
        return;
      }
      AppMethodBeat.o(200405);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(200403);
      p.h(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(200403);
        return;
      }
      AppMethodBeat.o(200403);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(200406);
      p.h(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
        AppMethodBeat.o(200406);
        return;
      }
      AppMethodBeat.o(200406);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200404);
      p.h(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        AppMethodBeat.o(200404);
        return;
      }
      AppMethodBeat.o(200404);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$ShowAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    private final AnimatorListenerAdapter oWj;
    private final View targetView;
    
    public c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.targetView = paramView;
      this.oWj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(200407);
      p.h(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(200407);
        return;
      }
      AppMethodBeat.o(200407);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200408);
      p.h(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.targetView != null) {
        this.targetView.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        AppMethodBeat.o(200408);
        return;
      }
      AppMethodBeat.o(200408);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(200411);
      p.h(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
        AppMethodBeat.o(200411);
        return;
      }
      AppMethodBeat.o(200411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(200409);
      p.h(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(200409);
        return;
      }
      AppMethodBeat.o(200409);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(200412);
      p.h(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
        AppMethodBeat.o(200412);
        return;
      }
      AppMethodBeat.o(200412);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200410);
      p.h(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.oWj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        AppMethodBeat.o(200410);
        return;
      }
      AppMethodBeat.o(200410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.b
 * JD-Core Version:    0.7.0.1
 */