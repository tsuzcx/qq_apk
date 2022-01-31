package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;

final class WalletOfflineCoinPurseUI$11
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$11(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43516);
    d.H(this.pny.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
    if (c.PJ().b(ac.a.yIE, ac.a.yHA))
    {
      c.PJ().c(ac.a.yIE, ac.a.yHA);
      this.pnM.setVisibility(8);
    }
    AppMethodBeat.o(43516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.11
 * JD-Core Version:    0.7.0.1
 */