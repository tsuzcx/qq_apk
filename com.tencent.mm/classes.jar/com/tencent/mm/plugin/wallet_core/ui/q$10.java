package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class q$10
  implements View.OnClickListener
{
  q$10(q paramq, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47603);
    if (this.uti != null) {
      this.uti.onCancel(null);
    }
    if (this.utp.utl != null) {
      this.utp.utl.bYU();
    }
    this.utp.cancel();
    if (this.utp.usT.isShown())
    {
      h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(47603);
      return;
    }
    h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(47603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.10
 * JD-Core Version:    0.7.0.1
 */