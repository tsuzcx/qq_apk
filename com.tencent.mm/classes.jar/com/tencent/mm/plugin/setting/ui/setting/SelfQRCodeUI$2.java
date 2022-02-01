package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.br.c;
import com.tencent.mm.q.a;
import com.tencent.mm.ui.base.o.g;

final class SelfQRCodeUI$2
  implements o.g
{
  SelfQRCodeUI$2(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(256475);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(256475);
      return;
      SelfQRCodeUI.g(this.CZE);
      AppMethodBeat.o(256475);
      return;
      SelfQRCodeUI.a(this.CZE, 0);
      AppMethodBeat.o(256475);
      return;
      if (!a.o(this.CZE.getContext(), true))
      {
        this.CZE.getContext();
        if ((!e.bgF()) && (!a.r(this.CZE.getContext(), true)))
        {
          c.V(this.CZE.getContext(), "scanner", ".ui.BaseScanUI");
          AppMethodBeat.o(256475);
          return;
          SelfQRCodeUI.h(this.CZE);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */