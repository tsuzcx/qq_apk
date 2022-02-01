package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Filter.FilterListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

final class BankRemitBankcardInputUI$20
  implements Filter.FilterListener
{
  BankRemitBankcardInputUI$20(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onFilterComplete(int paramInt)
  {
    AppMethodBeat.i(67444);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", new Object[] { Integer.valueOf(paramInt) });
    if (BankRemitBankcardInputUI.g(this.Odx) != null)
    {
      if (paramInt > 0)
      {
        FrameLayout.LayoutParams localLayoutParams;
        if (paramInt == 1)
        {
          localLayoutParams = (FrameLayout.LayoutParams)BankRemitBankcardInputUI.g(this.Odx).getLayoutParams();
          localLayoutParams.height = a.fromDPToPix(this.Odx.getContext(), 68);
          BankRemitBankcardInputUI.g(this.Odx).setLayoutParams(localLayoutParams);
        }
        for (;;)
        {
          BankRemitBankcardInputUI.g(this.Odx).setVisibility(0);
          AppMethodBeat.o(67444);
          return;
          localLayoutParams = (FrameLayout.LayoutParams)BankRemitBankcardInputUI.g(this.Odx).getLayoutParams();
          localLayoutParams.height = a.fromDPToPix(this.Odx.getContext(), 136);
          BankRemitBankcardInputUI.g(this.Odx).setLayoutParams(localLayoutParams);
        }
      }
      if ((paramInt <= 0) && (BankRemitBankcardInputUI.g(this.Odx).getVisibility() == 0)) {
        BankRemitBankcardInputUI.g(this.Odx).setVisibility(8);
      }
    }
    AppMethodBeat.o(67444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.20
 * JD-Core Version:    0.7.0.1
 */