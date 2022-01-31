package com.tencent.mm.plugin.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Map;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(43727);
    Object localObject1 = this.poK.poJ;
    g.RJ().QQ();
    if (((b)localObject1).poF == null) {
      ((b)localObject1).poF = new com.tencent.mm.plugin.order.model.b();
    }
    localObject1 = ((b)localObject1).poF;
    Object localObject2 = this.gWF;
    if (!bo.isNullOrNil((String)localObject2))
    {
      localObject2 = br.F((String)localObject2, "sysmsg");
      if (localObject2 == null)
      {
        AppMethodBeat.o(43727);
        return;
      }
      try
      {
        localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
        if (!bo.isNullOrNil((String)localObject2))
        {
          ab.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(localObject2)));
          if (!((com.tencent.mm.plugin.order.model.b)localObject1).poZ.contains(localObject2))
          {
            ((com.tencent.mm.plugin.order.model.b)localObject1).poZ.add(localObject2);
            g.RM();
            g.RL().Ru().set(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).poZ.size()));
            ab.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).poZ.size());
            ((com.tencent.mm.plugin.order.model.b)localObject1).cao();
            b.cak().onChange();
          }
        }
        AppMethodBeat.o(43727);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WalletOrdersManager", "cmdid error");
      }
    }
    AppMethodBeat.o(43727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.2.1
 * JD-Core Version:    0.7.0.1
 */