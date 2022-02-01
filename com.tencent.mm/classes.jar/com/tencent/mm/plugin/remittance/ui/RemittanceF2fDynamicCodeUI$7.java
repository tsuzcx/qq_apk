package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.e;

final class RemittanceF2fDynamicCodeUI$7
  implements n.e
{
  RemittanceF2fDynamicCodeUI$7(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(68186);
    if (paramInt == 0) {
      RemittanceF2fDynamicCodeUI.a(this.yfD, 1);
    }
    AppMethodBeat.o(68186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.7
 * JD-Core Version:    0.7.0.1
 */