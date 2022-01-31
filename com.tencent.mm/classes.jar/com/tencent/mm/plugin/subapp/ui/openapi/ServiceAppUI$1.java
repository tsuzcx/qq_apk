package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServiceAppUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ServiceAppUI$1(ServiceAppUI paramServiceAppUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25471);
    this.sZe.finish();
    AppMethodBeat.o(25471);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.1
 * JD-Core Version:    0.7.0.1
 */