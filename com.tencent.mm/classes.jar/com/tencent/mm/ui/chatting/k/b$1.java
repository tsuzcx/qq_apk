package com.tencent.mm.ui.chatting.k;

import com.tencent.mm.ap.b.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

final class b$1
  implements b.b
{
  b$1(b paramb, long paramLong1, long paramLong2, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.vzF.drJ + " fromCreateTime:" + this.vzD + " toCreateTime:" + this.vzE + " addSize:" + paramList.size());
      long l = this.vzE;
      if (paramList.size() <= 18) {
        l = this.vzF.id(((bi)paramList.get(paramList.size() - 1)).field_createTime);
      }
      this.vzF.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.vzF.drJ, this.vzD, l, 36);
      this.vxX.cN();
      return;
    }
    this.vzF.d(this.vxX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b.1
 * JD-Core Version:    0.7.0.1
 */