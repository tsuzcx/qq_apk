package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.ui.base.MMViewPager;

final class ImageGalleryUI$17
  implements Runnable
{
  ImageGalleryUI$17(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void run()
  {
    if (ImageGalleryUI.f(this.vww) == null) {}
    c.b localb;
    do
    {
      do
      {
        return;
        if ((h.a.cGc().khC) && (ImageGalleryUI.j(this.vww) != null))
        {
          ImageGalleryUI.j(this.vww).setChecked(h.a.cGc().bx(ImageGalleryUI.f(this.vww).cFU()));
          ImageGalleryUI.k(this.vww).setOnClickListener(this.vww);
        }
      } while (this.vww.kJC.getCurrentItem() != 100000);
      this.vww.cGw();
      localb = c.bk(ImageGalleryUI.f(this.vww).GW(100000));
      if ((!this.vww.vwe) && (localb == c.b.vup)) {
        ImageGalleryUI.f(this.vww).Ho(100000);
      }
    } while (localb != c.b.vuq);
    ImageGalleryUI.f(this.vww).Hs(100000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.17
 * JD-Core Version:    0.7.0.1
 */