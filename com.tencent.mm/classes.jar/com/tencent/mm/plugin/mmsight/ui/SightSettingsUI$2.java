package com.tencent.mm.plugin.mmsight.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightSettingsUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SightSettingsUI$2(SightSettingsUI paramSightSettingsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55280);
    this.oQB.finish();
    AppMethodBeat.o(55280);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.2
 * JD-Core Version:    0.7.0.1
 */