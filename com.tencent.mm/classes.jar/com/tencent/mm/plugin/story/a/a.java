package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.support.v4.view.t;
import android.view.View;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  public static final a.a AZu = new a.a((byte)0);
  private static final long kTU = 1000L;
  public AnimatorSet AZr = new AnimatorSet();
  public int AZs;
  public int AZt = 1;
  public long mDuration = kTU;
  
  protected abstract void fw(View paramView);
  
  public final a fx(View paramView)
  {
    p.h(paramView, "target");
    p.h(paramView, "target");
    t.f(paramView, 1.0F);
    t.g(paramView, 1.0F);
    t.h(paramView, 1.0F);
    t.ah(paramView);
    t.e(paramView, 0.0F);
    t.ai(paramView);
    t.ak(paramView);
    t.aj(paramView);
    fw(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */