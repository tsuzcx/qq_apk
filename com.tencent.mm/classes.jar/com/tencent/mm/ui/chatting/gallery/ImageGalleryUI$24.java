package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$24
  implements Runnable
{
  ImageGalleryUI$24(ImageGalleryUI paramImageGalleryUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(36135);
    if (ImageGalleryUI.i(this.IcP) == null)
    {
      AppMethodBeat.o(36135);
      return;
    }
    b localb = ImageGalleryUI.i(this.IcP);
    int i = this.iKv;
    localb.Iab.pause(i);
    AppMethodBeat.o(36135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.24
 * JD-Core Version:    0.7.0.1
 */