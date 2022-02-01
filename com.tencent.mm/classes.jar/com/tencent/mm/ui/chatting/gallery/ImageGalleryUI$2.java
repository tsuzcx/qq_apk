package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.gallery.a.n;
import com.tencent.mm.ui.widget.a.e;

final class ImageGalleryUI$2
  implements ScanCodeSheetItemLogic.b
{
  ImageGalleryUI$2(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void asu(String paramString)
  {
    AppMethodBeat.i(233302);
    if ((ImageGalleryUI.d(this.PzQ) != null) && (ImageGalleryUI.d(this.PzQ).isShowing()) && (Util.isEqual(paramString, ImageGalleryUI.b(this.PzQ).CFJ))) {
      this.PzQ.dTH();
    }
    AppMethodBeat.o(233302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.2
 * JD-Core Version:    0.7.0.1
 */