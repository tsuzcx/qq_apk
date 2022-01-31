package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryGridUI$5
  implements MenuItem.OnMenuItemClickListener
{
  ImageGalleryGridUI$5(ImageGalleryGridUI paramImageGalleryGridUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(32039);
    this.zKU.onBackPressed();
    AppMethodBeat.o(32039);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.5
 * JD-Core Version:    0.7.0.1
 */