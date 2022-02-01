package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.e;
import com.tencent.mm.br.c;
import com.tencent.mm.n.a;
import com.tencent.mm.ui.base.u.i;

final class SelfQRCodeUI$2
  implements u.i
{
  SelfQRCodeUI$2(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(299208);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(299208);
      return;
      SelfQRCodeUI.d(this.PpF);
      AppMethodBeat.o(299208);
      return;
      SelfQRCodeUI.a(this.PpF, 0);
      AppMethodBeat.o(299208);
      return;
      if (!a.p(this.PpF.getContext(), true))
      {
        this.PpF.getContext();
        if ((!e.bNA()) && (!a.u(this.PpF.getContext(), true)))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("key_scan_report_enter_scene", 4);
          c.b(this.PpF.getContext(), "scanner", ".ui.BaseScanUI", paramMenuItem);
          AppMethodBeat.o(299208);
          return;
          SelfQRCodeUI.h(this.PpF);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */