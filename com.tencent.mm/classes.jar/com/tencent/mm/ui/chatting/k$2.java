package com.tencent.mm.ui.chatting;

import com.tencent.mm.as.i;
import com.tencent.mm.as.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class k$2
  implements m.a
{
  k$2(long paramLong1, long paramLong2) {}
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ChattingEditModeLogic", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      i.iL((int)this.eps);
      i.iK((int)this.eps);
      return;
    }
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.vjf);
    localbi.setStatus(2);
    localbi.bf(paramLong);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.vjf, localbi);
    i.iK((int)this.eps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.2
 * JD-Core Version:    0.7.0.1
 */