package com.tencent.mm.plugin.wallet.a;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.d.a;

final class s$2
  implements d.a
{
  s$2(s params) {}
  
  public final Intent q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69190);
    ad.i("MicroMsg.SubCoreMMWallet", "balance fetch process end");
    paramBundle = new jx();
    paramBundle.dob.requestCode = 17;
    paramBundle.dob.bRZ = -1;
    AppMethodBeat.o(69190);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s.2
 * JD-Core Version:    0.7.0.1
 */