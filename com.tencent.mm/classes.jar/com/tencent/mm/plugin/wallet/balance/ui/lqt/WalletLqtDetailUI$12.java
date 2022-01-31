package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.y;
import java.io.IOException;

final class WalletLqtDetailUI$12
  implements com.tencent.mm.vending.c.a<Void, bpw>
{
  WalletLqtDetailUI$12(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  private Void a(bpw parambpw)
  {
    AppMethodBeat.i(142296);
    if (parambpw != null)
    {
      ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(parambpw.wMx), Boolean.valueOf(parambpw.xEa) });
      WalletLqtDetailUI.a(this.tPQ, parambpw);
      WalletLqtDetailUI.b(this.tPQ);
      WalletLqtDetailUI.c(this.tPQ);
      parambpw = WalletLqtDetailUI.d(this.tPQ);
      parambpw.tPY = true;
      WalletLqtDetailUI.k(parambpw.tPQ).setVisibility(0);
      WalletLqtDetailUI.l(parambpw.tPQ).setVisibility(8);
      if (WalletLqtDetailUI.e(this.tPQ) == null) {}
    }
    for (;;)
    {
      try
      {
        parambpw = new String(WalletLqtDetailUI.e(this.tPQ).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        ((com.tencent.mm.plugin.wxpay.a.a)g.G(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ac.a.yJs, parambpw);
        if (WalletLqtDetailUI.a(this.tPQ) != null) {
          WalletLqtDetailUI.a(this.tPQ).dismiss();
        }
        parambpw = AOo;
        AppMethodBeat.o(142296);
        return parambpw;
      }
      catch (IOException parambpw)
      {
        ab.printErrStackTrace("MicroMsg.WalletLqtDetailUI", parambpw, "", new Object[0]);
        continue;
      }
      ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.12
 * JD-Core Version:    0.7.0.1
 */