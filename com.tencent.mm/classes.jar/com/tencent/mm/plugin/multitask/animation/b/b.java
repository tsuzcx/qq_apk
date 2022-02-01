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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "hideAnimator", "Landroid/animation/Animator;", "isAnimating", "", "()Z", "isAnimatingHide", "isAnimatingShow", "showAnimator", "getTargetView", "()Landroid/view/View;", "setTargetView", "createHideAlphaAnimationSet", "width", "", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "createHideTransAnimationSet", "createShowAnimationSet", "createTranslateAnimationSet", "show", "isDockLeft", "playHideAnimation", "", "withTransAnimation", "withAlphaAnimation", "playHideTranslateAnimation", "playShowAnimation", "playShowTranslateAnimation", "Companion", "HideAnimatorListenerAdapter", "ShowAnimatorListenerAdapter", "plugin-multitask_release"})
public final class b
{
  public static final b.a FFV;
  public View kJL;
  public Animator rYg;
  public Animator rYh;
  
  static
  {
    AppMethodBeat.i(247944);
    FFV = new b.a((byte)0);
    AppMethodBeat.o(247944);
  }
  
  public b(View paramView)
  {
    this.kJL = paramView;
  }
  
  private Animator a(int paramInt, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247942);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { 0.0F, -paramInt });
    p.j(localObject, "ObjectAnimator.ofFloat(t…, 0.0f, -width.toFloat())");
    localObject = (Animator)localObject;
    ((Animator)localObject).setDuration(500L);
    ((Animator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localAnimatorSet.playTogether(new Animator[] { localObject });
    localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
    paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
    AppMethodBeat.o(247942);
    return paramAnimatorListenerAdapter;
  }
  
  public final Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247940);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { -paramInt, 0.0F });; localObject = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { paramInt, 0.0F }))
      {
        localObject = (Animator)localObject;
        p.j(localObject, "translationAnimator");
        ((ObjectAnimator)localObject).setDuration(800L);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
        AppMethodBeat.o(247940);
        return paramAnimatorListenerAdapter;
      }
    }
    if (paramBoolean2) {}
    for (Object localObject = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { 0.0F, -paramInt });; localObject = ObjectAnimator.ofFloat(this.kJL, "translationX", new float[] { 0.0F, paramInt }))
    {
      localObject = (Animator)localObject;
      break;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247936);
    if (this.kJL == null)
    {
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247936);
        return;
      }
      AppMethodBeat.o(247936);
      return;
    }
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247936);
        return;
      }
      AppMethodBeat.o(247936);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
      Animator localAnimator = this.rYh;
      if (localAnimator != null) {
        localAnimator.cancel();
      }
    }
    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { this.kJL, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.rYg = a(true, paramInt, paramBoolean, (AnimatorListenerAdapter)new c(this.kJL, paramAnimatorListenerAdapter));
    paramAnimatorListenerAdapter = this.rYg;
    if (paramAnimatorListenerAdapter != null) {
      paramAnimatorListenerAdapter.start();
    }
    paramAnimatorListenerAdapter = this.kJL;
    if (paramAnimatorListenerAdapter != null) {
      paramAnimatorListenerAdapter.setAlpha(1.0F);
    }
    paramAnimatorListenerAdapter = this.kJL;
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.setVisibility(0);
      AppMethodBeat.o(247936);
      return;
    }
    AppMethodBeat.o(247936);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247939);
    if (this.kJL == null)
    {
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247939);
        return;
      }
      AppMethodBeat.o(247939);
      return;
    }
    if (cuU())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247939);
        return;
      }
      AppMethodBeat.o(247939);
      return;
    }
    Object localObject1;
    if (cuT())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      localObject1 = this.rYg;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
    }
    if (paramBoolean1) {
      this.rYh = a(paramInt, (AnimatorListenerAdapter)new b(this.kJL, paramAnimatorListenerAdapter));
    }
    for (;;)
    {
      paramAnimatorListenerAdapter = this.rYh;
      if (paramAnimatorListenerAdapter == null) {
        break;
      }
      paramAnimatorListenerAdapter.start();
      AppMethodBeat.o(247939);
      return;
      if (paramBoolean2)
      {
        paramAnimatorListenerAdapter = (AnimatorListenerAdapter)new b(this.kJL, paramAnimatorListenerAdapter);
        localObject1 = new AnimatorSet();
        Object localObject2 = ObjectAnimator.ofFloat(this.kJL, "alpha", new float[] { 1.0F, 0.0F });
        p.j(localObject2, "ObjectAnimator.ofFloat(t…iew, \"alpha\", 1.0f, 0.0f)");
        localObject2 = (Animator)localObject2;
        ((Animator)localObject2).setDuration(500L);
        ((Animator)localObject2).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
        ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2 });
        ((AnimatorSet)localObject1).addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        this.rYh = ((Animator)localObject1);
      }
      else
      {
        this.rYh = a(paramInt, (AnimatorListenerAdapter)new b(this.kJL, paramAnimatorListenerAdapter));
      }
    }
    AppMethodBeat.o(247939);
  }
  
  public final boolean cuT()
  {
    AppMethodBeat.i(247930);
    Animator localAnimator = this.rYg;
    if (localAnimator != null)
    {
      boolean bool = localAnimator.isRunning();
      AppMethodBeat.o(247930);
      return bool;
    }
    AppMethodBeat.o(247930);
    return false;
  }
  
  public final boolean cuU()
  {
    AppMethodBeat.i(247932);
    Animator localAnimator = this.rYh;
    if (localAnimator != null)
    {
      boolean bool = localAnimator.isRunning();
      AppMethodBeat.o(247932);
      return bool;
    }
    AppMethodBeat.o(247932);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$HideAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    private final View kJL;
    private final AnimatorListenerAdapter rYj;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.kJL = paramView;
      this.rYj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(248697);
      p.k(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(248697);
        return;
      }
      AppMethodBeat.o(248697);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(248699);
      p.k(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        AppMethodBeat.o(248699);
        return;
      }
      AppMethodBeat.o(248699);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(248705);
      p.k(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
        AppMethodBeat.o(248705);
        return;
      }
      AppMethodBeat.o(248705);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(248701);
      p.k(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(248701);
        return;
      }
      AppMethodBeat.o(248701);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(248707);
      p.k(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
        AppMethodBeat.o(248707);
        return;
      }
      AppMethodBeat.o(248707);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(248702);
      p.k(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        AppMethodBeat.o(248702);
        return;
      }
      AppMethodBeat.o(248702);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$ShowAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    private final View kJL;
    private final AnimatorListenerAdapter rYj;
    
    public c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.kJL = paramView;
      this.rYj = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(248364);
      p.k(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(248364);
        return;
      }
      AppMethodBeat.o(248364);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(248365);
      p.k(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.kJL != null) {
        this.kJL.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        AppMethodBeat.o(248365);
        return;
      }
      AppMethodBeat.o(248365);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(248368);
      p.k(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
        AppMethodBeat.o(248368);
        return;
      }
      AppMethodBeat.o(248368);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(248366);
      p.k(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(248366);
        return;
      }
      AppMethodBeat.o(248366);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(248369);
      p.k(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
        AppMethodBeat.o(248369);
        return;
      }
      AppMethodBeat.o(248369);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(248367);
      p.k(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.rYj;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        AppMethodBeat.o(248367);
        return;
      }
      AppMethodBeat.o(248367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.b
 * JD-Core Version:    0.7.0.1
 */