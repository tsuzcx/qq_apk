package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.i;
import com.tencent.mm.at.m.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class MsgRetransmitUI$9
  implements m.a
{
  MsgRetransmitUI$9(MsgRetransmitUI paramMsgRetransmitUI, long paramLong1, long paramLong2) {}
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35071);
    ab.i("MicroMsg.MsgRetransmitUI", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      i.lz((int)this.fFS);
      i.ly((int)this.fFS);
      AppMethodBeat.o(35071);
      return;
    }
    bi localbi = ((j)g.E(j.class)).bPQ().kB(this.zyf);
    localbi.setStatus(2);
    localbi.fP(paramLong);
    ((j)g.E(j.class)).bPQ().a(this.zyf, localbi);
    i.ly((int)this.fFS);
    AppMethodBeat.o(35071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.9
 * JD-Core Version:    0.7.0.1
 */