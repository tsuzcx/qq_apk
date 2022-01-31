package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.j;
import java.util.Set;

final class ImageGalleryGridUI$9
  implements DialogInterface.OnClickListener
{
  ImageGalleryGridUI$9(ImageGalleryGridUI paramImageGalleryGridUI, Set paramSet) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.GalleryGridUI", "delete message");
    j.a(this.vuT, this.vuY, this.vuT);
    this.vuT.aRP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.9
 * JD-Core Version:    0.7.0.1
 */