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

final class b$4
  implements b.b
{
  b$4(b paramb, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    AppMethodBeat.i(32690);
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      long l1 = this.zQc.zPU;
      bi localbi = (bi)paramList.get(paramList.size() - 1);
      long l2 = this.zQc.oP(localbi.field_createTime);
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + this.zQc.ejr + " from:" + l1 + " to:" + l2 + " size:" + paramList.size());
      this.zQc.Js = ((j)g.E(j.class)).bPQ().d(this.zQc.ejr, l1, l2, 2147483647);
      this.zOs.next();
      AppMethodBeat.o(32690);
      return;
    }
    ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramInt)));
    this.zQc.d(this.zOs);
    AppMethodBeat.o(32690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b.4
 * JD-Core Version:    0.7.0.1
 */