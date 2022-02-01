package com.tencent.mm.plugin.sns.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsBaseGalleryUI$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SnsBaseGalleryUI$2(SnsBaseGalleryUI paramSnsBaseGalleryUI, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(98482);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      SnsBaseGalleryUI.a(this.Aaa).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      SnsBaseGalleryUI.a(this.Aaa).setTranslationY(f * (this.rny - SnsBaseGalleryUI.a(this.Aaa).getHeight()));
      AppMethodBeat.o(98482);
      return;
      if (f >= 0.9F) {
        SnsBaseGalleryUI.a(this.Aaa).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.2
 * JD-Core Version:    0.7.0.1
 */