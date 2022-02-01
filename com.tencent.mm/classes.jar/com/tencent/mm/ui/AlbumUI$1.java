package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;

final class AlbumUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AlbumUI$1(AlbumUI paramAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(249405);
    ((f)h.az(f.class)).goLikeListFromSelfHistory(this.adue.getContext());
    ((f)h.az(f.class)).report22208(18L, "");
    AppMethodBeat.o(249405);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI.1
 * JD-Core Version:    0.7.0.1
 */