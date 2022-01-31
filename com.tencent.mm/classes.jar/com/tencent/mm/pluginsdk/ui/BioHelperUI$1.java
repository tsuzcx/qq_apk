package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BioHelperUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BioHelperUI$1(BioHelperUI paramBioHelperUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125667);
    this.vPZ.finish();
    AppMethodBeat.o(125667);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI.1
 * JD-Core Version:    0.7.0.1
 */