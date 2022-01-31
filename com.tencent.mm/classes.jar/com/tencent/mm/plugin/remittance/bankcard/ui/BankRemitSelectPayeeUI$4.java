package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.b;

final class BankRemitSelectPayeeUI$4
  implements h.b
{
  BankRemitSelectPayeeUI$4(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, TransferRecordParcel paramTransferRecordParcel) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    if (((this.nxE.nvB == null) && (paramCharSequence == null)) || ((this.nxE.nvB != null) && (this.nxE.nvB.equals(paramCharSequence))))
    {
      y.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { this.nxE.nvB, paramCharSequence });
      return true;
    }
    BankRemitSelectPayeeUI.a(this.nxC, this.nxE.nvy, String.valueOf(paramCharSequence));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.4
 * JD-Core Version:    0.7.0.1
 */