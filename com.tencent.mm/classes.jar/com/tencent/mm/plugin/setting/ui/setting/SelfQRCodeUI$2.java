package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.s.a;
import com.tencent.mm.ui.base.n.e;

final class SelfQRCodeUI$2
  implements n.e
{
  SelfQRCodeUI$2(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(220945);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220945);
      return;
      SelfQRCodeUI.g(this.yEJ);
      AppMethodBeat.o(220945);
      return;
      SelfQRCodeUI.a(this.yEJ, 0);
      AppMethodBeat.o(220945);
      return;
      if (!a.n(this.yEJ.getContext(), true))
      {
        this.yEJ.getContext();
        if ((!e.aMh()) && (!a.p(this.yEJ.getContext(), true)))
        {
          d.Q(this.yEJ.getContext(), "scanner", ".ui.BaseScanUI");
          AppMethodBeat.o(220945);
          return;
          SelfQRCodeUI.h(this.yEJ);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */