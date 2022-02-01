package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.view.View;
import androidx.core.g.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a Sic = new a.a((byte)0);
  private static final long scq = 1000L;
  public AnimatorSet Sid = new AnimatorSet();
  public int Sie;
  public int Sif = 1;
  public long mDuration = scq;
  
  protected abstract void ka(View paramView);
  
  public final a kb(View paramView)
  {
    s.u(paramView, "target");
    s.u(paramView, "target");
    z.f(paramView, 1.0F);
    z.g(paramView, 1.0F);
    z.h(paramView, 1.0F);
    z.d(paramView, 0.0F);
    z.e(paramView, 0.0F);
    z.ad(paramView);
    z.af(paramView);
    z.ae(paramView);
    ka(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.a
 * JD-Core Version:    0.7.0.1
 */