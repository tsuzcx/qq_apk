package com.tencent.mm.ui.matrix;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ManualDumpActivity$1
  implements MenuItem.OnMenuItemClickListener
{
  ManualDumpActivity$1(ManualDumpActivity paramManualDumpActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38863);
    this.KXO.finish();
    AppMethodBeat.o(38863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity.1
 * JD-Core Version:    0.7.0.1
 */