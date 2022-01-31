package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;

final class n$7
  implements View.OnClickListener
{
  n$7(n paramn, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onClick(View paramView)
  {
    if (this.qGd != null) {
      this.qGd.onCancel(null);
    }
    if (this.qGa.qFI != null) {
      this.qGa.qFI.bqo();
    }
    this.qGa.cancel();
    if (this.qGa.qFN.isShown())
    {
      h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
    h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n.7
 * JD-Core Version:    0.7.0.1
 */