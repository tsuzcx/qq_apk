package com.tencent.mm.ui.chatting.gallery;

import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryGridUI$3
  implements Runnable
{
  ImageGalleryGridUI$3(ImageGalleryGridUI paramImageGalleryGridUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(32036);
    if ((ImageGalleryGridUI.a(this.zKU) != null) && (ImageGalleryGridUI.a(this.zKU).getVisibility() != 0)) {
      ImageGalleryGridUI.a(this.zKU).setVisibility(0);
    }
    AppMethodBeat.o(32036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.3
 * JD-Core Version:    0.7.0.1
 */