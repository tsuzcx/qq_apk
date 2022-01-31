package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.scanner.a.m;

final class p$7$1
  implements DialogInterface.OnClickListener
{
  p$7$1(p.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.nMz.nMw.nMm = false;
    this.nMz.nMw.nMn = false;
    m.nHb.reset();
    m.nHb.wO(m.nGY);
    if (this.nMz.nMw.nLB != null)
    {
      this.nMz.nMw.nLB.ix(false);
      this.nMz.nMw.nLB.fC(this.nMz.nMw.nLO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.7.1
 * JD-Core Version:    0.7.0.1
 */