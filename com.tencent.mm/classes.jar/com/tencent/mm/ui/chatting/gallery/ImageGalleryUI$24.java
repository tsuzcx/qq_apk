package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$24
  implements c.c
{
  ImageGalleryUI$24(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void mG()
  {
    AppMethodBeat.i(153885);
    if (ImageGalleryUI.j(this.zME) == null)
    {
      AppMethodBeat.o(153885);
      return;
    }
    ImageGalleryUI.k(this.zME);
    ImageGalleryUI.j(this.zME).onPageSelected(100000);
    AppMethodBeat.o(153885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.24
 * JD-Core Version:    0.7.0.1
 */