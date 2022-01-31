package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.y;
import java.util.Map;

final class p$a
  implements bz.a
{
  p$a(p paramp) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(54089);
    Object localObject1 = p.bTI();
    String str = aa.a(parama.eyJ.woR);
    Object localObject2 = br.F(str, "sysmsg");
    if ((String)((Map)localObject2).get(".sysmsg.multivoip.notfriendnotifydata") != null)
    {
      ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
      AppMethodBeat.o(54089);
      return;
    }
    str = (String)((Map)localObject2).get(".sysmsg.multivoip.notifydata");
    if (str != null)
    {
      localObject1 = Base64.decode(bo.bf(str, "").getBytes(), 0);
      ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + aa.a(parama.eyJ.woR) + " buffer len " + localObject1.length);
      p.bTE().oTa.bQ(bo.g((Integer)com.tencent.mm.kernel.g.RL().eHM.get(1)), r.Zn());
      p.bTE().oTa.cn((byte[])localObject1);
      AppMethodBeat.o(54089);
      return;
    }
    localObject2 = (String)((Map)localObject2).get(".sysmsg.multivoip.banner");
    if (localObject2 != null) {
      ((g)localObject1).a((String)localObject2, parama);
    }
    AppMethodBeat.o(54089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p.a
 * JD-Core Version:    0.7.0.1
 */