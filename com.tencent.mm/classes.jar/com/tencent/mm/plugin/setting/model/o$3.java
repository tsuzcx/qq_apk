package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class o$3
  implements l
{
  o$3(o paramo, HashSet paramHashSet, long paramLong1, long paramLong2) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(73791);
    paramk = paramk.BIW;
    Object localObject;
    if (paramk != null)
    {
      paramk = paramk.iterator();
      while (paramk.hasNext())
      {
        localObject = (m)paramk.next();
        this.JdP.remove(((m)localObject).BHS);
        this.JdN.JdG.add(((m)localObject).BHS);
      }
    }
    paramk = this.JdP.iterator();
    while (paramk.hasNext())
    {
      localObject = (String)paramk.next();
      int i = ((n)h.ae(n.class)).eSe().C((String)localObject, this.val$timestamp, System.currentTimeMillis());
      if (i > 0)
      {
        Log.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[] { localObject, Integer.valueOf(i) });
      }
      else
      {
        Cursor localCursor1 = ((n)h.ae(n.class)).eSe().b((String)localObject, this.val$timestamp, System.currentTimeMillis(), true);
        if (localCursor1.getCount() > 0)
        {
          Cursor localCursor2 = ((n)h.ae(n.class)).eSe().b((String)localObject, this.val$timestamp, System.currentTimeMillis(), false);
          if (localCursor2.getCount() <= 0) {
            this.JdN.JdG.add(localObject);
          }
          localCursor2.close();
        }
        for (;;)
        {
          localCursor1.close();
          break;
          this.JdN.JdG.add(localObject);
        }
      }
    }
    Log.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[] { Long.valueOf(this.val$timestamp), Long.valueOf(System.currentTimeMillis() - this.cAj) });
    this.JdN.JdE.countDown();
    AppMethodBeat.o(73791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o.3
 * JD-Core Version:    0.7.0.1
 */