package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VcardContactUI$3
  implements MenuItem.OnMenuItemClickListener
{
  VcardContactUI$3(VcardContactUI paramVcardContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(52004);
    this.Pdo.finish();
    AppMethodBeat.o(52004);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.3
 * JD-Core Version:    0.7.0.1
 */