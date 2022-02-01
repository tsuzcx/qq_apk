package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.ak.h, com.tencent.mm.plugin.record.a.d
{
  public String vEf = "";
  com.tencent.mm.plugin.record.b.e vEg;
  
  private static void a(com.tencent.mm.plugin.record.a.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == parami.field_type) && ((parami.field_fileType == com.tencent.mm.i.a.fqr) || (parami.field_fileType == com.tencent.mm.i.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(parami.field_mediaId.split("@")[2]).longValue();
        bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(true, parami.field_dataId, localbo.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception parami) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean doG()
  {
    AppMethodBeat.i(87833);
    if (!ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(87833);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if ((i == 1) && (j >= 30))
    {
      com.tencent.mm.kernel.g.agP();
      if (j >= Math.abs(com.tencent.mm.kernel.a.getUin()) % 30 + 30)
      {
        AppMethodBeat.o(87833);
        return true;
      }
      AppMethodBeat.o(87833);
      return false;
    }
    if ((i >= 2) && (i <= 6))
    {
      AppMethodBeat.o(87833);
      return true;
    }
    AppMethodBeat.o(87833);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(87830);
    ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.vEf, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(87831);
    if (parami.field_dataId.equals(this.vEf)) {
      switch (parami.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.vEf = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(parami, true);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(parami, false);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(87829);
    if ((paramn.equals(this.vEg)) && (this.vEf.equals(String.valueOf(this.vEg.msgId))))
    {
      com.tencent.mm.kernel.g.agi().b(221, this);
      this.vEf = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 4L, 1L, false);
    }
    AppMethodBeat.o(87829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87828);
    ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
    ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
    AppMethodBeat.o(87828);
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private a() {}
    
    public final String getName()
    {
      return "Priority.C2CFileAutoDownloadTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87827);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOS, com.tencent.mm.util.c.fwV()) == 0)
      {
        ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.doG())
      {
        ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87827);
        return;
      }
      if (!bs.isNullOrNil(a.this.vEf))
      {
        ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", new Object[] { a.this.vEf });
        AppMethodBeat.o(87827);
        return;
      }
      long l = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderPriority();
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPa, com.tencent.mm.util.c.fwW());
      hh localhh = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().doM();
      int i;
      if (localhh == null) {
        if (!bool)
        {
          localhh = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localhh == null)
        {
          ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPb, 20);
          float f2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPc, 10.0F);
          localhh = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().q(i, f2);
          i = 3;
        }
        else
        {
          final bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().aF(localhh.vTL, localhh.DUD);
          if ((w.sQ(localbo.field_talker)) && (localbo.field_isSend == 0)) {}
          final k.b localb;
          Object localObject2;
          for (Object localObject1 = bi.ym(localbo.field_content);; localObject1 = localbo.field_content)
          {
            localb = k.b.vA((String)localObject1);
            if (localb != null) {
              break;
            }
            ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
            localObject2 = localhh.Id;
            l = localhh.DUD;
            ((c)localObject1).vEk.bindString(1, (String)localObject2);
            ((c)localObject1).vEk.bindLong(2, l);
            ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(((c)localObject1).vEk.executeUpdateDelete()), localObject2, Long.valueOf(l) });
            AppMethodBeat.o(87827);
            return;
          }
          if (localhh.DUz == 2)
          {
            localObject2 = com.tencent.mm.plugin.s.a.bEO().zM(Long.valueOf(localhh.Id).longValue());
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aj(com.tencent.mm.loader.j.b.apj(), localb.title, localb.hhG);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId = localb.cZa;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen = localb.hhF;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_createTime = bs.eWj();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_lastModifyTime = bs.aNx();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId = Long.valueOf(localhh.Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type = localb.hhJ;
              com.tencent.mm.plugin.s.a.bEO().insert((com.tencent.mm.sdk.e.c)localObject1);
            }
            localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject2).exists()) && (((com.tencent.mm.vfs.e)localObject2).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j(localhh.Id, localhh.DUD, 5);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j(localhh.Id, localhh.DUD, 2);
            a.this.vEf = localhh.Id;
            com.tencent.e.h.JZN.aQ(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(87826);
                a.this.vEg = new com.tencent.mm.plugin.record.b.e(localbo.field_msgId, localb.cZa, null);
                a.this.vEg.oJn = true;
                com.tencent.mm.kernel.g.agi().a(221, a.this);
                com.tencent.mm.kernel.g.agi().a(a.this.vEg, 0);
                AppMethodBeat.o(87826);
              }
            });
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 0L, 1L, false);
            if (!bs.isNullOrNil(a.this.vEf))
            {
              if (i != 1) {
                break label1022;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.this.vEf });
            AppMethodBeat.o(87827);
            return;
            localObject1 = com.tencent.mm.plugin.record.b.n.aqs(localb.hij).hkS.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (agx)((Iterator)localObject1).next();
              if (((agx)localObject2).dhw.equals(localhh.Id))
              {
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (com.tencent.mm.plugin.record.b.n.b((agx)localObject2, localbo.field_msgId, true))
                {
                  a.this.vEf = localhh.Id;
                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 1L, 1L, false);
                }
                else
                {
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                }
              }
            }
            break;
            label1022:
            if (i == 2) {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1241L, 9L, 1L, false);
            }
          }
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.a
 * JD-Core Version:    0.7.0.1
 */