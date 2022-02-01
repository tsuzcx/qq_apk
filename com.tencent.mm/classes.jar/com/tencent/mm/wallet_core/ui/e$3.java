package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class e$3
  implements bn.a
{
  e$3(e.c[] paramArrayOfc) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(72983);
    if ((parame == null) || (parame.aBZ() == null))
    {
      AppMethodBeat.o(72983);
      return;
    }
    if ((this.JGU == null) || (this.JGU.length == 0))
    {
      ac.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
      AppMethodBeat.o(72983);
      return;
    }
    try
    {
      e.c[] arrayOfc = this.JGU;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        e.c localc = arrayOfc[i];
        if ((localc != null) && (!bs.isNullOrNil(localc.key))) {
          parame.aBZ().i(localc.key, e.en(localc.bVw));
        }
        i += 1;
      }
      AppMethodBeat.o(72983);
      return;
    }
    catch (Exception parame)
    {
      ac.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { parame.toString() });
      AppMethodBeat.o(72983);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.3
 * JD-Core Version:    0.7.0.1
 */