package com.tencent.mm.plugin.sns.ui.album;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsAlbumUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsAlbumUI$2(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(99877);
    if (this.xNS.getActivity() != null) {
      this.xNS.getActivity().finish();
    }
    AppMethodBeat.o(99877);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.2
 * JD-Core Version:    0.7.0.1
 */