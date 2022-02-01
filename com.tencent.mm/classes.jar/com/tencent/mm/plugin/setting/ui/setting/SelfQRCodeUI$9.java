package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelfQRCodeUI$9
  implements MenuItem.OnMenuItemClickListener
{
  SelfQRCodeUI$9(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(73956);
    this.PpF.hideVKB();
    this.PpF.finish();
    AppMethodBeat.o(73956);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */