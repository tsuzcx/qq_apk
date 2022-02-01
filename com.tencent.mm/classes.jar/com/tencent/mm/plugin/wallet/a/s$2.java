package com.tencent.mm.plugin.wallet.a;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.d.a;

final class s$2
  implements d.a
{
  s$2(s params) {}
  
  public final Intent s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69190);
    ae.i("MicroMsg.SubCoreMMWallet", "balance fetch process end");
    paramBundle = new ko();
    paramBundle.dyC.requestCode = 17;
    paramBundle.dyC.bZU = -1;
    AppMethodBeat.o(69190);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s.2
 * JD-Core Version:    0.7.0.1
 */