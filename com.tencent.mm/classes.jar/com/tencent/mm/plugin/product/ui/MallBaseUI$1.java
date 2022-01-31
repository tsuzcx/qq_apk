package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallBaseUI$1(MallBaseUI paramMallBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44026);
    this.pvq.finish();
    AppMethodBeat.o(44026);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallBaseUI.1
 * JD-Core Version:    0.7.0.1
 */