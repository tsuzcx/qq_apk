package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e.b;

final class am$1
  implements e.b
{
  am$1(am paramam) {}
  
  public final void bS(Object paramObject)
  {
    AppMethodBeat.i(46963);
    if ((paramObject != null) && ((paramObject instanceof Double)))
    {
      if (((Double)paramObject).doubleValue() < 0.0D) {
        ab.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bo.dtY().toString() });
      }
      if (this.umb.tOD != null)
      {
        this.umb.tOD.ufM = ((Double)paramObject).doubleValue();
        AppMethodBeat.o(46963);
      }
    }
    else
    {
      ab.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
      if (this.umb.tOD != null) {
        this.umb.tOD.ufM = -1.0D;
      }
    }
    AppMethodBeat.o(46963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am.1
 * JD-Core Version:    0.7.0.1
 */