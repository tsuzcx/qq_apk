package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements bi.a
{
  e$3(String paramString, e.b paramb) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    if ((parame == null) || (parame.KR() == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (bk.bl(this.doz))
        {
          y.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
          return;
        }
        try
        {
          parame = parame.KR().ks(this.doz);
          if (this.wCt != null)
          {
            if (parame == null) {
              break label110;
            }
            this.wCt.bG(e.bJ(parame));
            return;
          }
        }
        catch (Exception parame)
        {
          y.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { parame.toString() });
        }
      }
    } while (this.wCt == null);
    this.wCt.bG(null);
    return;
    label110:
    this.wCt.bG(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.3
 * JD-Core Version:    0.7.0.1
 */