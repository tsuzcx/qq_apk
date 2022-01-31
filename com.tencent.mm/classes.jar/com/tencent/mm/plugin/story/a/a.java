package com.tencent.mm.plugin.story.a;

import a.f.b.j;
import a.l;
import android.animation.AnimatorSet;
import android.support.v4.view.t;
import android.view.View;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "setAnimatorAgent", "(Landroid/animation/AnimatorSet;)V", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  private static final long sqJ = 1000L;
  public static final a.a sqK = new a.a((byte)0);
  public long mDuration = sqJ;
  public AnimatorSet sqG = new AnimatorSet();
  public int sqH;
  public int sqI = 1;
  
  protected abstract void ee(View paramView);
  
  public final a ef(View paramView)
  {
    j.q(paramView, "target");
    j.q(paramView, "target");
    t.f(paramView, 1.0F);
    t.g(paramView, 1.0F);
    t.h(paramView, 1.0F);
    t.ac(paramView);
    t.e(paramView, 0.0F);
    t.ad(paramView);
    t.af(paramView);
    t.ae(paramView);
    ee(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */