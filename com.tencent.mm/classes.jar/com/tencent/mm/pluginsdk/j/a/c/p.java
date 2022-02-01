package com.tencent.mm.pluginsdk.j.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class p
{
  public static void agJ()
  {
    AppMethodBeat.i(152055);
    if (!feP())
    {
      AppMethodBeat.o(152055);
      return;
    }
    if (getNetworkType() == 0)
    {
      AppMethodBeat.o(152055);
      return;
    }
    long l = bu.aRi();
    if (bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INS, null), 0L) < l)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INS, Long.valueOf(7200L + l));
      ae.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
      q.a.feQ().caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          Object localObject1 = null;
          s locals = null;
          AppMethodBeat.i(152053);
          if (!p.feP())
          {
            ae.e("MicroMsg.PostTaskCheckResume", "try resumeAllAndEvictExpired but account not ready");
            AppMethodBeat.o(152053);
            return;
          }
          try
          {
            localObject3 = q.a.feQ();
            i = p.getNetworkType();
            ae.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
            if (i == 0)
            {
              ae.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
              AppMethodBeat.o(152053);
              return;
            }
          }
          catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
          {
            Object localObject3;
            int i;
            ae.printErrStackTrace("MicroMsg.PostTaskCheckResume", localSQLiteDatabaseCorruptException, "resumeAllAndEvictExpired", new Object[0]);
            AppMethodBeat.o(152053);
            return;
            if (!((q)localObject3).kot)
            {
              ae.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
              AppMethodBeat.o(152053);
              return;
            }
            long l;
            if (((q)localObject3).kot)
            {
              l = bu.fpO();
              localObject3 = ((q)localObject3).Fjr.getAll();
              if (localObject3 != null) {
                break label189;
              }
              localObject2 = locals;
            }
            for (;;)
            {
              ae.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(bu.DD(l)) });
              if (!bu.ht((List)localObject2)) {
                break;
              }
              ae.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
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
              if (!bu.isNullOrNil(locals.field_groupId1))
              {
                int j = locals.field_groupId1.hashCode();
                localObject3 = r.feR().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  g localg = (g)((Iterator)localObject3).next();
                  if (j == bu.nullAsNil(localg.afK()).hashCode()) {
                    localg.fev().a(locals, i);
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
  
  static boolean feP()
  {
    AppMethodBeat.i(152054);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!a.aiT()) {}
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
    switch (ab.abf())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.p
 * JD-Core Version:    0.7.0.1
 */