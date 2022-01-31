package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class BaseScanUI$12$1
  implements Runnable
{
  BaseScanUI$12$1(BaseScanUI.12 param12, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138467);
    if ((g.Rc().adt() == 6) || (g.Rc().adt() == 4))
    {
      if (BaseScanUI.c(this.qwL.qwI))
      {
        AppMethodBeat.o(138467);
        return;
      }
      if ((BaseScanUI.d(this.qwL.qwI) != null) && (BaseScanUI.e(this.qwL.qwI) != null))
      {
        BaseScanUI.d(this.qwL.qwI).setVisibility(8);
        BaseScanUI.e(this.qwL.qwI).setVisibility(8);
      }
      BaseScanUI.f(this.qwL.qwI);
      BaseScanUI.a(this.qwL.qwI, false);
      BaseScanUI.g(this.qwL.qwI);
    }
    for (;;)
    {
      if (BaseScanUI.i(this.qwL.qwI) != null) {
        BaseScanUI.i(this.qwL.qwI).cil();
      }
      AppMethodBeat.o(138467);
      return;
      BaseScanUI.h(this.qwL.qwI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.12.1
 * JD-Core Version:    0.7.0.1
 */