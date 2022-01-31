package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditRevertPlugin$showAppearAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-recordvideo_release"})
public final class j$b
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(150652);
    a.f.b.j.q(paramAnimator, "animation");
    this.qcq.view.setEnabled(true);
    AppMethodBeat.o(150652);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(150653);
    a.f.b.j.q(paramAnimator, "animation");
    this.qcq.view.setEnabled(false);
    AppMethodBeat.o(150653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j.b
 * JD-Core Version:    0.7.0.1
 */