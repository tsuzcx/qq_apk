package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.e.b;

final class ImageGalleryUI$7
  implements e.b
{
  ImageGalleryUI$7(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(153865);
    ab.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
    ImageGalleryUI.t(this.zME).post(new ImageGalleryUI.7.2(this));
    ImageGalleryUI.b(this.zME, false);
    AppMethodBeat.o(153865);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(153864);
    ImageGalleryUI.b(this.zME, true);
    ImageGalleryUI.eU(ImageGalleryUI.x(this.zME));
    ImageGalleryUI.eU(ImageGalleryUI.y(this.zME));
    new ak().postDelayed(new ImageGalleryUI.7.1(this), 20L);
    AppMethodBeat.o(153864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */