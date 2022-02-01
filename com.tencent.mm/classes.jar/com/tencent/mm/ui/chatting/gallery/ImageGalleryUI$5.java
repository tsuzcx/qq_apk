package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$5
  extends AnimatorListenerAdapter
{
  ImageGalleryUI$5(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(196556);
    ImageGalleryUI.r(this.IcP).setAlpha(0.0F);
    AppMethodBeat.o(196556);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(196555);
    ImageGalleryUI.r(this.IcP).setAlpha(0.0F);
    AppMethodBeat.o(196555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */