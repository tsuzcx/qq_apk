package com.tencent.mm.plugin.sns.ui.album;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsAlbumUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsAlbumUI$2(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(99877);
    if (this.RHX.getActivity() != null) {
      this.RHX.getActivity().finish();
    }
    AppMethodBeat.o(99877);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.2
 * JD-Core Version:    0.7.0.1
 */