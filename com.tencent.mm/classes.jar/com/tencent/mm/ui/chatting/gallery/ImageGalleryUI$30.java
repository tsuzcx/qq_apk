package com.tencent.mm.ui.chatting.gallery;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class ImageGalleryUI$30
  extends n.a
{
  ImageGalleryUI$30(ImageGalleryUI paramImageGalleryUI)
  {
    AppMethodBeat.i(161543);
    AppMethodBeat.o(161543);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(196588);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196587);
        if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4))
        {
          if (ImageGalleryUI.g(ImageGalleryUI.30.this.IcP) == 1)
          {
            h.c(ImageGalleryUI.30.this.IcP, ImageGalleryUI.30.this.IcP.getString(2131755828), "", true);
            ImageGalleryUI.h(ImageGalleryUI.30.this.IcP);
            AppMethodBeat.o(196587);
          }
        }
        else
        {
          if (ImageGalleryUI.i(ImageGalleryUI.30.this.IcP) == null)
          {
            AppMethodBeat.o(196587);
            return;
          }
          int i = ImageGalleryUI.30.this.IcP.getCurrentItem();
          bo localbo = ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).aaP(i);
          if ((localbo != null) && (localbo.cru()))
          {
            if (ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).fph() == null) {
              ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).fph().fpS();
            }
            if ((ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).fph().fpS().IdL.getVisibility() == 0) || (ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).fph().fpS().IdU.getVisibility() == 0)) {
              ImageGalleryUI.i(ImageGalleryUI.30.this.IcP).abo(i);
            }
          }
        }
        AppMethodBeat.o(196587);
      }
    });
    AppMethodBeat.o(196588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.30
 * JD-Core Version:    0.7.0.1
 */