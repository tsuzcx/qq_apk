package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$3
  implements bk.a
{
  e$3(String paramString, e.b paramb) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(49258);
    if ((parame == null) || (parame.adI() == null))
    {
      AppMethodBeat.o(49258);
      return;
    }
    if (bo.isNullOrNil(this.val$key))
    {
      ab.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
      AppMethodBeat.o(49258);
      return;
    }
    try
    {
      parame = parame.adI().rm(this.val$key);
      if (this.AYG == null) {
        break label145;
      }
      if (parame != null)
      {
        this.AYG.bS(e.cj(parame));
        AppMethodBeat.o(49258);
        return;
      }
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { parame.toString() });
      if (this.AYG != null) {
        this.AYG.bS(null);
      }
      AppMethodBeat.o(49258);
      return;
    }
    this.AYG.bS(null);
    label145:
    AppMethodBeat.o(49258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.3
 * JD-Core Version:    0.7.0.1
 */