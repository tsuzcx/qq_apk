package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
public final class p$b
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(150677);
    j.q(paramAnimator, "animation");
    AppMethodBeat.o(150677);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(150676);
    j.q(paramAnimator, "animation");
    p.a(this.qcH).requestLayout();
    AppMethodBeat.o(150676);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(150678);
    j.q(paramAnimator, "animation");
    AppMethodBeat.o(150678);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(150675);
    j.q(paramAnimator, "animation");
    AppMethodBeat.o(150675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p.b
 * JD-Core Version:    0.7.0.1
 */