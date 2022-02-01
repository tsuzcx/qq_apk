package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.al.f, com.tencent.mm.al.g, com.tencent.mm.plugin.record.a.d
{
  public String wLl = "";
  com.tencent.mm.plugin.record.b.f wLm;
  
  private static void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.fIy) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(true, paramj.field_dataId, localbu.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean dzi()
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
      com.tencent.mm.kernel.g.ajA();
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
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(87830);
    ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.wLl, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(87831);
    if (paramj.field_dataId.equals(this.wLl)) {
      switch (paramj.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.wLl = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(paramj, true);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(paramj, false);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(87829);
    if ((paramn.equals(this.wLm)) && (this.wLl.equals(String.valueOf(this.wLm.msgId))))
    {
      com.tencent.mm.kernel.g.aiU().b(221, this);
      this.wLl = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 4L, 1L, false);
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
      Object localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.qsR;
      Object localObject3 = com.tencent.mm.util.c.LgD;
      if (((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fNJ()) == 0)
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.dzi())
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87827);
        return;
      }
      if (!bt.isNullOrNil(a.this.wLl))
      {
        ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", new Object[] { a.this.wLl });
        AppMethodBeat.o(87827);
        return;
      }
      long l = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getFileBgBorderPriority();
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      localObject2 = b.a.qsZ;
      localObject3 = com.tencent.mm.util.c.LgD;
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fNK());
      localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().dzo();
      int i;
      if (localObject1 == null) {
        if (!bool)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().b(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qta, 20);
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtb, 10.0F);
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().r(i, f2);
          i = 3;
        }
        else
        {
          bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(((ho)localObject1).FzS, ((ho)localObject1).FzY);
          if ((w.vF(localbu.field_talker)) && (localbu.field_isSend == 0)) {}
          k.b localb;
          for (localObject2 = bj.Bl(localbu.field_content);; localObject2 = localbu.field_content)
          {
            localb = k.b.yr((String)localObject2);
            if (localb != null) {
              break;
            }
            ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
            localObject3 = ((ho)localObject1).Id;
            l = ((ho)localObject1).FzY;
            ((c)localObject2).wLq.bindString(1, (String)localObject3);
            ((c)localObject2).wLq.bindLong(2, l);
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(((c)localObject2).wLq.executeUpdateDelete()), localObject3, Long.valueOf(l) });
            AppMethodBeat.o(87827);
            return;
          }
          if (((ho)localObject1).FzU == 2)
          {
            localObject3 = com.tencent.mm.plugin.s.a.bIX().CB(Long.valueOf(((ho)localObject1).Id).longValue());
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aq(com.tencent.mm.loader.j.b.arX(), localb.title, localb.hzP);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId = localb.dks;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen = localb.hzO;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_createTime = bt.flT();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_lastModifyTime = bt.aQJ();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_msgInfoId = Long.valueOf(((ho)localObject1).Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_type = localb.hzS;
              com.tencent.mm.plugin.s.a.bIX().insert((com.tencent.mm.sdk.e.c)localObject2);
            }
            localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject3).exists()) && (((com.tencent.mm.vfs.e)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen))
            {
              ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(((ho)localObject1).Id, ((ho)localObject1).FzY, 5);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(((ho)localObject1).Id, ((ho)localObject1).FzY, 2);
            a.this.wLl = ((ho)localObject1).Id;
            h.LTJ.aP(new a.a.1(this, localbu, localb));
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 0L, 1L, false);
            if (!bt.isNullOrNil(a.this.wLl))
            {
              if (i != 1) {
                break label1048;
              }
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.this.wLl });
            AppMethodBeat.o(87827);
            return;
            localObject2 = p.avr(localb.hAs).hDb.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ajn)((Iterator)localObject2).next();
              if (((ajn)localObject3).dsU.equals(((ho)localObject1).Id))
              {
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (p.b((ajn)localObject3, localbu.field_msgId, true))
                {
                  a.this.wLl = ((ho)localObject1).Id;
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 1L, 1L, false);
                }
                else
                {
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                }
              }
            }
            break;
            label1048:
            if (i == 2) {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1241L, 9L, 1L, false);
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