package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import a.f.b.j;
import a.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
public final class a$b
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(150733);
    j.q(paramAnimator, "animation");
    a.a(this.qdq).setVisibility(8);
    a.a(this.qdq).setAlpha(1.0F);
    AppMethodBeat.o(150733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.b
 * JD-Core Version:    0.7.0.1
 */