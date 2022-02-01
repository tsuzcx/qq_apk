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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "hideAnimator", "Landroid/animation/Animator;", "isAnimating", "", "()Z", "isAnimatingHide", "isAnimatingShow", "showAnimator", "getTargetView", "()Landroid/view/View;", "setTargetView", "createHideAlphaAnimationSet", "width", "", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "createHideTransAnimationSet", "createShowAnimationSet", "createTranslateAnimationSet", "show", "isDockLeft", "playHideAnimation", "", "withTransAnimation", "withAlphaAnimation", "playHideTranslateAnimation", "playShowAnimation", "playShowTranslateAnimation", "Companion", "HideAnimatorListenerAdapter", "ShowAnimatorListenerAdapter", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a LBP;
  public View nmf;
  public Animator vjw;
  public Animator vjx;
  
  static
  {
    AppMethodBeat.i(303935);
    LBP = new b.a((byte)0);
    AppMethodBeat.o(303935);
  }
  
  public b(View paramView)
  {
    this.nmf = paramView;
  }
  
  private Animator a(int paramInt, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(303931);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { 0.0F, -paramInt });
    s.s(localObject, "ofFloat(targetView, \"tra…, 0.0f, -width.toFloat())");
    localObject = (Animator)localObject;
    ((Animator)localObject).setDuration(500L);
    ((Animator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localAnimatorSet.playTogether(new Animator[] { localObject });
    localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
    paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
    AppMethodBeat.o(303931);
    return paramAnimatorListenerAdapter;
  }
  
  public final Animator a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(303970);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { -paramInt, 0.0F });; localObject = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { paramInt, 0.0F }))
      {
        localObject = (Animator)localObject;
        ((ObjectAnimator)localObject).setDuration(800L);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        localAnimatorSet.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        paramAnimatorListenerAdapter = (Animator)localAnimatorSet;
        AppMethodBeat.o(303970);
        return paramAnimatorListenerAdapter;
      }
    }
    if (paramBoolean2) {}
    for (Object localObject = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { 0.0F, -paramInt });; localObject = ObjectAnimator.ofFloat(this.nmf, "translationX", new float[] { 0.0F, paramInt }))
    {
      localObject = (Animator)localObject;
      break;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(303962);
    if (this.nmf == null)
    {
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      AppMethodBeat.o(303962);
      return;
    }
    if (cXE())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      AppMethodBeat.o(303962);
      return;
    }
    Object localObject1;
    if (cXD())
    {
      Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      localObject1 = this.vjw;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
    }
    if (paramBoolean1) {
      this.vjx = a(paramInt, (AnimatorListenerAdapter)new b(this.nmf, paramAnimatorListenerAdapter));
    }
    for (;;)
    {
      paramAnimatorListenerAdapter = this.vjx;
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.start();
      }
      AppMethodBeat.o(303962);
      return;
      if (paramBoolean2)
      {
        paramAnimatorListenerAdapter = (AnimatorListenerAdapter)new b(this.nmf, paramAnimatorListenerAdapter);
        localObject1 = new AnimatorSet();
        Object localObject2 = ObjectAnimator.ofFloat(this.nmf, "alpha", new float[] { 1.0F, 0.0F });
        s.s(localObject2, "ofFloat(targetView, \"alpha\", 1.0f, 0.0f)");
        localObject2 = (Animator)localObject2;
        ((Animator)localObject2).setDuration(500L);
        ((Animator)localObject2).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
        ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2 });
        ((AnimatorSet)localObject1).addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter);
        this.vjx = ((Animator)localObject1);
      }
      else
      {
        this.vjx = a(paramInt, (AnimatorListenerAdapter)new b(this.nmf, paramAnimatorListenerAdapter));
      }
    }
  }
  
  public final boolean cXD()
  {
    AppMethodBeat.i(303944);
    Animator localAnimator = this.vjw;
    if (localAnimator == null)
    {
      AppMethodBeat.o(303944);
      return false;
    }
    boolean bool = localAnimator.isRunning();
    AppMethodBeat.o(303944);
    return bool;
  }
  
  public final boolean cXE()
  {
    AppMethodBeat.i(303950);
    Animator localAnimator = this.vjx;
    if (localAnimator == null)
    {
      AppMethodBeat.o(303950);
      return false;
    }
    boolean bool = localAnimator.isRunning();
    AppMethodBeat.o(303950);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$HideAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    private final View nmf;
    private final AnimatorListenerAdapter vjz;
    
    public b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.nmf = paramView;
      this.vjz = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(303968);
      s.u(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
      }
      AppMethodBeat.o(303968);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(303975);
      s.u(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(8);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(303975);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(303993);
      s.u(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(303993);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(303978);
      s.u(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(303978);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(303996);
      s.u(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(303996);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(303984);
      s.u(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(303984);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$ShowAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    private final View nmf;
    private final AnimatorListenerAdapter vjz;
    
    public c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
    {
      this.nmf = paramView;
      this.vjz = paramAnimatorListenerAdapter;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(303925);
      s.u(paramAnimator, "animation");
      super.onAnimationCancel(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
      }
      AppMethodBeat.o(303925);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(303933);
      s.u(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      if (this.nmf != null) {
        this.nmf.setVisibility(0);
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(303933);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(303955);
      s.u(paramAnimator, "animation");
      super.onAnimationPause(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
      }
      AppMethodBeat.o(303955);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(303941);
      s.u(paramAnimator, "animation");
      super.onAnimationRepeat(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(303941);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(303960);
      s.u(paramAnimator, "animation");
      super.onAnimationResume(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
      }
      AppMethodBeat.o(303960);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(303948);
      s.u(paramAnimator, "animation");
      super.onAnimationStart(paramAnimator);
      AnimatorListenerAdapter localAnimatorListenerAdapter = this.vjz;
      if (localAnimatorListenerAdapter != null) {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(303948);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.b
 * JD-Core Version:    0.7.0.1
 */