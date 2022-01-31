package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.h.a.am;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.a.d.a;

final class ImageGalleryUI$4
  implements d.a
{
  ImageGalleryUI$4(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onDismiss()
  {
    am localam = new am();
    localam.bGF.filePath = ImageGalleryUI.b(this.vww);
    a.udP.m(localam);
    ImageGalleryUI.w(this.vww);
    ImageGalleryUI.e(this.vww);
    ImageGalleryUI.a(this.vww, null);
    ImageGalleryUI.a(this.vww, ImageGalleryUI.b(this.vww, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */