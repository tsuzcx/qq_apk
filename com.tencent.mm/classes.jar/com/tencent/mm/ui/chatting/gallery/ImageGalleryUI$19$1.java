package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.tools.e.b;

final class ImageGalleryUI$19$1
  implements e.b
{
  ImageGalleryUI$19$1(ImageGalleryUI.19 param19) {}
  
  public final void onAnimationEnd()
  {
    ImageGalleryUI.q(this.vwz.vww).post(new Runnable()
    {
      public final void run()
      {
        if (ImageGalleryUI.19.1.this.vwz.vww.vwh != null) {
          ImageGalleryUI.19.1.this.vwz.vww.vwh.k(Boolean.valueOf(false));
        }
      }
    });
  }
  
  public final void onAnimationStart()
  {
    if (this.vwz.vww.vwh != null) {
      this.vwz.vww.vwh.k(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.19.1
 * JD-Core Version:    0.7.0.1
 */