package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class e$4
  implements bn.a
{
  e$4(String paramString, e.b paramb) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(72984);
    if ((parame == null) || (parame.aBZ() == null))
    {
      AppMethodBeat.o(72984);
      return;
    }
    if (bs.isNullOrNil(this.val$key))
    {
      ac.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
      AppMethodBeat.o(72984);
      return;
    }
    try
    {
      parame = parame.aBZ().An(this.val$key);
      if (this.JGV == null) {
        break label145;
      }
      if (parame != null)
      {
        this.JGV.dn(e.cA(parame));
        AppMethodBeat.o(72984);
        return;
      }
    }
    catch (Exception parame)
    {
      ac.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { parame.toString() });
      if (this.JGV != null) {
        this.JGV.dn(null);
      }
      AppMethodBeat.o(72984);
      return;
    }
    this.JGV.dn(null);
    label145:
    AppMethodBeat.o(72984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.4
 * JD-Core Version:    0.7.0.1
 */