package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class SightUploadUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$4(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38587);
    paramMenuItem = this.rLy.getContext();
    String str = this.rLy.getString(2131303727);
    SightUploadUI.4.1 local1 = new SightUploadUI.4.1(this);
    h.a(paramMenuItem, null, new String[] { str }, null, local1);
    AppMethodBeat.o(38587);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.4
 * JD-Core Version:    0.7.0.1
 */