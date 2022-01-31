package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class l$3
  implements com.tencent.mm.plugin.fts.a.l
{
  l$3(l paraml, HashSet paramHashSet, long paramLong1, long paramLong2) {}
  
  public final void b(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    paramj = paramj.kxh;
    Object localObject;
    if (paramj != null)
    {
      paramj = paramj.iterator();
      while (paramj.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.l)paramj.next();
        this.nRc.remove(((com.tencent.mm.plugin.fts.a.a.l)localObject).kwg);
        this.nRa.nQU.add(((com.tencent.mm.plugin.fts.a.a.l)localObject).kwg);
      }
    }
    paramj = this.nRc.iterator();
    while (paramj.hasNext())
    {
      localObject = (String)paramj.next();
      int i = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().q((String)localObject, this.nRd, System.currentTimeMillis());
      if (i > 0)
      {
        y.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[] { localObject, Integer.valueOf(i) });
      }
      else
      {
        Cursor localCursor1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a((String)localObject, this.nRd, System.currentTimeMillis(), true);
        if (localCursor1.getCount() > 0)
        {
          Cursor localCursor2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a((String)localObject, this.nRd, System.currentTimeMillis(), false);
          if (localCursor2.getCount() <= 0) {
            this.nRa.nQU.add(localObject);
          }
          localCursor2.close();
        }
        for (;;)
        {
          localCursor1.close();
          break;
          this.nRa.nQU.add(localObject);
        }
      }
    }
    y.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[] { Long.valueOf(this.nRd), Long.valueOf(System.currentTimeMillis() - this.dhV) });
    this.nRa.nQS.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.3
 * JD-Core Version:    0.7.0.1
 */