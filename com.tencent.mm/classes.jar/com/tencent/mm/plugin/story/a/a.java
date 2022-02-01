package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.support.v4.view.t;
import android.view.View;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  private static final long kuJ = 1000L;
  public static final a.a zpX = new a.a((byte)0);
  public long mDuration = kuJ;
  public AnimatorSet zpU = new AnimatorSet();
  public int zpV;
  public int zpW = 1;
  
  protected abstract void fj(View paramView);
  
  public final a fk(View paramView)
  {
    k.h(paramView, "target");
    k.h(paramView, "target");
    t.f(paramView, 1.0F);
    t.g(paramView, 1.0F);
    t.h(paramView, 1.0F);
    t.ah(paramView);
    t.e(paramView, 0.0F);
    t.ai(paramView);
    t.ak(paramView);
    t.aj(paramView);
    fj(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */