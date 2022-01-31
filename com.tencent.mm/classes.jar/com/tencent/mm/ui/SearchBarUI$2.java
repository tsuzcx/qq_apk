package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SearchBarUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SearchBarUI$2(SearchBarUI paramSearchBarUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112458);
    this.zeM.finish();
    AppMethodBeat.o(112458);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI.2
 * JD-Core Version:    0.7.0.1
 */