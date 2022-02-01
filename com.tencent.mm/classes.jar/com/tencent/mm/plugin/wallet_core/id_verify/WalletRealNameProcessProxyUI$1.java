package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d.a;

final class WalletRealNameProcessProxyUI$1
  implements d.a
{
  WalletRealNameProcessProxyUI$1(WalletRealNameProcessProxyUI paramWalletRealNameProcessProxyUI) {}
  
  public final Intent q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(70040);
    Log.i("MicroMsg.WalletRealNameProcessProxyUI", "realname end: %s", new Object[] { Integer.valueOf(paramInt) });
    paramBundle = new Intent();
    AppMethodBeat.o(70040);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI.1
 * JD-Core Version:    0.7.0.1
 */