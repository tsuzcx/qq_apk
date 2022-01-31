package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.sdk.platformtools.y;

final class RemittanceBaseUI$11
  implements b.a
{
  RemittanceBaseUI$11(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void LQ(String paramString)
  {
    y.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramString });
    this.nAH.nAv = paramString;
    this.nAH.bwy();
  }
  
  public final void onCancel()
  {
    this.nAH.nAv = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.11
 * JD-Core Version:    0.7.0.1
 */