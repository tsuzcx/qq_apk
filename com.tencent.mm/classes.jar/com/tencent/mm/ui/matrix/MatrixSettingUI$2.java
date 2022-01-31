package com.tencent.mm.ui.matrix;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MatrixSettingUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MatrixSettingUI$2(MatrixSettingUI paramMatrixSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(156162);
    paramMenuItem = new Intent(this.Apu, MatrixReportUI.class);
    paramMenuItem.addFlags(67108864);
    this.Apu.startActivity(paramMenuItem);
    AppMethodBeat.o(156162);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI.2
 * JD-Core Version:    0.7.0.1
 */