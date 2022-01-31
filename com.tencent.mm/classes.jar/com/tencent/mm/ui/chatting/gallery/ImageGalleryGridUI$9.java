package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.i;
import java.util.Set;

final class ImageGalleryGridUI$9
  implements DialogInterface.OnClickListener
{
  ImageGalleryGridUI$9(ImageGalleryGridUI paramImageGalleryGridUI, Set paramSet) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32047);
    ab.i("MicroMsg.GalleryGridUI", "delete message");
    i.a(this.zKU, this.zKZ, this.zKU);
    this.zKU.byi();
    AppMethodBeat.o(32047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.9
 * JD-Core Version:    0.7.0.1
 */