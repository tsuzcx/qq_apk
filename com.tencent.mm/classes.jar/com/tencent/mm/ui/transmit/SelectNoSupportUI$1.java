package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectNoSupportUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectNoSupportUI$1(SelectNoSupportUI paramSelectNoSupportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35208);
    paramMenuItem = this.AAz;
    paramMenuItem.hideVKB();
    paramMenuItem.finish();
    AppMethodBeat.o(35208);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI.1
 * JD-Core Version:    0.7.0.1
 */