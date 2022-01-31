package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.plugin.scanner.d;
import com.tencent.mm.ui.base.MMViewPager.c;

final class ImageGalleryUI$26
  implements MMViewPager.c
{
  ImageGalleryUI$26(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void bxv()
  {
    AppMethodBeat.i(153888);
    if (ImageGalleryUI.f(this.zME) == 1)
    {
      AppMethodBeat.o(153888);
      return;
    }
    if ((ImageGalleryUI.f(this.zME) == 0) || (ImageGalleryUI.f(this.zME) == 2))
    {
      m localm = new m();
      if (ImageGalleryUI.f(this.zME) == 2) {}
      for (long l = 1L;; l = 0L)
      {
        localm.cRG = l;
        localm.cRH = 1L;
        localm.ake();
        this.zME.al(true, d.chW());
        AppMethodBeat.o(153888);
        return;
      }
    }
    this.zME.al(true, false);
    AppMethodBeat.o(153888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.26
 * JD-Core Version:    0.7.0.1
 */