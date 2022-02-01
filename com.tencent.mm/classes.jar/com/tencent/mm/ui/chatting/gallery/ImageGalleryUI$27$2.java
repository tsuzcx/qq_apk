package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.cc;

final class ImageGalleryUI$27$2
  implements DialogInterface.OnClickListener
{
  ImageGalleryUI$27$2(ImageGalleryUI.27 param27, cc paramcc, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(254424);
    ImageGalleryUI.a(this.aeEg.aeDZ, this.oiV);
    h.OAn.b(17509, new Object[] { Integer.valueOf(2), this.aewM });
    AppMethodBeat.o(254424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.27.2
 * JD-Core Version:    0.7.0.1
 */