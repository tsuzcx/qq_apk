package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(126869);
    paramj = paramj.mSW;
    Object localObject;
    if (paramj != null)
    {
      paramj = paramj.iterator();
      while (paramj.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.l)paramj.next();
        this.qEZ.remove(((com.tencent.mm.plugin.fts.a.a.l)localObject).mRV);
        this.qEX.qER.add(((com.tencent.mm.plugin.fts.a.a.l)localObject).mRV);
      }
    }
    paramj = this.qEZ.iterator();
    while (paramj.hasNext())
    {
      localObject = (String)paramj.next();
      int i = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().y((String)localObject, this.qFa, System.currentTimeMillis());
      if (i > 0)
      {
        ab.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[] { localObject, Integer.valueOf(i) });
      }
      else
      {
        Cursor localCursor1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a((String)localObject, this.qFa, System.currentTimeMillis(), true);
        if (localCursor1.getCount() > 0)
        {
          Cursor localCursor2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a((String)localObject, this.qFa, System.currentTimeMillis(), false);
          if (localCursor2.getCount() <= 0) {
            this.qEX.qER.add(localObject);
          }
          localCursor2.close();
        }
        for (;;)
        {
          localCursor1.close();
          break;
          this.qEX.qER.add(localObject);
        }
      }
    }
    ab.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[] { Long.valueOf(this.qFa), Long.valueOf(System.currentTimeMillis() - this.dZo) });
    this.qEX.qEP.countDown();
    AppMethodBeat.o(126869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.3
 * JD-Core Version:    0.7.0.1
 */