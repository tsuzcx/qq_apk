package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.support.v4.view.t;
import android.view.View;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a
{
  private static final long jTY = 1000L;
  public static final a ycX = new a((byte)0);
  public long mDuration = jTY;
  public AnimatorSet ycU = new AnimatorSet();
  public int ycV;
  public int ycW = 1;
  
  protected abstract void eW(View paramView);
  
  public final a eX(View paramView)
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
    eW(paramView);
    return this;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator$Companion;", "", "()V", "DURATION", "", "getDURATION", "()J", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */