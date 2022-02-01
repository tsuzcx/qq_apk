package com.tencent.mm.ui.widget.cropview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.v.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
public final class CropLayout$s
  implements Animator.AnimatorListener
{
  CropLayout$s(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, v.b paramb1, v.b paramb2) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(203958);
    CropLayout.b localb = this.HDN.getOnChangeListener();
    paramAnimator = localb;
    if (!(localb instanceof CropLayout.q)) {
      paramAnimator = null;
    }
    paramAnimator = (CropLayout.q)paramAnimator;
    if (paramAnimator != null)
    {
      paramAnimator.fZk();
      AppMethodBeat.o(203958);
      return;
    }
    AppMethodBeat.o(203958);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout.s
 * JD-Core Version:    0.7.0.1
 */