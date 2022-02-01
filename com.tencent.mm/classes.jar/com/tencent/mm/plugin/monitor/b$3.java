package com.tencent.mm.plugin.monitor;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class b$3
  implements Runnable
{
  b$3(b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public final void run()
  {
    AppMethodBeat.i(51502);
    long l1;
    long l2;
    long l3;
    com.tencent.mm.storagebase.h localh;
    ArrayList localArrayList;
    try
    {
      log_14375 locallog_14375 = new log_14375();
      locallog_14375.type_ = 1;
      localObject3 = new BDStatusInfo();
      locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject3);
      g.afC();
      l1 = new com.tencent.mm.vfs.e(g.afB().afi()).length();
      ((BDStatusInfo)localObject3).mmDBSize_ = l1;
      Object localObject1 = new StringBuilder();
      g.afC();
      l2 = new com.tencent.mm.vfs.e(g.afB().cachePath + "SnsMicroMsg.db").length();
      ((BDStatusInfo)localObject3).snsDBSize_ = l2;
      localObject1 = new StringBuilder();
      g.afC();
      l3 = new com.tencent.mm.vfs.e(g.afB().cachePath + "enFavorite.db").length();
      ((BDStatusInfo)localObject3).favDBSize_ = l3;
      b.a(this.tMX, 4, l1, this.tMZ);
      b.a(this.tMX, 128, l3, this.tNa);
      localObject1 = l1 + ";" + l2 + ";" + l3;
      g.afC();
      localh = g.afB().gdb;
      if ((localh == null) || (!localh.isOpen()))
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
        com.tencent.mm.plugin.report.service.h.vKh.a(13778, false, false, true, new Object[] { Integer.valueOf(1), Integer.valueOf(1), localObject1 });
        com.tencent.mm.plugin.report.service.h.vKh.c(14375, locallog_14375);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(418L, 3L, 1L, true);
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[] { localObject1 });
        AppMethodBeat.o(51502);
        return;
      }
      l3 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = localh.a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
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
      ad.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportDBInfo err!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(418L, 4L, 1L, true);
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
        Object localObject4 = localh.a("select count(*) from ".concat(String.valueOf(str2)), null, 2);
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
          b.a(this.tMX, 8, l2, this.tNb);
        } else if ("rconversation".equals(str2)) {
          b.a(this.tMX, 16, l2, this.tNc);
        } else if ("rcontact".equals(str2)) {
          b.a(this.tMX, 32, l2, this.tNd);
        } else if ("chatroom".equals(str2)) {
          b.a(this.tMX, 64, l2, this.tNe);
        }
      }
      else
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l3) });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.3
 * JD-Core Version:    0.7.0.1
 */