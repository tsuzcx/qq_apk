package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

final class WalletOfflineCoinPurseUI$16
  implements h.c
{
  WalletOfflineCoinPurseUI$16(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a.dW(this.mNj);
      return;
    }
    c localc = WalletOfflineCoinPurseUI.A(this.mNj);
    if (!((b)g.r(b.class)).bXM())
    {
      h.a(localc.mActivity, localc.getString(a.i.wallet_wx_offline_close_tips_no_wallet_lock), "", localc.getString(a.i.wallet_wx_offline_start_wallet_lock), localc.getString(a.i.wallet_wx_offline_close_btn_text), new c.7(localc), new c.8(localc));
      return;
    }
    h.a(localc.mActivity, localc.getString(a.i.wallet_wx_offline_close_tips), "", localc.getString(a.i.wallet_wx_offline_close_btn_text), localc.getString(a.i.app_cancel), new c.9(localc), new c.10(localc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.16
 * JD-Core Version:    0.7.0.1
 */