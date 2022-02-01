package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.view.View;
import androidx.core.g.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  public static final a LEu = new a((byte)0);
  private static final long oWT = 1000L;
  public AnimatorSet LEr = new AnimatorSet();
  public int LEs;
  public int LEt = 1;
  public long mDuration = oWT;
  
  protected abstract void gU(View paramView);
  
  public final a gV(View paramView)
  {
    p.k(paramView, "target");
    p.k(paramView, "target");
    w.e(paramView, 1.0F);
    w.f(paramView, 1.0F);
    w.g(paramView, 1.0F);
    w.c(paramView, 0.0F);
    w.d(paramView, 0.0F);
    w.R(paramView);
    w.T(paramView);
    w.S(paramView);
    gU(paramView);
    return this;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator$Companion;", "", "()V", "DURATION", "", "getDURATION", "()J", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */