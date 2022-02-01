package com.tencent.mm.ui.widget.cropview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.y.c;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
final class CropLayout$i
  implements ValueAnimator.AnimatorUpdateListener
{
  CropLayout$i(y.c paramc, CropLayout paramCropLayout, float paramFloat) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(164388);
    paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(164388);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    CropLayout.a(this.KVs, f - this.KVt.MLS);
    this.KVt.MLS = f;
    AppMethodBeat.o(164388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout.i
 * JD-Core Version:    0.7.0.1
 */