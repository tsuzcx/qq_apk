package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$2
  implements bk.a
{
  e$2(e.c[] paramArrayOfc) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(49257);
    if ((parame == null) || (parame.adI() == null))
    {
      AppMethodBeat.o(49257);
      return;
    }
    if ((this.AYF == null) || (this.AYF.length == 0))
    {
      ab.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
      AppMethodBeat.o(49257);
      return;
    }
    try
    {
      e.c[] arrayOfc = this.AYF;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        e.c localc = arrayOfc[i];
        if ((localc != null) && (!bo.isNullOrNil(localc.key))) {
          parame.adI().o(localc.key, e.cS(localc.ypP));
        }
        i += 1;
      }
      AppMethodBeat.o(49257);
      return;
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { parame.toString() });
      AppMethodBeat.o(49257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.2
 * JD-Core Version:    0.7.0.1
 */