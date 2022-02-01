package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a;

final class WalletCheckPwdUI$6
  implements e.a
{
  WalletCheckPwdUI$6(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final Intent v(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(301283);
    Log.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("token", paramBundle.getString("key_jsapi_token"));
    localIntent.putExtra("key_process_result_code", paramInt);
    localIntent.setClass(this.VOY.getContext(), WalletCheckPwdUI.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("key_process_is_stay", false);
    AppMethodBeat.o(301283);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.6
 * JD-Core Version:    0.7.0.1
 */