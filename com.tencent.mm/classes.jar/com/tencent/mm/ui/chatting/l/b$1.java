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

final class b$1
  implements b.b
{
  b$1(b paramb, long paramLong1, long paramLong2, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    AppMethodBeat.i(32687);
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.zQc.ejr + " fromCreateTime:" + this.zQa + " toCreateTime:" + this.zQb + " addSize:" + paramList.size());
      long l = this.zQb;
      if (paramList.size() <= 18) {
        l = this.zQc.oP(((bi)paramList.get(paramList.size() - 1)).field_createTime);
      }
      this.zQc.Js = ((j)g.E(j.class)).bPQ().d(this.zQc.ejr, this.zQa, l, 36);
      this.zOs.next();
      AppMethodBeat.o(32687);
      return;
    }
    this.zQc.d(this.zOs);
    AppMethodBeat.o(32687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b.1
 * JD-Core Version:    0.7.0.1
 */