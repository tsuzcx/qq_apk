package com.tencent.mm.ui.chatting.gallery;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.e;

final class ImageGalleryUI$5
  implements ViewTreeObserver.OnPreDrawListener
{
  ImageGalleryUI$5(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153859);
    this.zME.nga.getViewTreeObserver().removeOnPreDrawListener(this);
    ab.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + this.zME.zMd);
    this.zME.rOa = this.zME.nga.getWidth();
    this.zME.rOb = this.zME.nga.getHeight();
    if (ImageGalleryUI.j(this.zME).dJX().byk()) {
      this.zME.rOb = ((int)(this.zME.rOa / this.zME.kuI * this.zME.kuJ));
    }
    if (ImageGalleryUI.j(this.zME).dJX().dvX())
    {
      g localg = (g)ImageGalleryUI.a(this.zME, ImageGalleryUI.j(this.zME), this.zME.nga);
      if (localg != null)
      {
        ImageGalleryUI localImageGalleryUI = this.zME;
        float f = this.zME.rOa / localg.getImageWidth();
        localImageGalleryUI.rOb = ((int)(localg.getImageHeight() * f));
        if (this.zME.rOb > this.zME.nga.getHeight()) {
          this.zME.rOb = this.zME.nga.getHeight();
        }
      }
    }
    this.zME.kip.hO(this.zME.rOa, this.zME.rOb);
    if (!this.zME.zMd)
    {
      ImageGalleryUI.q(this.zME);
      ImageGalleryUI.r(this.zME);
      this.zME.kip.a(this.zME.nga, ImageGalleryUI.s(this.zME), new ImageGalleryUI.5.1(this));
    }
    ImageGalleryUI.u(this.zME);
    AppMethodBeat.o(153859);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */