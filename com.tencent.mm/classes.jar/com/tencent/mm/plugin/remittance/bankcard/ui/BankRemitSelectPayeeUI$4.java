package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.b;

final class BankRemitSelectPayeeUI$4
  implements h.b
{
  BankRemitSelectPayeeUI$4(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, TransferRecordParcel paramTransferRecordParcel) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(44674);
    if (((this.qiF.qgx == null) && (paramCharSequence == null)) || ((this.qiF.qgx != null) && (this.qiF.qgx.equals(paramCharSequence))))
    {
      ab.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { this.qiF.qgx, paramCharSequence });
      AppMethodBeat.o(44674);
      return true;
    }
    BankRemitSelectPayeeUI.a(this.qiD, this.qiF.qgu, String.valueOf(paramCharSequence));
    AppMethodBeat.o(44674);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.4
 * JD-Core Version:    0.7.0.1
 */