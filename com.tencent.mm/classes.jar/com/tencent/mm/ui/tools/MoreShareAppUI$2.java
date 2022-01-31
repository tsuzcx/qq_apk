package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MoreShareAppUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MoreShareAppUI$2(MoreShareAppUI paramMoreShareAppUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34885);
    this.Aws.finish();
    AppMethodBeat.o(34885);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI.2
 * JD-Core Version:    0.7.0.1
 */