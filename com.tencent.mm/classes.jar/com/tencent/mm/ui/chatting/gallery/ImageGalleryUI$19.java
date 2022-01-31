package com.tencent.mm.ui.chatting.gallery;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.tools.e;

final class ImageGalleryUI$19
  implements ViewTreeObserver.OnPreDrawListener
{
  ImageGalleryUI$19(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onPreDraw()
  {
    this.vww.kJC.getViewTreeObserver().removeOnPreDrawListener(this);
    this.vww.oVF = this.vww.kJC.getWidth();
    this.vww.oVG = this.vww.kJC.getHeight();
    if (ImageGalleryUI.f(this.vww).cFU().aRR()) {
      this.vww.oVG = ((int)(this.vww.oVF / this.vww.itD * this.vww.itE));
    }
    if (ImageGalleryUI.f(this.vww).cFU().ctB())
    {
      ImageGalleryUI.a(this.vww, ImageGalleryUI.f(this.vww).rX(this.vww.kJC.getCurrentItem()));
      if (ImageGalleryUI.l(this.vww) == null)
      {
        WxImageView localWxImageView = ImageGalleryUI.f(this.vww).rY(this.vww.kJC.getCurrentItem());
        if (localWxImageView != null) {
          ImageGalleryUI.a(this.vww, (WxImageView)localWxImageView);
        }
      }
    }
    if (ImageGalleryUI.l(this.vww) != null)
    {
      this.vww.oVG = ((int)(this.vww.oVF / ImageGalleryUI.l(this.vww).getImageWidth() * ImageGalleryUI.l(this.vww).getImageHeight()));
      if (this.vww.oVG > this.vww.kJC.getHeight()) {
        this.vww.oVG = this.vww.kJC.getHeight();
      }
    }
    for (;;)
    {
      this.vww.itA.fH(this.vww.oVF, this.vww.oVG);
      if (!this.vww.vwe)
      {
        ImageGalleryUI.n(this.vww);
        ImageGalleryUI.o(this.vww);
        this.vww.itA.a(this.vww.kJC, ImageGalleryUI.p(this.vww), new ImageGalleryUI.19.1(this));
      }
      ImageGalleryUI.r(this.vww);
      return true;
      if (ImageGalleryUI.m(this.vww) != null)
      {
        this.vww.oVG = ((int)(this.vww.oVF / ImageGalleryUI.m(this.vww).getWidth() * ImageGalleryUI.m(this.vww).getHeight()));
        if (this.vww.oVG > this.vww.kJC.getHeight()) {
          this.vww.oVG = this.vww.kJC.getHeight();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.19
 * JD-Core Version:    0.7.0.1
 */