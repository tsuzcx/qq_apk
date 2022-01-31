package com.tencent.mm.plugin.order.a;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Map;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, String paramString) {}
  
  public final void run()
  {
    Object localObject1 = this.mOu.mOt;
    g.DN().CX();
    if (((b)localObject1).mOp == null) {
      ((b)localObject1).mOp = new com.tencent.mm.plugin.order.model.b();
    }
    localObject1 = ((b)localObject1).mOp;
    Object localObject2 = this.fEp;
    if (!bk.bl((String)localObject2))
    {
      localObject2 = bn.s((String)localObject2, "sysmsg");
      if (localObject2 != null) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label61:
        localObject2 = (String)((Map)localObject2).get(".sysmsg.wxpay.transid");
        if (!bk.bl((String)localObject2))
        {
          y.d("MicroMsg.WalletOrdersManager", "transid " + (String)localObject2);
          if (!((com.tencent.mm.plugin.order.model.b)localObject1).mOJ.contains(localObject2))
          {
            ((com.tencent.mm.plugin.order.model.b)localObject1).mOJ.add(localObject2);
            g.DQ();
            g.DP().Dz().o(204817, Integer.valueOf(((com.tencent.mm.plugin.order.model.b)localObject1).mOJ.size()));
            y.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + ((com.tencent.mm.plugin.order.model.b)localObject1).mOJ.size());
            ((com.tencent.mm.plugin.order.model.b)localObject1).brz();
            b.brv().axs();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WalletOrdersManager", "cmdid error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.2.1
 * JD-Core Version:    0.7.0.1
 */