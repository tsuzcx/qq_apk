package com.tencent.mm.pluginsdk.g.a.c;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class p$1
  implements Runnable
{
  public final void run()
  {
    Object localObject1 = null;
    s locals = null;
    Object localObject2 = q.a.clL();
    int i = p.getNetworkType();
    y.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      y.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
      label44:
      return;
    }
    else
    {
      if (!((q)localObject2).gaO)
      {
        y.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
        return;
      }
      long l;
      if (((q)localObject2).gaO)
      {
        l = bk.UY();
        localObject2 = ((q)localObject2).rXN.aAn();
        if (localObject2 != null) {
          break label129;
        }
        localObject1 = locals;
      }
      for (;;)
      {
        y.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(bk.co(l)) });
        if (!bk.dk((List)localObject1)) {
          break;
        }
        y.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
        return;
        label129:
        if (((Cursor)localObject2).getCount() <= 0)
        {
          ((Cursor)localObject2).close();
          localObject1 = locals;
        }
        else
        {
          localObject1 = new LinkedList();
          ((Cursor)localObject2).moveToFirst();
          do
          {
            locals = new s();
            locals.d((Cursor)localObject2);
            ((List)localObject1).add(locals);
          } while (((Cursor)localObject2).moveToNext());
          ((Cursor)localObject2).close();
        }
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label44;
      }
      locals = (s)((Iterator)localObject1).next();
      if (bk.bl(locals.field_groupId1)) {
        break;
      }
      int j = locals.field_groupId1.hashCode();
      localObject2 = r.clM().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        g localg = (g)((Iterator)localObject2).next();
        if (j == bk.pm(localg.acb()).hashCode()) {
          localg.ccC().a(locals, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.p.1
 * JD-Core Version:    0.7.0.1
 */