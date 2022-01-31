package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class p$7
  implements View.OnClickListener
{
  p$7(p paramp, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47564);
    if (this.uti != null) {
      this.uti.onCancel(null);
    }
    if (this.utf.usO != null) {
      this.utf.usO.bYU();
    }
    this.utf.cancel();
    if (this.utf.usT.isShown())
    {
      h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(47564);
      return;
    }
    h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(47564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.7
 * JD-Core Version:    0.7.0.1
 */