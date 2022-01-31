package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

final class p$a
  implements bx.a
{
  p$a(p paramp) {}
  
  public final void a(e.a parama)
  {
    Object localObject1 = p.blI();
    String str = aa.a(parama.dBs.svH);
    Object localObject2 = bn.s(str, "sysmsg");
    if ((String)((Map)localObject2).get(".sysmsg.multivoip.notfriendnotifydata") != null) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + str);
    }
    do
    {
      return;
      str = (String)((Map)localObject2).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(bk.aM(str, "").getBytes(), 0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + aa.a(parama.dBs.svH) + " buffer len " + localObject1.length);
        p.blE().mtp.bk(bk.g((Integer)com.tencent.mm.kernel.g.DP().dKo.get(1)), q.Gj());
        p.blE().mtp.bN((byte[])localObject1);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".sysmsg.multivoip.banner");
    } while (localObject2 == null);
    ((g)localObject1).a((String)localObject2, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.p.a
 * JD-Core Version:    0.7.0.1
 */