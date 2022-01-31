package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.e.b;

final class ImageGalleryUI$2
  implements e.b
{
  ImageGalleryUI$2(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onAnimationEnd()
  {
    y.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
    ImageGalleryUI.q(this.vww).post(new ImageGalleryUI.2.2(this));
    ImageGalleryUI.a(this.vww, false);
  }
  
  public final void onAnimationStart()
  {
    ImageGalleryUI.a(this.vww, true);
    ImageGalleryUI.dM(ImageGalleryUI.u(this.vww));
    ImageGalleryUI.dM(ImageGalleryUI.v(this.vww));
    new ah().postDelayed(new ImageGalleryUI.2.1(this), 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.2
 * JD-Core Version:    0.7.0.1
 */