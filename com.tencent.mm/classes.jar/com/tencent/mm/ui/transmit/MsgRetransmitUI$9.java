package com.tencent.mm.ui.transmit;

import com.tencent.mm.as.i;
import com.tencent.mm.as.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class MsgRetransmitUI$9
  implements m.a
{
  MsgRetransmitUI$9(MsgRetransmitUI paramMsgRetransmitUI, long paramLong1, long paramLong2) {}
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.MsgRetransmitUI", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.9
 * JD-Core Version:    0.7.0.1
 */