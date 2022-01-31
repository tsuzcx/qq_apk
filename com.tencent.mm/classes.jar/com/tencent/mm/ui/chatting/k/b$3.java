package com.tencent.mm.ui.chatting.k;

import com.tencent.mm.ap.b.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

final class b$3
  implements b.b
{
  b$3(b paramb, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      long l1 = this.vzF.vzx;
      paramList = (bi)paramList.get(paramList.size() - 1);
      long l2 = this.vzF.id(paramList.field_createTime);
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + this.vzF.drJ + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramList.field_createTime);
      this.vzF.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.vzF.drJ, l1, l2, 2147483647);
      this.vxX.cN();
      return;
    }
    this.vzF.d(this.vxX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b.3
 * JD-Core Version:    0.7.0.1
 */