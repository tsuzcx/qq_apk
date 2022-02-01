package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$8
  implements ValueAnimator.AnimatorUpdateListener
{
  ImageGalleryUI$8(ImageGalleryUI paramImageGalleryUI, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(187498);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ImageGalleryUI.x(this.KnP).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ImageGalleryUI.x(this.KnP).setTranslationY(f * (this.rvD - ImageGalleryUI.x(this.KnP).getHeight()));
      AppMethodBeat.o(187498);
      return;
      if (f >= 0.9F) {
        ImageGalleryUI.x(this.KnP).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */