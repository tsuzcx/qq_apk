package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$19
  implements Animation.AnimationListener
{
  ImageGalleryUI$19(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(153878);
    if (ImageGalleryUI.Q(ImageGalleryUI.P(this.zME)).getVisibility() != 0)
    {
      AppMethodBeat.o(153878);
      return;
    }
    this.zME.dKu();
    ImageGalleryUI.R(ImageGalleryUI.P(this.zME)).setVisibility(8);
    ImageGalleryUI.K(this.zME);
    ImageGalleryUI.L(this.zME);
    AppMethodBeat.o(153878);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.19
 * JD-Core Version:    0.7.0.1
 */