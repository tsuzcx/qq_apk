package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements ValueAnimator.AnimatorUpdateListener
{
  a$5(a parama, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(29061);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      this.BAk.rHi.setAlpha(f * 10.0F);
    }
    for (;;)
    {
      this.BAk.rHi.setTranslationY(f * (this.rvD - this.BAk.rHi.getHeight()));
      AppMethodBeat.o(29061);
      return;
      if (f >= 0.9F) {
        this.BAk.rHi.setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a.5
 * JD-Core Version:    0.7.0.1
 */