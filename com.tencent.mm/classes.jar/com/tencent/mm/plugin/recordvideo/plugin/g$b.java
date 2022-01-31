package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
public final class g$b
  implements Animation.AnimationListener
{
  g$b(int paramInt) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(150635);
    j.q(paramAnimation, "animation");
    this.qcl.qcg.setVisibility(this.qcm);
    AppMethodBeat.o(150635);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    AppMethodBeat.i(150636);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(150636);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(150634);
    j.q(paramAnimation, "animation");
    AppMethodBeat.o(150634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.g.b
 * JD-Core Version:    0.7.0.1
 */