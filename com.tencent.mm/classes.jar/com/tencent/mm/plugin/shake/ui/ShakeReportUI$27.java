package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$27
  implements MenuItem.OnMenuItemClickListener
{
  ShakeReportUI$27(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(28478);
    ShakeReportUI.a(this.Dlj, false);
    this.Dlj.finish();
    AppMethodBeat.o(28478);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.27
 * JD-Core Version:    0.7.0.1
 */