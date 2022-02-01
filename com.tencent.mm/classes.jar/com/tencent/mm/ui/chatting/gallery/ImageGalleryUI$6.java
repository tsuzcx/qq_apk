package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$6
  extends AnimatorListenerAdapter
{
  ImageGalleryUI$6(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(36107);
    ImageGalleryUI.v(this.JSq).setAlpha(0.0F);
    AppMethodBeat.o(36107);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(36106);
    ImageGalleryUI.v(this.JSq).setAlpha(0.0F);
    AppMethodBeat.o(36106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */