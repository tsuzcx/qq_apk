package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ImageGalleryUI$6(ImageGalleryUI paramImageGalleryUI, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(36108);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ImageGalleryUI.w(this.GCT).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ImageGalleryUI.w(this.GCT).setTranslationY(f * (this.pVd - ImageGalleryUI.w(this.GCT).getHeight()));
      AppMethodBeat.o(36108);
      return;
      if (f >= 0.9F) {
        ImageGalleryUI.w(this.GCT).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */