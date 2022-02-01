package com.tencent.mm.plugin.vlog.ui.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  implements Animator.AnimatorListener
{
  c$b(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(281914);
    s.u(paramAnimator, "animation");
    AppMethodBeat.o(281914);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(281906);
    s.u(paramAnimator, "animation");
    paramAnimator = c.a(this.UrG);
    if (paramAnimator != null) {
      paramAnimator.requestLayout();
    }
    AppMethodBeat.o(281906);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(281918);
    s.u(paramAnimator, "animation");
    AppMethodBeat.o(281918);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(281899);
    s.u(paramAnimator, "animation");
    AppMethodBeat.o(281899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.c.b
 * JD-Core Version:    0.7.0.1
 */