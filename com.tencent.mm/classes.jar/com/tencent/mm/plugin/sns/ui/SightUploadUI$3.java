package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.sdk.b.a;

final class SightUploadUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$3(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38585);
    paramMenuItem = new rd();
    paramMenuItem.cHE.type = 0;
    paramMenuItem.cHE.cHG = false;
    a.ymk.l(paramMenuItem);
    this.rLy.hideVKB();
    this.rLy.finish();
    AppMethodBeat.o(38585);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.3
 * JD-Core Version:    0.7.0.1
 */