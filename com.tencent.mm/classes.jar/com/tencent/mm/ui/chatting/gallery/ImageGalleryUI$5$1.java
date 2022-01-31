package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.e.b;

final class ImageGalleryUI$5$1
  implements e.b
{
  ImageGalleryUI$5$1(ImageGalleryUI.5 param5) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(153858);
    ImageGalleryUI.t(this.zMF.zME).post(new ImageGalleryUI.5.1.1(this));
    AppMethodBeat.o(153858);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(153857);
    if (this.zMF.zME.zMo != null) {
      this.zMF.zME.zMo.m(Boolean.TRUE);
    }
    AppMethodBeat.o(153857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.5.1
 * JD-Core Version:    0.7.0.1
 */