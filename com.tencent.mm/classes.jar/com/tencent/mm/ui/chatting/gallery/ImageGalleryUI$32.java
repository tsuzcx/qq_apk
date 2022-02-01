package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;

final class ImageGalleryUI$32
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ImageGalleryUI$32(ImageGalleryUI paramImageGalleryUI, View paramView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(194177);
    this.JSz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    int i = a.ip(this.JSq);
    int j = a.iq(this.JSq);
    ad.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i <= j) || ((d.ly(24)) && (this.JSq.isInMultiWindowMode())))
    {
      ImageGalleryUI.Y(this.JSq);
      AppMethodBeat.o(194177);
      return;
    }
    ImageGalleryUI.Z(this.JSq);
    AppMethodBeat.o(194177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.32
 * JD-Core Version:    0.7.0.1
 */