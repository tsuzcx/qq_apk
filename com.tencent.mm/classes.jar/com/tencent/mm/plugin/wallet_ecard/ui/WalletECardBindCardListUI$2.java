package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.d.g;

final class WalletECardBindCardListUI$2
  implements c.a
{
  WalletECardBindCardListUI$2(WalletECardBindCardListUI paramWalletECardBindCardListUI) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramInt), paramBundle });
    if (paramInt == -1)
    {
      BindCardOrder localBindCardOrder = (BindCardOrder)paramBundle.getParcelable("key_bindcard_value_result");
      if (localBindCardOrder != null)
      {
        fv localfv = new fv();
        localfv.mOb = paramBundle.getString("key_bind_card_type");
        localfv.szT = localBindCardOrder.quo;
        localfv.qqU = paramBundle.getString("key_mobile");
        if ((!bk.bl(localfv.szT)) && (!bk.bl(localfv.mOb)) && (!bk.bl(localfv.qqU)))
        {
          this.qKH.cNk().m(new Object[] { localfv });
          return null;
        }
      }
    }
    WalletECardBindCardListUI.d(this.qKH);
    WalletECardBindCardListUI.e(this.qKH);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.2
 * JD-Core Version:    0.7.0.1
 */