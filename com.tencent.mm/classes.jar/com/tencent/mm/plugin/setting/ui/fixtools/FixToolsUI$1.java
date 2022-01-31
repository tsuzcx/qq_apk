package com.tencent.mm.plugin.setting.ui.fixtools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FixToolsUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FixToolsUI$1(FixToolsUI paramFixToolsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126883);
    this.qFj.finish();
    AppMethodBeat.o(126883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI.1
 * JD-Core Version:    0.7.0.1
 */