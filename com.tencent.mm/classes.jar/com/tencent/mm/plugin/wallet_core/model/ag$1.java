package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e.b;

final class ag$1
  implements e.b
{
  ag$1(ag paramag) {}
  
  public final void bG(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Double)))
    {
      if (((Double)paramObject).doubleValue() < 0.0D) {
        y.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[] { bk.csb().toString() });
      }
      if (this.qzr.qhj != null) {
        this.qzr.qhj.qty = ((Double)paramObject).doubleValue();
      }
    }
    do
    {
      return;
      y.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
    } while (this.qzr.qhj == null);
    this.qzr.qhj.qty = -1.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag.1
 * JD-Core Version:    0.7.0.1
 */