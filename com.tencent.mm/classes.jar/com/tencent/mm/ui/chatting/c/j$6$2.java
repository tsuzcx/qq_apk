package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.HashSet;

final class j$6$2
  implements t.a
{
  j$6$2(j.6 param6, bi parambi, HashSet paramHashSet) {}
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(31317);
    if (this.fkH.field_imgPath.equals(parama.fileName))
    {
      s locals = u.vr(parama.fileName);
      if ((locals == null) || (!locals.alS())) {
        break label116;
      }
      ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.fkH.field_msgId), parama.fileName });
    }
    for (;;)
    {
      o.alE().a(this);
      this.zBI.remove(Long.valueOf(this.fkH.field_msgId));
      j.6.a(this.zEY, this.zBI);
      AppMethodBeat.o(31317);
      return;
      label116:
      ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.fkH.field_msgId), parama.fileName });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.6.2
 * JD-Core Version:    0.7.0.1
 */