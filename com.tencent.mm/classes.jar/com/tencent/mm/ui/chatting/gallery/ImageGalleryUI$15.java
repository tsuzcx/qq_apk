package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ImageGalleryUI$15
  implements ap.a
{
  ImageGalleryUI$15(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(153874);
    if (ImageGalleryUI.M(this.zME)) {
      this.zME.dKu();
    }
    AppMethodBeat.o(153874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.15
 * JD-Core Version:    0.7.0.1
 */