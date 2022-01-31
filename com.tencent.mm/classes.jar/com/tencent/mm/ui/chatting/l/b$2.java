package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

final class b$2
  implements b.b
{
  b$2(b paramb, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    AppMethodBeat.i(32688);
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      long l1 = this.zQc.dLh();
      long l2 = this.zQc.dLk();
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + this.zQc.ejr + " from:" + l1 + " to:" + l2);
      this.zQc.Js = ((j)g.E(j.class)).bPQ().d(this.zQc.ejr, l1, l2, 18);
      this.zOs.next();
      AppMethodBeat.o(32688);
      return;
    }
    this.zQc.d(this.zOs);
    AppMethodBeat.o(32688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b.2
 * JD-Core Version:    0.7.0.1
 */