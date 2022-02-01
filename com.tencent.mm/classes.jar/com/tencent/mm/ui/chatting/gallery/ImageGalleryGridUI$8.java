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
    AppMethodBeat.i(35961);
    if (this.PxH.PxA != null)
    {
      this.PxH.PxA.setVisibility(8);
      this.PxH.PxA = null;
    }
    AppMethodBeat.o(35961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.8
 * JD-Core Version:    0.7.0.1
 */