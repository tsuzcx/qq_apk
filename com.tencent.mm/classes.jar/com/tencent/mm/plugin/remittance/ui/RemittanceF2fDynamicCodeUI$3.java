package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceF2fDynamicCodeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceF2fDynamicCodeUI$3(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68182);
    if (RemittanceF2fDynamicCodeUI.c(this.yfD))
    {
      this.yfD.hideVKB();
      this.yfD.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(68182);
      return true;
      this.yfD.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
      this.yfD.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.3
 * JD-Core Version:    0.7.0.1
 */