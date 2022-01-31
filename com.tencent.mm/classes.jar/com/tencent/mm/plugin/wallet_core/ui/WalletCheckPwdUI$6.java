package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.a;

final class WalletCheckPwdUI$6
  implements c.a
{
  WalletCheckPwdUI$6(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("token", paramBundle.getString("key_jsapi_token"));
    localIntent.putExtra("key_process_result_code", paramInt);
    localIntent.setClass(this.qDk.mController.uMN, WalletCheckPwdUI.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("key_process_is_stay", false);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.6
 * JD-Core Version:    0.7.0.1
 */