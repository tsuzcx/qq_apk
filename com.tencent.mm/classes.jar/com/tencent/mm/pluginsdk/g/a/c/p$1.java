package com.tencent.mm.pluginsdk.g.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(79610);
    Object localObject2 = q.a.dmz();
    int i = p.getNetworkType();
    ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
      AppMethodBeat.o(79610);
      return;
    }
    if (!((q)localObject2).hsO)
    {
      ab.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
      AppMethodBeat.o(79610);
      return;
    }
    long l;
    if (((q)localObject2).hsO)
    {
      l = bo.aoy();
      localObject2 = ((q)localObject2).vOE.getAll();
      if (localObject2 != null) {
        break label149;
      }
      localObject1 = locals;
    }
    for (;;)
    {
      ab.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(bo.hl(l)) });
      if (!bo.es((List)localObject1)) {
        break;
      }
      ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
      AppMethodBeat.o(79610);
      return;
      label149:
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
          locals.convertFrom((Cursor)localObject2);
          ((List)localObject1).add(locals);
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      locals = (s)((Iterator)localObject1).next();
      if (!bo.isNullOrNil(locals.field_groupId1))
      {
        int j = locals.field_groupId1.hashCode();
        localObject2 = r.dmA().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          g localg = (g)((Iterator)localObject2).next();
          if (j == bo.nullAsNil(localg.avS()).hashCode()) {
            localg.dme().a(locals, i);
          }
        }
      }
    }
    AppMethodBeat.o(79610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.p.1
 * JD-Core Version:    0.7.0.1
 */