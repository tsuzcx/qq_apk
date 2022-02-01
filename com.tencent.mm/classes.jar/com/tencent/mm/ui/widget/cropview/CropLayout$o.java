package com.tencent.mm.ui.widget.cropview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CropLayout$o
  implements Animator.AnimatorListener
{
  CropLayout$o(CropLayout paramCropLayout, a<ah> parama) {}
  
  private static final void ce(a parama)
  {
    AppMethodBeat.i(252525);
    s.u(parama, "$onAnimationEnd");
    parama.invoke();
    AppMethodBeat.o(252525);
  }
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(252540);
    this.agdy.post(new CropLayout.o..ExternalSyntheticLambda0(this.GUX));
    AppMethodBeat.o(252540);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout.o
 * JD-Core Version:    0.7.0.1
 */