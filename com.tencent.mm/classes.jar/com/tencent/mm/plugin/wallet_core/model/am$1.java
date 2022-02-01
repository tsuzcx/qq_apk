package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e.b;

final class am$1
  implements e.b
{
  am$1(am paramam) {}
  
  public final void dm(Object paramObject)
  {
    AppMethodBeat.i(70493);
    if ((paramObject != null) && ((paramObject instanceof Double)))
    {
      if (((Double)paramObject).doubleValue() < 0.0D) {
        ad.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bt.eGN().toString() });
      }
      if (this.Aiw.zHd != null)
      {
        this.Aiw.zHd.AbU = ((Double)paramObject).doubleValue();
        AppMethodBeat.o(70493);
      }
    }
    else
    {
      ad.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
      if (this.Aiw.zHd != null) {
        this.Aiw.zHd.AbU = -1.0D;
      }
    }
    AppMethodBeat.o(70493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am.1
 * JD-Core Version:    0.7.0.1
 */