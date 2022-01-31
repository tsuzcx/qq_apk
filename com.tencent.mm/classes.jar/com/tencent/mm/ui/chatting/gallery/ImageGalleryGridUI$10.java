package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.protocal.protobuf.acq;
import java.util.LinkedList;
import java.util.List;

final class ImageGalleryGridUI$10
  implements DialogInterface.OnClickListener
{
  ImageGalleryGridUI$10(ImageGalleryGridUI paramImageGalleryGridUI, cm paramcm, List paramList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32048);
    if ((this.zEZ.cpR.type == 14) && (this.zEZ.cpR.cpT.wVc.size() == 0))
    {
      this.zKU.byi();
      AppMethodBeat.o(32048);
      return;
    }
    ImageGalleryGridUI.a(this.zKU, this.zEZ);
    ImageGalleryGridUI.fk(this.ieO);
    AppMethodBeat.o(32048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.10
 * JD-Core Version:    0.7.0.1
 */