package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.ak.i, com.tencent.mm.ak.j, com.tencent.mm.plugin.record.a.d
{
  public String AYB = "";
  f AYC;
  
  private static void a(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.gpO) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        ca localca = ((l)g.af(l.class)).eiy().Hb(l);
        ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).a(true, paramj.field_dataId, localca.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean eCR()
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
      g.aAf();
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
  
  public final void a(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(87830);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.AYB, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(87831);
    if (paramj.field_dataId.equals(this.AYB)) {
      switch (paramj.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.AYB = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(paramj, true);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(paramj, false);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(87829);
    if ((paramq.equals(this.AYC)) && (this.AYB.equals(String.valueOf(this.AYC.msgId))))
    {
      g.azz().b(221, this);
      this.AYB = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 4L, 1L, false);
    }
    AppMethodBeat.o(87829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87828);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
    ((PluginPriority)g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
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
      Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.rRR;
      Object localObject3 = com.tencent.mm.util.c.QYz;
      if (((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.hdd()) == 0)
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.eCR())
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87827);
        return;
      }
      if (!Util.isNullOrNil(a.this.AYB))
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", new Object[] { a.this.AYB });
        AppMethodBeat.o(87827);
        return;
      }
      long l = ((PluginPriority)g.ah(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)g.ah(PluginPriority.class)).getFileBgBorderPriority();
      localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
      localObject2 = b.a.rRZ;
      localObject3 = com.tencent.mm.util.c.QYz;
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.hde());
      localObject1 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().eCX();
      int i;
      if (localObject1 == null) {
        if (!bool)
        {
          localObject1 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().b(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSa, 20);
          float f2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSb, 10.0F);
          localObject1 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().s(i, f2);
          i = 3;
        }
        else
        {
          final ca localca = ((l)g.af(l.class)).eiy().aJ(((ib)localObject1).KLZ, ((ib)localObject1).KMf);
          if ((ab.Eq(localca.field_talker)) && (localca.field_isSend == 0)) {}
          final k.b localb;
          for (localObject2 = bp.Kt(localca.field_content);; localObject2 = localca.field_content)
          {
            localb = k.b.HD((String)localObject2);
            if (localb != null) {
              break;
            }
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            localObject2 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
            localObject3 = ((ib)localObject1).Id;
            l = ((ib)localObject1).KMf;
            ((c)localObject2).AYG.bindString(1, (String)localObject3);
            ((c)localObject2).AYG.bindLong(2, l);
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", new Object[] { Integer.valueOf(((c)localObject2).AYG.executeUpdateDelete()), localObject3, Long.valueOf(l) });
            AppMethodBeat.o(87827);
            return;
          }
          if (((ib)localObject1).KMb == 2)
          {
            localObject3 = com.tencent.mm.plugin.r.a.cgO().Mp(Long.valueOf(((ib)localObject1).Id).longValue());
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aB(com.tencent.mm.loader.j.b.aKM(), localb.title, localb.iwJ);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId = localb.dCK;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen = localb.iwI;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_createTime = Util.nowMilliSecond();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_lastModifyTime = Util.nowSecond();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_msgInfoId = Long.valueOf(((ib)localObject1).Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_type = localb.iwM;
              com.tencent.mm.plugin.r.a.cgO().insert((IAutoDBItem)localObject2);
            }
            localObject3 = new o(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
            if ((((o)localObject3).exists()) && (((o)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen))
            {
              Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(((ib)localObject1).Id, ((ib)localObject1).KMf, 5);
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(((ib)localObject1).Id, ((ib)localObject1).KMf, 2);
            a.this.AYB = ((ib)localObject1).Id;
            h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(87826);
                a.this.AYC = new f(localca.field_msgId, localb.dCK, null);
                a.this.AYC.qJf = true;
                g.azz().a(221, a.this);
                g.azz().a(a.this.AYC, 0);
                AppMethodBeat.o(87826);
              }
            });
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 0L, 1L, false);
            if (!Util.isNullOrNil(a.this.AYB))
            {
              if (i != 1) {
                break label1048;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.this.AYB });
            AppMethodBeat.o(87827);
            return;
            localObject2 = p.aKY(localb.ixl).iAd.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (aml)((Iterator)localObject2).next();
              if (((aml)localObject3).dLl.equals(((ib)localObject1).Id))
              {
                ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (p.b((aml)localObject3, localca.field_msgId, true))
                {
                  a.this.AYB = ((ib)localObject1).Id;
                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 1L, 1L, false);
                }
                else
                {
                  ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                }
              }
            }
            break;
            label1048:
            if (i == 2) {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1241L, 9L, 1L, false);
            }
          }
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.a
 * JD-Core Version:    0.7.0.1
 */