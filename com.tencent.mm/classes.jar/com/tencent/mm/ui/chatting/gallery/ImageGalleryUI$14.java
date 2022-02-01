package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$14
  implements ValueAnimator.AnimatorUpdateListener
{
  ImageGalleryUI$14(ImageGalleryUI paramImageGalleryUI, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(279176);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ImageGalleryUI.M(this.WUq).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ImageGalleryUI.M(this.WUq).setTranslationY(f * (this.wBy - ImageGalleryUI.M(this.WUq).getHeight()));
      AppMethodBeat.o(279176);
      return;
      if (f >= 0.9F) {
        ImageGalleryUI.M(this.WUq).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.14
 * JD-Core Version:    0.7.0.1
 */