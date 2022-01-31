package com.tencent.mm.plugin.monitor;

import android.database.Cursor;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class b$2
  implements Runnable
{
  b$2(b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public final void run()
  {
    long l1;
    long l2;
    long l3;
    com.tencent.mm.cf.h localh;
    ArrayList localArrayList;
    try
    {
      log_14375 locallog_14375 = new log_14375();
      locallog_14375.type_ = 1;
      localObject3 = new BDStatusInfo();
      locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject3);
      g.DQ();
      l1 = new com.tencent.mm.vfs.b(g.DP().Dx()).length();
      ((BDStatusInfo)localObject3).mmDBSize_ = l1;
      Object localObject1 = new StringBuilder();
      g.DQ();
      l2 = new com.tencent.mm.vfs.b(g.DP().cachePath + "SnsMicroMsg.db").length();
      ((BDStatusInfo)localObject3).snsDBSize_ = l2;
      localObject1 = new StringBuilder();
      g.DQ();
      l3 = new com.tencent.mm.vfs.b(g.DP().cachePath + "enFavorite.db").length();
      ((BDStatusInfo)localObject3).favDBSize_ = l3;
      b.a(this.msl, 4, l1, this.msm);
      b.a(this.msl, 128, l3, this.msn);
      localObject1 = l1 + ";" + l2 + ";" + l3;
      g.DQ();
      localh = g.DP().dKv;
      if ((localh == null) || (!localh.isOpen()))
      {
        y.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13778, new Object[] { Integer.valueOf(1), Integer.valueOf(1), localObject1 });
        com.tencent.mm.plugin.report.service.h.nFQ.c(14375, locallog_14375);
        com.tencent.mm.plugin.report.service.h.nFQ.a(418L, 3L, 1L, true);
        y.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[] { localObject1 });
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
      y.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportDBInfo err!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.nFQ.a(418L, 4L, 1L, true);
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
        Object localObject4 = localh.a("select count(*) from " + str2, null, 2);
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
          b.a(this.msl, 8, l2, this.mso);
        } else if ("rconversation".equals(str2)) {
          b.a(this.msl, 16, l2, this.msp);
        } else if ("rcontact".equals(str2)) {
          b.a(this.msl, 32, l2, this.msq);
        } else if ("chatroom".equals(str2)) {
          b.a(this.msl, 64, l2, this.msr);
        }
      }
      else
      {
        y.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l3) });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.2
 * JD-Core Version:    0.7.0.1
 */