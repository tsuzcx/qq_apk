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
    AppMethodBeat.i(24809);
    ShakeReportUI.a(this.qRs, false);
    this.qRs.finish();
    AppMethodBeat.o(24809);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.27
 * JD-Core Version:    0.7.0.1
 */