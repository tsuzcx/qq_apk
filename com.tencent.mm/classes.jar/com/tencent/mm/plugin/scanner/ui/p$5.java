package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.g;

final class p$5
  implements DialogInterface.OnCancelListener
{
  p$5(p paramp, g paramg) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.nMx);
    this.nMw.nLB.ix(false);
    this.nMw.nMm = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.5
 * JD-Core Version:    0.7.0.1
 */