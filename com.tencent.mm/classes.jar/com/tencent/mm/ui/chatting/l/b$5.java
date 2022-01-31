package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

final class b$5
  implements b.b
{
  b$5(b paramb, long paramLong1, com.tencent.mm.plugin.messenger.foundation.a.a.b paramb1, long paramLong2, d.b paramb2) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    AppMethodBeat.i(32691);
    long l2;
    if (paramInt >= 0)
    {
      l2 = this.zQd;
      if (paramList.size() <= 0) {
        break label276;
      }
      l2 = ((bi)paramList.get(0)).field_createTime;
    }
    label276:
    for (;;)
    {
      long l1 = l2;
      if (this.zQe.ac(this.zQc.ejr, l2) == null)
      {
        l1 = l2;
        if (paramList.size() < 18) {
          l1 = ((j)g.E(j.class)).bPQ().g(this.zQc.ejr, l2, 18 - paramList.size());
        }
      }
      l2 = l1;
      if (l1 <= 0L) {
        l2 = this.zQd;
      }
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + this.zQc.ejr + " firstCreateTime:" + this.zQd + " lastCreateTime:" + this.zQf + " from:" + l2);
      this.zQc.Js = ((j)g.E(j.class)).bPQ().d(this.zQc.ejr, l2, this.zQc.zPV, this.zQc.zPX + 18);
      this.zOs.next();
      AppMethodBeat.o(32691);
      return;
      this.zQc.d(this.zOs);
      AppMethodBeat.o(32691);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b.5
 * JD-Core Version:    0.7.0.1
 */