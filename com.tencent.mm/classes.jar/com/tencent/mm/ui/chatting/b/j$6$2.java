package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashSet;

final class j$6$2
  implements t.a
{
  j$6$2(j.6 param6, bi parambi, HashSet paramHashSet) {}
  
  public final void a(t.a.a parama)
  {
    if (this.dUy.field_imgPath.equals(parama.fileName))
    {
      s locals = u.oe(parama.fileName);
      if ((locals == null) || (!locals.SG())) {
        break label104;
      }
      y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.dUy.field_msgId), parama.fileName });
    }
    for (;;)
    {
      o.Sr().a(this);
      this.vmk.remove(Long.valueOf(this.dUy.field_msgId));
      j.6.a(this.vpw, this.vmk);
      return;
      label104:
      y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.dUy.field_msgId), parama.fileName });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.6.2
 * JD-Core Version:    0.7.0.1
 */