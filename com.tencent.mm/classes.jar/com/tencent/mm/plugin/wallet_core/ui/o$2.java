package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;

final class o$2
  implements View.OnClickListener
{
  o$2(o paramo, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public final void onClick(View paramView)
  {
    if (this.qGd != null) {
      this.qGd.onCancel(null);
    }
    if (this.qGj.qGg != null) {
      this.qGj.qGg.bqo();
    }
    this.qGj.cancel();
    if (this.qGj.qFN.isShown())
    {
      h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
    h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o.2
 * JD-Core Version:    0.7.0.1
 */