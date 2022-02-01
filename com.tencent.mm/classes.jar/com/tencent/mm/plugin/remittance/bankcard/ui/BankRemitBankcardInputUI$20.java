package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.support.v7.widget.ListPopupWindow;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

final class BankRemitBankcardInputUI$20
  implements Filter.FilterListener
{
  BankRemitBankcardInputUI$20(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onFilterComplete(int paramInt)
  {
    AppMethodBeat.i(67444);
    ac.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", new Object[] { Integer.valueOf(paramInt) });
    if (BankRemitBankcardInputUI.f(this.wFD) != null)
    {
      if (paramInt > 0)
      {
        if (paramInt == 1) {
          BankRemitBankcardInputUI.f(this.wFD).setHeight(a.fromDPToPix(this.wFD.getContext(), 68));
        }
        for (;;)
        {
          BankRemitBankcardInputUI.f(this.wFD).show();
          AppMethodBeat.o(67444);
          return;
          BankRemitBankcardInputUI.f(this.wFD).setHeight(a.fromDPToPix(this.wFD.getContext(), 136));
        }
      }
      if ((paramInt <= 0) && (BankRemitBankcardInputUI.f(this.wFD).apw.isShowing())) {
        BankRemitBankcardInputUI.f(this.wFD).dismiss();
      }
    }
    AppMethodBeat.o(67444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.20
 * JD-Core Version:    0.7.0.1
 */