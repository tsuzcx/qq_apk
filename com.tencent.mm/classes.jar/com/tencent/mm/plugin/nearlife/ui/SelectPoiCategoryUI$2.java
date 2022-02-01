package com.tencent.mm.plugin.nearlife.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectPoiCategoryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SelectPoiCategoryUI$2(SelectPoiCategoryUI paramSelectPoiCategoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26627);
    this.ACD.setResult(0, null);
    this.ACD.finish();
    AppMethodBeat.o(26627);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.2
 * JD-Core Version:    0.7.0.1
 */