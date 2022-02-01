package com.tencent.mm.plugin.recordvideo.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
final class WxCropOperationLayout$o
  implements ValueAnimator.AnimatorUpdateListener
{
  WxCropOperationLayout$o(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(199376);
    k.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(199376);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    WxCropOperationLayout.a(this.wzw, i);
    this.wzw.invalidate();
    AppMethodBeat.o(199376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.o
 * JD-Core Version:    0.7.0.1
 */