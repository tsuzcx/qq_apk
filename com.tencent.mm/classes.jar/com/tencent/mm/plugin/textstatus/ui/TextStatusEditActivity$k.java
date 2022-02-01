package com.tencent.mm.plugin.textstatus.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class TextStatusEditActivity$k
  implements ValueAnimator.AnimatorUpdateListener
{
  TextStatusEditActivity$k(TextStatusEditActivity paramTextStatusEditActivity, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(237905);
    if (paramValueAnimator != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      ValueAnimator localValueAnimator = paramValueAnimator;
      if (!(paramValueAnimator instanceof Float)) {
        localValueAnimator = null;
      }
      paramValueAnimator = (Float)localValueAnimator;
      if (paramValueAnimator == null) {
        break label66;
      }
    }
    label66:
    for (float f = paramValueAnimator.floatValue();; f = 0.0F)
    {
      this.MMz.A((int)(this.cLq - f), false);
      AppMethodBeat.o(237905);
      return;
      paramValueAnimator = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.k
 * JD-Core Version:    0.7.0.1
 */