package com.tencent.mm.ui.chatting.k;

import com.tencent.mm.ap.b.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

final class b$4
  implements b.b
{
  b$4(b paramb, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      long l1 = this.vzF.vzx;
      bi localbi = (bi)paramList.get(paramList.size() - 1);
      long l2 = this.vzF.id(localbi.field_createTime);
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + this.vzF.drJ + " from:" + l1 + " to:" + l2 + " size:" + paramList.size());
      this.vzF.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.vzF.drJ, l1, l2, 2147483647);
      this.vxX.cN();
      return;
    }
    y.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:" + paramInt);
    this.vzF.d(this.vxX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b.4
 * JD-Core Version:    0.7.0.1
 */