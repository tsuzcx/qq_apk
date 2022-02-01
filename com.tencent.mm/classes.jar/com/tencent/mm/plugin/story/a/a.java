package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.support.v4.view.u;
import android.view.View;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  public static final a.a Fks = new a.a((byte)0);
  private static final long lZa = 1000L;
  public AnimatorSet Fkp = new AnimatorSet();
  public int Fkq;
  public int Fkr = 1;
  public long mDuration = lZa;
  
  protected abstract void fN(View paramView);
  
  public final a fO(View paramView)
  {
    p.h(paramView, "target");
    p.h(paramView, "target");
    u.g(paramView, 1.0F);
    u.h(paramView, 1.0F);
    u.i(paramView, 1.0F);
    u.e(paramView, 0.0F);
    u.f(paramView, 0.0F);
    u.ai(paramView);
    u.ak(paramView);
    u.aj(paramView);
    fN(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */