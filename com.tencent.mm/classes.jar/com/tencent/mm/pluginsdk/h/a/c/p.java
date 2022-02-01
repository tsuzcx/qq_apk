package com.tencent.mm.pluginsdk.h.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class p
{
  public static void adP()
  {
    AppMethodBeat.i(152055);
    if (!eMe())
    {
      AppMethodBeat.o(152055);
      return;
    }
    if (getNetworkType() == 0)
    {
      AppMethodBeat.o(152055);
      return;
    }
    long l = bs.aNx();
    if (bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHe, null), 0L) < l)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHe, Long.valueOf(7200L + l));
      ac.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
      q.a.eMf().bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          Object localObject1 = null;
          s locals = null;
          AppMethodBeat.i(152053);
          if (!p.eMe())
          {
            ac.e("MicroMsg.PostTaskCheckResume", "try resumeAllAndEvictExpired but account not ready");
            AppMethodBeat.o(152053);
            return;
          }
          try
          {
            localObject3 = q.a.eMf();
            i = p.getNetworkType();
            ac.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
            if (i == 0)
            {
              ac.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
              AppMethodBeat.o(152053);
              return;
            }
          }
          catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
          {
            Object localObject3;
            int i;
            ac.printErrStackTrace("MicroMsg.PostTaskCheckResume", localSQLiteDatabaseCorruptException, "resumeAllAndEvictExpired", new Object[0]);
            AppMethodBeat.o(152053);
            return;
            if (!((q)localObject3).jQO)
            {
              ac.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
              AppMethodBeat.o(152053);
              return;
            }
            long l;
            if (((q)localObject3).jQO)
            {
              l = bs.eWj();
              localObject3 = ((q)localObject3).DlU.getAll();
              if (localObject3 != null) {
                break label189;
              }
              localObject2 = locals;
            }
            for (;;)
            {
              ac.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(bs.Ap(l)) });
              if (!bs.gY((List)localObject2)) {
                break;
              }
              ac.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
              AppMethodBeat.o(152053);
              return;
              label189:
              if (((Cursor)localObject3).getCount() <= 0)
              {
                ((Cursor)localObject3).close();
                localObject2 = locals;
              }
              else
              {
                localObject2 = new LinkedList();
                ((Cursor)localObject3).moveToFirst();
                do
                {
                  locals = new s();
                  locals.convertFrom((Cursor)localObject3);
                  ((List)localObject2).add(locals);
                } while (((Cursor)localObject3).moveToNext());
                ((Cursor)localObject3).close();
              }
            }
            Object localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              locals = (s)((Iterator)localObject2).next();
              if (!bs.isNullOrNil(locals.field_groupId1))
              {
                int j = locals.field_groupId1.hashCode();
                localObject3 = r.eMg().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  g localg = (g)((Iterator)localObject3).next();
                  if (j == bs.nullAsNil(localg.azp()).hashCode()) {
                    localg.eLK().a(locals, i);
                  }
                }
              }
            }
            AppMethodBeat.o(152053);
            return;
          }
          catch (com.tencent.wcdb.database.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
          {
            label76:
            break label76;
          }
        }
      });
    }
    AppMethodBeat.o(152055);
  }
  
  static boolean eMe()
  {
    AppMethodBeat.i(152054);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!a.afS()) {}
    }
    else
    {
      AppMethodBeat.o(152054);
      return false;
    }
    AppMethodBeat.o(152054);
    return true;
  }
  
  static int getNetworkType()
  {
    AppMethodBeat.i(152056);
    switch (ab.Yu())
    {
    default: 
      AppMethodBeat.o(152056);
      return 2;
    case 0: 
      AppMethodBeat.o(152056);
      return 0;
    }
    AppMethodBeat.o(152056);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.p
 * JD-Core Version:    0.7.0.1
 */