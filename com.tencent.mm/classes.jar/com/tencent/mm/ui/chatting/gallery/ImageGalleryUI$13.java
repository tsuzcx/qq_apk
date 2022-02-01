package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$13
  extends AnimatorListenerAdapter
{
  ImageGalleryUI$13(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(284293);
    ImageGalleryUI.M(this.WUq).setAlpha(0.0F);
    AppMethodBeat.o(284293);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(284292);
    ImageGalleryUI.M(this.WUq).setAlpha(0.0F);
    AppMethodBeat.o(284292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.13
 * JD-Core Version:    0.7.0.1
 */