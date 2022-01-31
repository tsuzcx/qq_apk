package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.d.g;

final class WalletECardBindCardListUI$2
  implements c.a
{
  WalletECardBindCardListUI$2(WalletECardBindCardListUI paramWalletECardBindCardListUI) {}
  
  public final Intent p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48116);
    ab.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramInt), paramBundle });
    if (paramInt == -1)
    {
      BindCardOrder localBindCardOrder = (BindCardOrder)paramBundle.getParcelable("key_bindcard_value_result");
      if (localBindCardOrder != null)
      {
        hg localhg = new hg();
        localhg.poq = paramBundle.getString("key_bind_card_type");
        localhg.wtV = localBindCardOrder.ugI;
        localhg.ubQ = paramBundle.getString("key_mobile");
        if ((!bo.isNullOrNil(localhg.wtV)) && (!bo.isNullOrNil(localhg.poq)) && (!bo.isNullOrNil(localhg.ubQ)))
        {
          this.uzF.getNetController().p(new Object[] { localhg });
          AppMethodBeat.o(48116);
          return null;
        }
      }
      WalletECardBindCardListUI.c(this.uzF);
    }
    WalletECardBindCardListUI.d(this.uzF);
    AppMethodBeat.o(48116);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.2
 * JD-Core Version:    0.7.0.1
 */