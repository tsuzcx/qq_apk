package com.tencent.mm.ui.chatting.k;

import com.tencent.mm.ap.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

final class b$2
  implements b.b
{
  b$2(b paramb, d.b paramb1) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    if ((paramInt >= 0) && (paramList.size() > 0))
    {
      long l1 = this.vzF.cGV();
      long l2 = this.vzF.cGX();
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + this.vzF.drJ + " from:" + l1 + " to:" + l2);
      this.vzF.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.vzF.drJ, l1, l2, 18);
      this.vxX.cN();
      return;
    }
    this.vzF.d(this.vxX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b.2
 * JD-Core Version:    0.7.0.1
 */