package com.tencent.mm.plugin.priority.model.c2c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  implements com.tencent.mm.am.h, com.tencent.mm.am.i, com.tencent.mm.plugin.record.a.d
{
  public String MQd = "";
  private g MQe;
  
  private static void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(87832);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.g.a.lwb) || (paramj.field_fileType == com.tencent.mm.g.a.MediaType_FILE))) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).a(true, paramj.field_dataId, localcc.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(87832);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(87832);
  }
  
  public static boolean gzN()
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
      com.tencent.mm.kernel.h.baC();
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
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(87830);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", new Object[] { this.MQd, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(87830);
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(87831);
    if (paramj.field_dataId.equals(this.MQd)) {
      switch (paramj.field_status)
      {
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
      this.MQd = "";
      start();
      AppMethodBeat.o(87831);
      return;
      a(paramj, true);
      f.Ozc.idkeyStat(1241L, 3L, 1L, false);
      continue;
      a(paramj, false);
      f.Ozc.idkeyStat(1241L, 5L, 1L, false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(87829);
    if ((paramp.equals(this.MQe)) && (this.MQd.equals(String.valueOf(this.MQe.msgId))))
    {
      com.tencent.mm.kernel.h.aZW().b(221, this);
      this.MQd = "";
      start();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        f.Ozc.idkeyStat(1241L, 2L, 1L, false);
        AppMethodBeat.o(87829);
        return;
      }
      f.Ozc.idkeyStat(1241L, 4L, 1L, false);
    }
    AppMethodBeat.o(87829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87828);
    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
    ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
    AppMethodBeat.o(87828);
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private a() {}
    
    public final String getName()
    {
      return "Priority.C2CFileAutoDownloadTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87827);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLQ, 0) == 0)
      {
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
        AppMethodBeat.o(87827);
        return;
      }
      if (!a.gzN())
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
      long l = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getFileBgBorderSize();
      float f1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getFileBgBorderPriority();
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLY, false);
      in localin = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().gzU();
      int i;
      if (localin == null) {
        if (!bool)
        {
          localin = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().d(f1, l);
          i = 2;
        }
      }
      for (;;)
      {
        if (localin == null)
        {
          Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", new Object[] { Long.valueOf(l), Float.valueOf(f1) });
          AppMethodBeat.o(87827);
          return;
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLZ, 20);
          float f2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMa, 10.0F);
          localin = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().w(i, f2);
          i = 3;
        }
        else
        {
          final cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(localin.YKk, localin.YKq);
          if (localcc == null)
          {
            ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bq(localin.Id, localin.YKq);
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "invalid auto download file info");
            AppMethodBeat.o(87827);
            return;
          }
          if ((au.bwE(localcc.field_talker)) && (localcc.field_isSend == 0)) {}
          final k.b localb;
          for (Object localObject1 = br.JK(localcc.field_content);; localObject1 = localcc.field_content)
          {
            localb = k.b.Hf((String)localObject1);
            if (localb != null) {
              break;
            }
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
            ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bq(localin.Id, localin.YKq);
            AppMethodBeat.o(87827);
            return;
          }
          Object localObject2;
          if (localin.YKm == 2)
          {
            localObject2 = com.tencent.mm.plugin.openapi.a.cWJ().yi(Long.valueOf(localin.Id).longValue());
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aK(com.tencent.mm.loader.i.b.bmC(), localb.title, localb.nRe);
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_appId = localb.appId;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_sdkVer = localb.sdkVer;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId = localb.hzM;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen = localb.nRd;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status = 101L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload = false;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_createTime = cn.bDu();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_lastModifyTime = Util.nowSecond();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId = Long.valueOf(localin.Id).longValue();
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_netTimes = 0L;
              ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type = localb.nRh;
              com.tencent.mm.plugin.openapi.a.cWJ().insert((IAutoDBItem)localObject1);
            }
            localObject2 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((u)localObject2).jKS()) && (((u)localObject2).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().o(localin.Id, localin.YKq, 5);
              f.Ozc.idkeyStat(1241L, 8L, 1L, false);
              AppMethodBeat.o(87827);
              return;
            }
            ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().o(localin.Id, localin.YKq, 2);
            a.a(a.this, localin.Id);
            com.tencent.threadpool.h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(87826);
                a.a(a.this, new g(localcc.field_msgId, localb.hzM, null));
                a.b(a.this).xon = true;
                com.tencent.mm.kernel.h.aZW().a(221, a.this);
                com.tencent.mm.kernel.h.aZW().a(a.b(a.this), 0);
                AppMethodBeat.o(87826);
              }
            });
            f.Ozc.idkeyStat(1241L, 0L, 1L, false);
            if (!Util.isNullOrNil(a.a(a.this)))
            {
              if (i != 1) {
                break label999;
              }
              f.Ozc.idkeyStat(1241L, 6L, 1L, false);
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", new Object[] { Integer.valueOf(i), a.a(a.this) });
            AppMethodBeat.o(87827);
            return;
            localObject1 = q.aSH(localb.nRF).nUC.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (arf)((Iterator)localObject1).next();
              if (((arf)localObject2).hIQ.equals(localin.Id))
              {
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                if (q.b((arf)localObject2, localcc.field_msgId, true))
                {
                  a.a(a.this, localin.Id);
                  f.Ozc.idkeyStat(1241L, 1L, 1L, false);
                }
                else
                {
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                }
              }
            }
            break;
            label999:
            if (i == 2) {
              f.Ozc.idkeyStat(1241L, 7L, 1L, false);
            } else if (i == 3) {
              f.Ozc.idkeyStat(1241L, 9L, 1L, false);
            }
          }
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.b.a
 * JD-Core Version:    0.7.0.1
 */