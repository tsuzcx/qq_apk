package com.tencent.mm.plugin.monitor;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class b$4
  implements Runnable
{
  b$4(b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public final void run()
  {
    AppMethodBeat.i(163485);
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
      com.tencent.mm.kernel.h.aHH();
      l1 = new q(com.tencent.mm.kernel.h.aHG().aHn()).length();
      ((BDStatusInfo)localObject3).mmDBSize_ = l1;
      Object localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      long l3 = new q(com.tencent.mm.kernel.h.aHG().cachePath + "SnsMicroMsg.db").length();
      ((BDStatusInfo)localObject3).snsDBSize_ = l3;
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      l2 = new q(com.tencent.mm.kernel.h.aHG().cachePath + "enFavorite.db").length();
      ((BDStatusInfo)localObject3).favDBSize_ = l2;
      b.a(this.Fkn, 4, l1, this.Fku);
      b.a(this.Fkn, 128, l2, this.Fkv);
      localObject1 = l1 + ";" + l3 + ";" + l2;
      com.tencent.mm.kernel.h.aHH();
      localh = com.tencent.mm.kernel.h.aHG().kcG;
      if ((localh == null) || (!localh.isOpen()))
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
        com.tencent.mm.plugin.report.service.h.IzE.a(13778, false, false, true, new Object[] { Integer.valueOf(1), Integer.valueOf(1), localObject1 });
        com.tencent.mm.plugin.report.service.h.IzE.a(13778, false, false, true, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Long.valueOf(l3) });
        com.tencent.mm.plugin.report.service.h.IzE.c(14375, locallog_14375);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 3L, 1L, true);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[] { localObject1 });
        AppMethodBeat.o(163485);
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
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 4L, 1L, true);
      AppMethodBeat.o(163485);
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
          b.a(this.Fkn, 8, l2, this.Fkw);
        } else if ("rconversation".equals(str2)) {
          b.a(this.Fkn, 16, l2, this.Fkx);
        } else if ("rcontact".equals(str2)) {
          b.a(this.Fkn, 32, l2, this.Fky);
        } else if ("chatroom".equals(str2)) {
          b.a(this.Fkn, 64, l2, this.Fkz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.4
 * JD-Core Version:    0.7.0.1
 */