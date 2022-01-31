package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.b.d.a;

final class ImageGalleryUI$9
  implements d.a
{
  ImageGalleryUI$9(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(153867);
    ao localao = new ao();
    localao.cnS.filePath = ImageGalleryUI.b(this.zME);
    a.ymk.l(localao);
    ImageGalleryUI.z(this.zME);
    ImageGalleryUI.e(this.zME);
    ImageGalleryUI.a(this.zME, null);
    ImageGalleryUI.b(this.zME, null);
    ImageGalleryUI.c(this.zME, null);
    ImageGalleryUI.a(this.zME, ImageGalleryUI.b(this.zME, 0));
    ImageGalleryUI.A(this.zME);
    ImageGalleryUI.a(this.zME, false);
    AppMethodBeat.o(153867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */