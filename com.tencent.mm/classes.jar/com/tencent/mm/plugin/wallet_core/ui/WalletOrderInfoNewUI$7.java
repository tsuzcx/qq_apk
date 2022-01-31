package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

final class WalletOrderInfoNewUI$7
  implements h.c
{
  WalletOrderInfoNewUI$7(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletOrderInfoNewUI.t(this.qEr)));
    localIntent.addFlags(268435456);
    this.qEr.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.7
 * JD-Core Version:    0.7.0.1
 */