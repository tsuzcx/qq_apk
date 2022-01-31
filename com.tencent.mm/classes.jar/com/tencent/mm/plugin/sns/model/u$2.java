package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.model.ap;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class u$2
  implements Runnable
{
  u$2(u paramu, boolean paramBoolean, bsx parambsx, ah paramah) {}
  
  public final void run()
  {
    if (this.oqz)
    {
      Iterator localIterator = u.bDc().iterator();
      while (localIterator.hasNext())
      {
        ap localap = (ap)localIterator.next();
        y.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
        localap.a(this.oqA);
      }
    }
    this.oqx.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.2
 * JD-Core Version:    0.7.0.1
 */