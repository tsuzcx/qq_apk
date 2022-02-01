package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

final class e$6
  implements bn.a
{
  e$6(String[] paramArrayOfString, e.a parama) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(72986);
    if ((parame == null) || (parame.aBZ() == null))
    {
      AppMethodBeat.o(72986);
      return;
    }
    if ((this.JGW == null) || (this.JGW.length == 0))
    {
      ac.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
      AppMethodBeat.o(72986);
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.JGW.length)
        {
          String str = this.JGW[i];
          if (!bs.isNullOrNil(str))
          {
            byte[] arrayOfByte = parame.aBZ().An(str);
            if (arrayOfByte != null) {
              localHashMap.put(str, e.cA(arrayOfByte));
            }
          }
          else
          {
            ac.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
          }
        }
      }
      catch (Exception parame)
      {
        ac.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[] { parame.toString() });
        if (this.JGX != null) {
          this.JGX.aT(null);
        }
        AppMethodBeat.o(72986);
        return;
      }
      if (this.JGX != null) {
        this.JGX.aT(localHashMap);
      }
      AppMethodBeat.o(72986);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.6
 * JD-Core Version:    0.7.0.1
 */