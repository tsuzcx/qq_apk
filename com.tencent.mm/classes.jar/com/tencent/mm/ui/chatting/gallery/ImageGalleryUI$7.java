package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$7
  extends AnimatorListenerAdapter
{
  ImageGalleryUI$7(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(187497);
    ImageGalleryUI.x(this.KnP).setAlpha(0.0F);
    AppMethodBeat.o(187497);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(187496);
    ImageGalleryUI.x(this.KnP).setAlpha(0.0F);
    AppMethodBeat.o(187496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */