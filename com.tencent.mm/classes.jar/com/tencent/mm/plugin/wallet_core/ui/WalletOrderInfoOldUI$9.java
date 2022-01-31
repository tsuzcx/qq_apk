package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

final class WalletOrderInfoOldUI$9
  implements h.c
{
  WalletOrderInfoOldUI$9(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    WalletOrderInfoOldUI.a(this.qEN, false);
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.qEN.mQr));
    localIntent.addFlags(268435456);
    this.qEN.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.9
 * JD-Core Version:    0.7.0.1
 */