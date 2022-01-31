package com.tencent.mm.ui.chatting.gallery;

import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryGridUI$1
  implements Runnable
{
  ImageGalleryGridUI$1(ImageGalleryGridUI paramImageGalleryGridUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(32034);
    if ((ImageGalleryGridUI.a(this.zKU) != null) && (ImageGalleryGridUI.a(this.zKU).getVisibility() != 4)) {
      ImageGalleryGridUI.a(this.zKU).setVisibility(4);
    }
    AppMethodBeat.o(32034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.1
 * JD-Core Version:    0.7.0.1
 */