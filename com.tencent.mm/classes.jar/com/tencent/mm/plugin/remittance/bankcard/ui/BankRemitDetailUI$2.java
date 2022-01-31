package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BankRemitDetailUI$2
  implements View.OnClickListener
{
  BankRemitDetailUI$2(BankRemitDetailUI paramBankRemitDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44595);
    ab.i("MicroMsg.BankRemitDetailUI", "click finish btn");
    this.qhE.finish();
    AppMethodBeat.o(44595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.2
 * JD-Core Version:    0.7.0.1
 */