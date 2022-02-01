package com.tencent.mm.pluginsdk.k.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class o
{
  public static void dwn()
  {
    AppMethodBeat.i(152055);
    if (!hiJ())
    {
      AppMethodBeat.o(152055);
      return;
    }
    if (getNetworkType() == 0)
    {
      AppMethodBeat.o(152055);
      return;
    }
    long l = Util.nowSecond();
    if (Util.nullAs((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VjV, null), 0L) < l)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjV, Long.valueOf(7200L + l));
      Log.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
      p.a.hiK().cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          Object localObject1 = null;
          r localr = null;
          AppMethodBeat.i(152053);
          if (!o.hiJ())
          {
            Log.e("MicroMsg.PostTaskCheckResume", "try resumeAllAndEvictExpired but account not ready");
            AppMethodBeat.o(152053);
            return;
          }
          try
          {
            localObject3 = p.a.hiK();
            i = o.getNetworkType();
            Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
            if (i == 0)
            {
              Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
              AppMethodBeat.o(152053);
              return;
            }
          }
          catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
          {
            Object localObject3;
            int i;
            Log.printErrStackTrace("MicroMsg.PostTaskCheckResume", localSQLiteDatabaseCorruptException, "resumeAllAndEvictExpired", new Object[0]);
            AppMethodBeat.o(152053);
            return;
            if (!((p)localObject3).omY)
            {
              Log.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
              AppMethodBeat.o(152053);
              return;
            }
            long l;
            if (((p)localObject3).omY)
            {
              l = Util.nowMilliSecond();
              localObject3 = ((p)localObject3).RaN.getAll();
              if (localObject3 != null) {
                break label189;
              }
              localObject2 = localr;
            }
            for (;;)
            {
              Log.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
              if (!Util.isNullOrNil((List)localObject2)) {
                break;
              }
              Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
              AppMethodBeat.o(152053);
              return;
              label189:
              if (((Cursor)localObject3).getCount() <= 0)
              {
                ((Cursor)localObject3).close();
                localObject2 = localr;
              }
              else
              {
                localObject2 = new LinkedList();
                ((Cursor)localObject3).moveToFirst();
                do
                {
                  localr = new r();
                  localr.convertFrom((Cursor)localObject3);
                  ((List)localObject2).add(localr);
                } while (((Cursor)localObject3).moveToNext());
                ((Cursor)localObject3).close();
              }
            }
            Object localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localr = (r)((Iterator)localObject2).next();
              if (!Util.isNullOrNil(localr.field_groupId1))
              {
                int j = localr.field_groupId1.hashCode();
                localObject3 = q.hiL().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  g localg = (g)((Iterator)localObject3).next();
                  if (j == Util.nullAsNil(localg.aCt()).hashCode()) {
                    localg.hil().a(localr, i);
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
  
  static int getNetworkType()
  {
    AppMethodBeat.i(152056);
    switch (ac.avq())
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
  
  static boolean hiJ()
  {
    AppMethodBeat.i(152054);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHE();
      if (!b.aGE()) {}
    }
    else
    {
      AppMethodBeat.o(152054);
      return false;
    }
    AppMethodBeat.o(152054);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.o
 * JD-Core Version:    0.7.0.1
 */