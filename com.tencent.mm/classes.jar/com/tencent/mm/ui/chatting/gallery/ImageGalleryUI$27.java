package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMViewPager;

final class ImageGalleryUI$27
  implements Runnable
{
  ImageGalleryUI$27(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153889);
    if (ImageGalleryUI.j(this.zME) == null)
    {
      AppMethodBeat.o(153889);
      return;
    }
    if ((h.a.dKg().mCm) && (ImageGalleryUI.n(this.zME) != null))
    {
      ImageGalleryUI.n(this.zME).setChecked(h.a.dKg().bF(ImageGalleryUI.j(this.zME).dJX()));
      ImageGalleryUI.o(this.zME).setOnClickListener(this.zME);
    }
    if (this.zME.nga.getCurrentItem() != 100000)
    {
      AppMethodBeat.o(153889);
      return;
    }
    this.zME.dKB();
    c.b localb = c.bu(ImageGalleryUI.j(this.zME).Pz(100000));
    if ((!this.zME.zMd) && (localb == c.b.zKq)) {
      ImageGalleryUI.j(this.zME).PV(100000);
    }
    if (localb == c.b.zKr) {
      ImageGalleryUI.j(this.zME).PZ(100000);
    }
    AppMethodBeat.o(153889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.27
 * JD-Core Version:    0.7.0.1
 */