package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppProfileUI$2
  implements MenuItem.OnMenuItemClickListener
{
  AppProfileUI$2(AppProfileUI paramAppProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25452);
    this.sYV.finish();
    AppMethodBeat.o(25452);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.2
 * JD-Core Version:    0.7.0.1
 */