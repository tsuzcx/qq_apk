package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.i;

final class RemittanceBusiUI$14
  implements DialogInterface.OnClickListener
{
  RemittanceBusiUI$14(RemittanceBusiUI paramRemittanceBusiUI, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!RemittanceBusiUI.a(this.nCA, this.nCE))
    {
      RemittanceBusiUI.b(this.nCA, this.nCE);
      return;
    }
    RemittanceBusiUI.F(this.nCA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.14
 * JD-Core Version:    0.7.0.1
 */