package com.tencent.mm.plugin.wallet.model;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.na;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a;

final class p$2
  implements e.a
{
  p$2(p paramp) {}
  
  public final Intent v(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69190);
    Log.i("MicroMsg.SubCoreMMWallet", "balance fetch process end");
    paramBundle = new na();
    paramBundle.hPl.hPm = 17;
    paramBundle.hPl.resultCode = -1;
    AppMethodBeat.o(69190);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.p.2
 * JD-Core Version:    0.7.0.1
 */