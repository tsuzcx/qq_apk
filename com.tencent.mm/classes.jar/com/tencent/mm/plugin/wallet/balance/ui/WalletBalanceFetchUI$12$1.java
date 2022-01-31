package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class WalletBalanceFetchUI$12$1
  implements n.d
{
  WalletBalanceFetchUI$12$1(WalletBalanceFetchUI.12 param12, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(45366);
    if (paramInt < this.tOp.size())
    {
      WalletBalanceFetchUI.a(this.tOq.tOj, (Bankcard)this.tOp.get(paramInt));
      WalletBalanceFetchUI.c(this.tOq.tOj);
      ab.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(this.tOq.tOj).field_desc });
      localh = h.qsU;
      str2 = WalletBalanceFetchUI.d(this.tOq.tOj);
      if (WalletBalanceFetchUI.b(this.tOq.tOj) != null)
      {
        paramMenuItem = WalletBalanceFetchUI.b(this.tOq.tOj).field_bankcardType;
        if (WalletBalanceFetchUI.b(this.tOq.tOj) == null) {
          break label207;
        }
      }
      label207:
      for (str1 = WalletBalanceFetchUI.b(this.tOq.tOj).field_bindSerial;; str1 = "")
      {
        localh.e(16398, new Object[] { str2, Integer.valueOf(2), paramMenuItem, str1 });
        WalletBalanceFetchUI.f(this.tOq.tOj);
        WalletBalanceFetchUI.cRc();
        AppMethodBeat.o(45366);
        return;
        paramMenuItem = "";
        break;
      }
    }
    ab.i("MicroMsg.WalletBalanceFetchUI", "add new card");
    WalletBalanceFetchUI.e(this.tOq.tOj);
    h localh = h.qsU;
    String str2 = WalletBalanceFetchUI.d(this.tOq.tOj);
    if (WalletBalanceFetchUI.b(this.tOq.tOj) != null)
    {
      paramMenuItem = WalletBalanceFetchUI.b(this.tOq.tOj).field_bankcardType;
      label274:
      if (WalletBalanceFetchUI.b(this.tOq.tOj) == null) {
        break label343;
      }
    }
    label343:
    for (String str1 = WalletBalanceFetchUI.b(this.tOq.tOj).field_bindSerial;; str1 = "")
    {
      localh.e(16398, new Object[] { str2, Integer.valueOf(9), paramMenuItem, str1 });
      break;
      paramMenuItem = "";
      break label274;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.12.1
 * JD-Core Version:    0.7.0.1
 */