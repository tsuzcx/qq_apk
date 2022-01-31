package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class UnfamiliarContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  UnfamiliarContactUI$1(UnfamiliarContactUI paramUnfamiliarContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127684);
    this.qLL.finish();
    AppMethodBeat.o(127684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI.1
 * JD-Core Version:    0.7.0.1
 */