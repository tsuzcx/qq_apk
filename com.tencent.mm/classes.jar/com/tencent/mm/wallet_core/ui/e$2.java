package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements bi.a
{
  e$2(e.c[] paramArrayOfc) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    if ((parame == null) || (parame.KR() == null)) {}
    for (;;)
    {
      return;
      if ((this.wCs == null) || (this.wCs.length == 0))
      {
        y.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
        return;
      }
      try
      {
        e.c[] arrayOfc = this.wCs;
        int j = arrayOfc.length;
        int i = 0;
        while (i < j)
        {
          e.c localc = arrayOfc[i];
          if ((localc != null) && (!bk.bl(localc.key))) {
            parame.KR().i(localc.key, e.cm(localc.uhK));
          }
          i += 1;
        }
        return;
      }
      catch (Exception parame)
      {
        y.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[] { parame.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.2
 * JD-Core Version:    0.7.0.1
 */