package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  implements com.tencent.mm.an.i, com.tencent.mm.an.j, com.tencent.mm.plugin.record.a.d
{
  private com.tencent.mm.plugin.record.b.f GSA;
  public String GSz = "";
  
  private static void a(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.iTW) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).a(true, paramj.field_dataId, localca.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean foK()
  {
    AppMethodBeat.i(87833);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(87833);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if ((i == 1) && (j >= 30))
    {
      com.tencent.mm.kernel.h.aHE();
      if (j >= Math.abs(com.tencent.mm.kernel.b.getUin()) % 30 + 30)
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
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(87830);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.GSz, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(87831);
    if (paramj.field_dataId.equals(this.GSz)) {
      switch (paramj.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.GSz = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(paramj, true);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(paramj, false);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(87829);
    if ((paramq.equals(this.GSA)) && (this.GSz.equals(String.valueOf(this.GSA.msgId))))
    {
      com.tencent.mm.kernel.h.aGY().b(221, this);
      this.GSz = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 4L, 1L, false);
    }
    AppMethodBeat.o(87829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87828);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
    ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
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
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyo, 0) == 0)
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.foK())
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87827);
        return;
      }
      if (!Util.isNullOrNil(a.a(a.this)))
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", new Object[] { a.a(a.this) });
        AppMethodBeat.o(87827);
        return;
      }
      long l = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getFileBgBorderPriority();
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyw, false);
      hr localhr = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().foQ();
      int i;
      if (localhr == null) {
        if (!bool)
        {
          localhr = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().d(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localhr == null)
        {
          Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyx, 20);
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyy, 10.0F);
          localhr = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().t(i, f2);
          i = 3;
        }
        else
        {
          final ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(localhr.RMW, localhr.RNc);
          if ((ab.Lj(localca.field_talker)) && (localca.field_isSend == 0)) {}
          final k.b localb;
          Object localObject2;
          for (Object localObject1 = bq.RM(localca.field_content);; localObject1 = localca.field_content)
          {
            localb = k.b.OQ((String)localObject1);
            if (localb != null) {
              break;
            }
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
            localObject2 = localhr.Id;
            l = localhr.RNc;
            ((c)localObject1).GSE.bindString(1, (String)localObject2);
            ((c)localObject1).GSE.bindLong(2, l);
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(((c)localObject1).GSE.executeUpdateDelete()), localObject2, Long.valueOf(l) });
            AppMethodBeat.o(87827);
            return;
          }
          if (localhr.RMY == 2)
          {
            localObject2 = com.tencent.mm.plugin.ab.a.ctZ().TR(Long.valueOf(localhr.Id).longValue());
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aw(com.tencent.mm.loader.j.b.aSO(), localb.title, localb.llY);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId = localb.fvr;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen = localb.llX;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_createTime = cm.bfC();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_lastModifyTime = Util.nowSecond();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId = Long.valueOf(localhr.Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type = localb.lmb;
              com.tencent.mm.plugin.ab.a.ctZ().insert((IAutoDBItem)localObject1);
            }
            localObject2 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.q)localObject2).ifE()) && (((com.tencent.mm.vfs.q)localObject2).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().m(localhr.Id, localhr.RNc, 5);
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().m(localhr.Id, localhr.RNc, 2);
            a.a(a.this, localhr.Id);
            com.tencent.e.h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(87826);
                a.a(a.this, new com.tencent.mm.plugin.record.b.f(localca.field_msgId, localb.fvr, null));
                a.b(a.this).uii = true;
                com.tencent.mm.kernel.h.aGY().a(221, a.this);
                com.tencent.mm.kernel.h.aGY().a(a.b(a.this), 0);
                AppMethodBeat.o(87826);
              }
            });
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 0L, 1L, false);
            if (!Util.isNullOrNil(a.a(a.this)))
            {
              if (i != 1) {
                break label1020;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.a(a.this) });
            AppMethodBeat.o(87827);
            return;
            localObject1 = p.aVz(localb.lmA).lpz.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (anm)((Iterator)localObject1).next();
              if (((anm)localObject2).fEa.equals(localhr.Id))
              {
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (p.b((anm)localObject2, localca.field_msgId, true))
                {
                  a.a(a.this, localhr.Id);
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 1L, 1L, false);
                }
                else
                {
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                }
              }
            }
            break;
            label1020:
            if (i == 2) {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1241L, 9L, 1L, false);
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