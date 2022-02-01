package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.br.d;
import com.tencent.mm.r.a;
import com.tencent.mm.ui.base.n.e;

final class SelfQRCodeUI$2
  implements n.e
{
  SelfQRCodeUI$2(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(190307);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190307);
      return;
      SelfQRCodeUI.g(this.yUO);
      AppMethodBeat.o(190307);
      return;
      SelfQRCodeUI.a(this.yUO, 0);
      AppMethodBeat.o(190307);
      return;
      if (!a.n(this.yUO.getContext(), true))
      {
        this.yUO.getContext();
        if ((!e.aME()) && (!a.p(this.yUO.getContext(), true)))
        {
          d.Q(this.yUO.getContext(), "scanner", ".ui.BaseScanUI");
          AppMethodBeat.o(190307);
          return;
          SelfQRCodeUI.h(this.yUO);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */