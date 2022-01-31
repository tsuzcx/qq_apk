package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$3
  extends AnimatorListenerAdapter
{
  ImageGalleryUI$3(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(153854);
    ImageGalleryUI.p(this.zME).setAlpha(0.0F);
    AppMethodBeat.o(153854);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(153853);
    ImageGalleryUI.p(this.zME).setAlpha(0.0F);
    AppMethodBeat.o(153853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */