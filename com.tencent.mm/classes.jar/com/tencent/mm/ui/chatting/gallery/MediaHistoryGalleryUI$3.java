package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MediaHistoryGalleryUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MediaHistoryGalleryUI$3(MediaHistoryGalleryUI paramMediaHistoryGalleryUI)
  {
    AppMethodBeat.i(36349);
    AppMethodBeat.o(36349);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(254509);
    this.aeFW.finish();
    AppMethodBeat.o(254509);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */