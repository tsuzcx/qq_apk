package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.a;

final class WalletLqtPlanAddUI$10
  implements c.a
{
  WalletLqtPlanAddUI$10(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final Intent p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(45568);
    ab.i("MicroMsg.WalletLqtPlanAddUI", "bind card finish: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == -1)
    {
      paramBundle = (BindCardOrder)paramBundle.getParcelable("key_bindcard_value_result");
      if (paramBundle != null)
      {
        ab.i("MicroMsg.WalletLqtPlanAddUI", "bind card serial: %s", new Object[] { paramBundle.ugI });
        paramBundle = WalletLqtPlanAddUI.a(this.tQA, paramBundle.ugI);
        if (paramBundle != null)
        {
          WalletLqtPlanAddUI.j(this.tQA).wpe = paramBundle.field_bindSerial;
          WalletLqtPlanAddUI.j(this.tQA).poq = paramBundle.field_bankcardType;
          WalletLqtPlanAddUI.j(this.tQA).nLq = paramBundle.field_bankName;
          WalletLqtPlanAddUI.j(this.tQA).ppo = paramBundle.field_bankcardTail;
          WalletLqtPlanAddUI.k(this.tQA);
        }
      }
      WalletLqtPlanAddUI.p(this.tQA);
    }
    AppMethodBeat.o(45568);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.10
 * JD-Core Version:    0.7.0.1
 */