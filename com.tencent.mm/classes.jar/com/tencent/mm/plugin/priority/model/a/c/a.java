package com.tencent.mm.plugin.priority.model.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Calendar;
import java.util.HashSet;

public final class a
  implements d.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public com.tencent.mm.sdk.b.c hfS;
  String talker;
  int uid;
  boolean uvA;
  long uvB;
  long uvC;
  public long uvx;
  int uvy;
  int uvz;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.uvx = 0L;
    this.uvy = 0;
    this.uvz = 0;
    this.talker = "";
    this.uvA = false;
    this.uvB = 0L;
    this.uvC = 0L;
    this.hfS = new com.tencent.mm.sdk.b.c() {};
    this.uid = Process.myUid();
    this.hfS.alive();
    this.uvy = 2131231564;
    AppMethodBeat.o(87846);
  }
  
  public static boolean dbf()
  {
    AppMethodBeat.i(87851);
    if (!ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(87851);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if (i == 1)
    {
      com.tencent.mm.kernel.g.afz();
      if (j >= Math.abs(com.tencent.mm.kernel.a.getUin()) % 30)
      {
        AppMethodBeat.o(87851);
        return true;
      }
      AppMethodBeat.o(87851);
      return false;
    }
    if ((i >= 2) && (i <= 6))
    {
      AppMethodBeat.o(87851);
      return true;
    }
    AppMethodBeat.o(87851);
    return false;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(87850);
    ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", new Object[] { Long.valueOf(paramLong2) });
    this.uvx = 0L;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, false, true);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ad.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, false, false);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.uvx = 0L;
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.uvA = true;
      this.uvB = TrafficStats.getUidRxBytes(this.uid);
      this.uvC = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      c(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, true, false);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 54L, 1L, false);
    }
  }
  
  public final void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(87848);
    if (paramBoolean)
    {
      if (ay.isWifi(aj.getContext()))
      {
        ad.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
        AppMethodBeat.o(87848);
        return;
      }
      long l1 = bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhd, null), 0L);
      long l2 = bt.aGi((String)DateFormat.format("M", System.currentTimeMillis()));
      ad.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhd, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhe, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.uvx != 0L)
    {
      com.tencent.mm.aw.e locale = o.ayF().ms(this.uvx);
      if (o.ayG().a(locale.deI, this.uvx, locale.hgm))
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.uvx) });
        AppMethodBeat.o(87847);
        return;
      }
      this.uvx = 0L;
      if (locale.eOY != 1) {
        break label160;
      }
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.uvx) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(this.uvx, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label160:
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.uvx) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(this.uvx, 1);
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private a() {}
    
    public final String getName()
    {
      return "Priority.C2CImgAutoDownloaderTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87844);
      if (!com.tencent.mm.plugin.priority.a.a.a.a.daY())
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.this.uvx != 0L) || (a.this.uvA))
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.this.uvx), Boolean.valueOf(a.this.uvA) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject2;
      if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plz, com.tencent.mm.util.c.fgW()))
      {
        if (bt.isNullOrNil(a.this.talker)) {
          break label1510;
        }
        localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().k(a.this.talker, f1);
      }
      for (i = 1;; i = j)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bf(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dbg();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.dbf())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().be(f2);
            if (aj.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.this.uvx = 0L;
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plA, 10);
            f3 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plB, 10.0F);
            if (bt.isNullOrNil(a.this.talker)) {
              break label1504;
            }
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().b(a.this.talker, j, f3);
            i = 5;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().r(j, f3);
            i = 6;
          }
          localObject2 = localObject1;
          j = i;
          if (localObject1 == null)
          {
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dbg();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.dbf())
            {
              i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plC, 20);
              f3 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plD, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().r(i, f3);
              i = 7;
              break;
              a.this.uvx = ((he)localObject1).CCn;
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.this.uvx), Double.valueOf(((he)localObject1).CCk), Integer.valueOf(((he)localObject1).CCl), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(a.this.uvx);
              localObject2 = o.ayF().mr(((du)localObject1).field_msgSvrId);
              if (((com.tencent.mm.aw.e)localObject2).eOY == 1)
              {
                ad.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.uvx + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(a.this.uvx, 5);
                a.this.uvx = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              f.awL().haO.add("image_" + ((du)localObject1).field_msgId);
              if ((!bt.isNullOrNil(a.this.talker)) && (a.this.talker.equals(((du)localObject1).field_talker)))
              {
                j = o.ayG().a(((com.tencent.mm.aw.e)localObject2).deI, ((du)localObject1).field_msgId, 0, Long.valueOf(a.this.uvx), a.this.uvy, a.this, 60000, true);
                ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.this.uvx), "image_" + ((du)localObject1).field_msgId, a.this.talker, Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = o.ayG().a(((com.tencent.mm.aw.e)localObject2).deI, ((du)localObject1).field_msgId, 0, Long.valueOf(a.this.uvx), a.this.uvy, a.this, 60000, false);
                  ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.this.uvx), "image_" + ((du)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(a.this.uvx, 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(a.this.uvx, 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.this.uvx = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(a.this.uvx, 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.this.uvx = 0L;
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 62L, 1L, false);
                }
              }
            }
          }
          break;
          label1504:
          localObject2 = null;
        }
        label1510:
        localObject2 = null;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private b() {}
    
    public final String getName()
    {
      return "Priority.CheckNetworkNetStatTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87845);
      long l1 = TrafficStats.getUidRxBytes(a.this.uid);
      long l2 = TrafficStats.getUidTxBytes(a.this.uid);
      long l3 = l1 - a.this.uvB + (l2 - a.this.uvC);
      if (l3 <= 20480L)
      {
        a.this.uvA = false;
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.this.uvB = l1;
      a.this.uvC = l2;
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */