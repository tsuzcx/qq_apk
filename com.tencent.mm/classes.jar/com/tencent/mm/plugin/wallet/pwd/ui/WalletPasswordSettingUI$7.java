package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.a;

final class WalletPasswordSettingUI$7
  implements c.a
{
  WalletPasswordSettingUI$7(WalletPasswordSettingUI paramWalletPasswordSettingUI) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
    paramBundle = new tk();
    if (paramInt == -1) {
      paramBundle.ccZ.scene = 17;
    }
    for (;;)
    {
      paramBundle.cda.ccT = new WalletPasswordSettingUI.7.1(this);
      a.udP.m(paramBundle);
      return null;
      if (paramInt == 0) {
        paramBundle.ccZ.scene = 18;
      } else {
        paramBundle.ccZ.scene = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.7
 * JD-Core Version:    0.7.0.1
 */