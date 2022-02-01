package com.tencent.mm.plugin.sns.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsBaseGalleryUI$12
  implements ValueAnimator.AnimatorUpdateListener
{
  SnsBaseGalleryUI$12(SnsBaseGalleryUI paramSnsBaseGalleryUI, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(267543);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      SnsBaseGalleryUI.f(this.KOi).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      SnsBaseGalleryUI.f(this.KOi).setTranslationY(f * (this.wBy - SnsBaseGalleryUI.f(this.KOi).getHeight()));
      AppMethodBeat.o(267543);
      return;
      if (f >= 0.9F) {
        SnsBaseGalleryUI.f(this.KOi).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.12
 * JD-Core Version:    0.7.0.1
 */