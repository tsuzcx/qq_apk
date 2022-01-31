package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class e$5
  implements bk.a
{
  e$5(String[] paramArrayOfString, e.a parama) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(49260);
    if ((parame == null) || (parame.adI() == null))
    {
      AppMethodBeat.o(49260);
      return;
    }
    if ((this.AYH == null) || (this.AYH.length == 0))
    {
      ab.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
      AppMethodBeat.o(49260);
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.AYH.length)
        {
          String str = this.AYH[i];
          if (!bo.isNullOrNil(str))
          {
            byte[] arrayOfByte = parame.adI().rm(str);
            if (arrayOfByte != null) {
              localHashMap.put(str, e.cj(arrayOfByte));
            }
          }
          else
          {
            ab.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
          }
        }
      }
      catch (Exception parame)
      {
        ab.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { parame.toString() });
        if (this.AYI != null) {
          this.AYI.al(null);
        }
        AppMethodBeat.o(49260);
        return;
      }
      if (this.AYI != null) {
        this.AYI.al(localHashMap);
      }
      AppMethodBeat.o(49260);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.5
 * JD-Core Version:    0.7.0.1
 */