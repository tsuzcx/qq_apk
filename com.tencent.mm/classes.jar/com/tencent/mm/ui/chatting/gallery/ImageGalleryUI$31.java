package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$31
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ImageGalleryUI$31(ImageGalleryUI paramImageGalleryUI, View paramView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(194176);
    this.JSz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    ImageGalleryUI.Y(this.JSq);
    AppMethodBeat.o(194176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.31
 * JD-Core Version:    0.7.0.1
 */