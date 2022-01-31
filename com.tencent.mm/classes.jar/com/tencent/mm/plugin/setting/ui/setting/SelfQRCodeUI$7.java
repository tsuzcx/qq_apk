package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelfQRCodeUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SelfQRCodeUI$7(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(154167);
    this.qGz.hideVKB();
    this.qGz.finish();
    AppMethodBeat.o(154167);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.7
 * JD-Core Version:    0.7.0.1
 */