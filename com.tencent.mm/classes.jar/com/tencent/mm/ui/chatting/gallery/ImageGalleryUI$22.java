package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

final class ImageGalleryUI$22
  extends n.a
{
  ImageGalleryUI$22(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(153883);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153882);
        if ((g.Rc().adt() != 6) && (g.Rc().adt() != 4) && (ImageGalleryUI.f(ImageGalleryUI.22.this.zME) == 1))
        {
          h.b(ImageGalleryUI.22.this.zME, ImageGalleryUI.22.this.zME.getString(2131297011), "", true);
          ImageGalleryUI.g(ImageGalleryUI.22.this.zME);
        }
        AppMethodBeat.o(153882);
      }
    });
    AppMethodBeat.o(153883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.22
 * JD-Core Version:    0.7.0.1
 */