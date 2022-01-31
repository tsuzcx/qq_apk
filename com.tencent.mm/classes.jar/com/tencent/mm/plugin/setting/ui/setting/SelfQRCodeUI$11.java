package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.e;
import com.tencent.mm.bq.d;
import com.tencent.mm.r.a;
import com.tencent.mm.ui.base.n.d;

final class SelfQRCodeUI$11
  implements n.d
{
  SelfQRCodeUI$11(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(154171);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154171);
      return;
      SelfQRCodeUI.f(this.qGz);
      AppMethodBeat.o(154171);
      return;
      SelfQRCodeUI.a(this.qGz, 0);
      AppMethodBeat.o(154171);
      return;
      if (!a.bN(this.qGz.getContext()))
      {
        this.qGz.getContext();
        if (!e.alb())
        {
          d.H(this.qGz.getContext(), "scanner", ".ui.BaseScanUI");
          AppMethodBeat.o(154171);
          return;
          SelfQRCodeUI.g(this.qGz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.11
 * JD-Core Version:    0.7.0.1
 */