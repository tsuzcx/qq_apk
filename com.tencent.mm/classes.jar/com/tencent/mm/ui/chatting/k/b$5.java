package com.tencent.mm.ui.chatting.k;

import com.tencent.mm.ap.b.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

final class b$5
  implements b.b
{
  b$5(b paramb, long paramLong1, com.tencent.mm.plugin.messenger.foundation.a.a.b paramb1, long paramLong2, d.b paramb2) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    long l2;
    if (paramInt >= 0)
    {
      l2 = this.vzG;
      if (paramList.size() <= 0) {
        break label258;
      }
      l2 = ((bi)paramList.get(0)).field_createTime;
    }
    label258:
    for (;;)
    {
      long l1 = l2;
      if (this.vzH.K(this.vzF.drJ, l2) == null)
      {
        l1 = l2;
        if (paramList.size() < 18) {
          l1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().e(this.vzF.drJ, l2, 18 - paramList.size());
        }
      }
      l2 = l1;
      if (l1 <= 0L) {
        l2 = this.vzG;
      }
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + this.vzF.drJ + " firstCreateTime:" + this.vzG + " lastCreateTime:" + this.vzI + " from:" + l2);
      this.vzF.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.vzF.drJ, l2, this.vzF.vzy, this.vzF.vzA + 18);
      this.vxX.cN();
      return;
      this.vzF.d(this.vxX);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b.5
 * JD-Core Version:    0.7.0.1
 */