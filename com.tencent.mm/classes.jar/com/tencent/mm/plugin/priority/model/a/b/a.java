package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.al.h, com.tencent.mm.plugin.record.a.d
{
  public String uvm = "";
  com.tencent.mm.plugin.record.b.e uvn;
  
  private static void a(com.tencent.mm.plugin.record.a.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == parami.field_type) && ((parami.field_fileType == com.tencent.mm.i.a.fmX) || (parami.field_fileType == com.tencent.mm.i.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(parami.field_mediaId.split("@")[2]).longValue();
        bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(true, parami.field_dataId, localbl.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception parami) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean daY()
  {
    AppMethodBeat.i(87833);
    if (!ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(87833);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if ((i == 1) && (j >= 30))
    {
      com.tencent.mm.kernel.g.afz();
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
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(87830);
    ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.uvm, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(87831);
    if (parami.field_dataId.equals(this.uvm)) {
      switch (parami.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.uvm = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(parami, true);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(parami, false);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(87829);
    if ((paramn.equals(this.uvn)) && (this.uvm.equals(String.valueOf(this.uvn.msgId))))
    {
      com.tencent.mm.kernel.g.aeS().b(221, this);
      this.uvm = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 4L, 1L, false);
    }
    AppMethodBeat.o(87829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87828);
    ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
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
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plw, com.tencent.mm.util.c.fgV()) == 0)
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.daY())
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87827);
        return;
      }
      if (!bt.isNullOrNil(a.this.uvm))
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", new Object[] { a.this.uvm });
        AppMethodBeat.o(87827);
        return;
      }
      long l = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderPriority();
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plE, com.tencent.mm.util.c.fgW());
      hd localhd = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().dbe();
      int i;
      if (localhd == null) {
        if (!bool)
        {
          localhd = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localhd == null)
        {
          ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plF, 20);
          float f2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plG, 10.0F);
          localhd = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().q(i, f2);
          i = 3;
        }
        else
        {
          final bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().aD(localhd.uKU, localhd.CCg);
          if ((w.pF(localbl.field_talker)) && (localbl.field_isSend == 0)) {}
          final k.b localb;
          Object localObject2;
          for (Object localObject1 = bi.ug(localbl.field_content);; localObject1 = localbl.field_content)
          {
            localb = k.b.rx((String)localObject1);
            if (localb != null) {
              break;
            }
            ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
            localObject2 = localhd.Id;
            l = localhd.CCg;
            ((c)localObject1).uvr.bindString(1, (String)localObject2);
            ((c)localObject1).uvr.bindLong(2, l);
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(((c)localObject1).uvr.executeUpdateDelete()), localObject2, Long.valueOf(l) });
            AppMethodBeat.o(87827);
            return;
          }
          if (localhd.CCc == 2)
          {
            localObject2 = com.tencent.mm.plugin.s.a.bxS().vj(Long.valueOf(localhd.Id).longValue());
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.ai(com.tencent.mm.loader.j.b.aij(), localb.title, localb.gHf);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId = localb.dbA;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen = localb.gHe;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_createTime = bt.eGO();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_lastModifyTime = bt.aGK();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId = Long.valueOf(localhd.Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type = localb.gHi;
              com.tencent.mm.plugin.s.a.bxS().insert((com.tencent.mm.sdk.e.c)localObject1);
            }
            localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject2).exists()) && (((com.tencent.mm.vfs.e)localObject2).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j(localhd.Id, localhd.CCg, 5);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j(localhd.Id, localhd.CCg, 2);
            a.this.uvm = localhd.Id;
            com.tencent.e.h.Iye.aN(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(87826);
                a.this.uvn = new com.tencent.mm.plugin.record.b.e(localbl.field_msgId, localb.dbA, null);
                a.this.uvn.ofM = true;
                com.tencent.mm.kernel.g.aeS().a(221, a.this);
                com.tencent.mm.kernel.g.aeS().a(a.this.uvn, 0);
                AppMethodBeat.o(87826);
              }
            });
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 0L, 1L, false);
            if (!bt.isNullOrNil(a.this.uvm))
            {
              if (i != 1) {
                break label1022;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.this.uvm });
            AppMethodBeat.o(87827);
            return;
            localObject1 = com.tencent.mm.plugin.record.b.n.alt(localb.gHI).gKs.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (afy)((Iterator)localObject1).next();
              if (((afy)localObject2).dkb.equals(localhd.Id))
              {
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (com.tencent.mm.plugin.record.b.n.b((afy)localObject2, localbl.field_msgId, true))
                {
                  a.this.uvm = localhd.Id;
                  com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 1L, 1L, false);
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
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(1241L, 9L, 1L, false);
            }
          }
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.a
 * JD-Core Version:    0.7.0.1
 */