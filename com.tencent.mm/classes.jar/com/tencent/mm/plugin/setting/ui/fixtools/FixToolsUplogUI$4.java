package com.tencent.mm.plugin.setting.ui.fixtools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FixToolsUplogUI$4
  implements MenuItem.OnMenuItemClickListener
{
  FixToolsUplogUI$4(FixToolsUplogUI paramFixToolsUplogUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126897);
    this.qFt.finish();
    AppMethodBeat.o(126897);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.4
 * JD-Core Version:    0.7.0.1
 */