package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h.c;

final class WalletBankcardDetailUI$8
  implements h.c
{
  WalletBankcardDetailUI$8(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.qjV.getString(a.i.wallet_bankcard_detail_bankphone_number)));
    localIntent.addFlags(268435456);
    this.qjV.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.8
 * JD-Core Version:    0.7.0.1
 */