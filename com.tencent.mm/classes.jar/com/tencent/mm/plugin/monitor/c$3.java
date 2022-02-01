package com.tencent.mm.plugin.monitor;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class c$3
  implements Runnable
{
  c$3(c paramc, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public final void run()
  {
    AppMethodBeat.i(51502);
    long l1;
    long l2;
    com.tencent.mm.storagebase.h localh;
    long l4;
    ArrayList localArrayList;
    try
    {
      log_14375 locallog_14375 = new log_14375();
      locallog_14375.type_ = 1;
      localObject3 = new BDStatusInfo();
      locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject3);
      com.tencent.mm.kernel.h.baF();
      l1 = new u(com.tencent.mm.kernel.h.baE().bal()).length();
      ((BDStatusInfo)localObject3).mmDBSize_ = l1;
      Object localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      long l3 = new u(com.tencent.mm.kernel.h.baE().cachePath + "SnsMicroMsg.db").length();
      ((BDStatusInfo)localObject3).snsDBSize_ = l3;
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      l2 = new u(com.tencent.mm.kernel.h.baE().cachePath + "enFavorite.db").length();
      ((BDStatusInfo)localObject3).favDBSize_ = l2;
      c.a(this.LfZ, 4, l1, this.Lgb);
      c.a(this.LfZ, 128, l2, this.Lgc);
      localObject1 = l1 + ";" + l3 + ";" + l2;
      com.tencent.mm.kernel.h.baF();
      localh = com.tencent.mm.kernel.h.baE().mCO;
      if ((localh == null) || (!localh.isOpen()))
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
        com.tencent.mm.plugin.report.service.h.OAn.a(13778, false, false, true, new Object[] { Integer.valueOf(1), Integer.valueOf(1), localObject1 });
        com.tencent.mm.plugin.report.service.h.OAn.a(13778, false, false, true, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Long.valueOf(l3) });
        com.tencent.mm.plugin.report.service.h.OAn.c(14375, locallog_14375);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(418L, 3L, 1L, true);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[] { localObject1 });
        AppMethodBeat.o(51502);
        return;
      }
      l4 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = localh.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
      if (localObject2 != null)
      {
        int i = ((Cursor)localObject2).getColumnIndex("name");
        while (((Cursor)localObject2).moveToNext()) {
          localArrayList.add(((Cursor)localObject2).getString(i));
        }
        ((Cursor)localObject2).close();
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportDBInfo err!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(418L, 4L, 1L, true);
      AppMethodBeat.o(51502);
      return;
    }
    String str1 = localException + ";" + localArrayList.size();
    ((BDStatusInfo)localObject3).mmDBTableCount_ = localArrayList.size();
    Object localObject2 = new LinkedList();
    ((BDStatusInfo)localObject3).tableList_ = ((LinkedList)localObject2);
    Object localObject3 = localArrayList.iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        String str2 = (String)((Iterator)localObject3).next();
        Object localObject4 = localh.rawQuery("select count(*) from ".concat(String.valueOf(str2)), null, 2);
        l1 = 0L;
        l2 = l1;
        if (localObject4 != null)
        {
          if (((Cursor)localObject4).moveToFirst()) {
            l1 = ((Cursor)localObject4).getLong(0);
          }
          ((Cursor)localObject4).close();
          l2 = l1;
        }
        str1 = str1 + ";" + str2 + ":" + l2;
        localObject4 = new TableInfo();
        ((TableInfo)localObject4).name_ = str2;
        ((TableInfo)localObject4).count_ = l2;
        ((LinkedList)localObject2).add(localObject4);
        if ("message".equals(str2)) {
          c.a(this.LfZ, 8, l2, this.Lgd);
        } else if ("rconversation".equals(str2)) {
          c.a(this.LfZ, 16, l2, this.Lge);
        } else if ("rcontact".equals(str2)) {
          c.a(this.LfZ, 32, l2, this.Lgf);
        } else if ("chatroom".equals(str2)) {
          c.a(this.LfZ, 64, l2, this.Lgg);
        }
      }
      else
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l4) });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.3
 * JD-Core Version:    0.7.0.1
 */