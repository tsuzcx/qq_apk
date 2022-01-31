package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryUI$17
  implements Runnable
{
  ImageGalleryUI$17(ImageGalleryUI paramImageGalleryUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(153876);
    if (ImageGalleryUI.j(this.zME) == null)
    {
      AppMethodBeat.o(153876);
      return;
    }
    c localc = ImageGalleryUI.j(this.zME);
    int i = this.gxr;
    localc.zJQ.pause(i);
    AppMethodBeat.o(153876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.17
 * JD-Core Version:    0.7.0.1
 */