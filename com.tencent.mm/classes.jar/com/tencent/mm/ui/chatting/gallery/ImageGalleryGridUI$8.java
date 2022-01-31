package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryGridUI$8
  implements Runnable
{
  ImageGalleryGridUI$8(ImageGalleryGridUI paramImageGalleryGridUI) {}
  
  @TargetApi(12)
  public final void run()
  {
    AppMethodBeat.i(32046);
    if (this.zKU.zKN != null)
    {
      this.zKU.zKN.setVisibility(8);
      this.zKU.zKN = null;
    }
    AppMethodBeat.o(32046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.8
 * JD-Core Version:    0.7.0.1
 */