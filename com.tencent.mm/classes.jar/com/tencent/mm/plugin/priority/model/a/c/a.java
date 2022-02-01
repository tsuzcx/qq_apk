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
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Calendar;
import java.util.HashSet;

public final class a
  implements e.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public com.tencent.mm.sdk.b.c hZc;
  public String talker;
  int uid;
  long wLA;
  long wLB;
  public long wLw;
  int wLx;
  int wLy;
  boolean wLz;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.wLw = 0L;
    this.wLx = 0;
    this.wLy = 0;
    this.talker = "";
    this.wLz = false;
    this.wLA = 0L;
    this.wLB = 0L;
    this.hZc = new com.tencent.mm.sdk.b.c() {};
    this.uid = Process.myUid();
    this.hZc.alive();
    this.wLx = 2131231564;
    AppMethodBeat.o(87846);
  }
  
  public static boolean dzp()
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
      com.tencent.mm.kernel.g.ajA();
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
    this.wLw = 0L;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ad.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.wLw = 0L;
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.wLz = true;
      this.wLA = TrafficStats.getUidRxBytes(this.uid);
      this.wLB = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      c(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 54L, 1L, false);
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
      long l1 = bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irk, null), 0L);
      long l2 = bt.aRf((String)DateFormat.format("M", System.currentTimeMillis()));
      ad.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irk, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irl, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.wLw != 0L)
    {
      com.tencent.mm.aw.g localg = q.aIF().G(this.talker, this.wLw);
      if (q.aIG().a(localg.dnz, this.wLw, localg.hZz))
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.wLw) });
        AppMethodBeat.o(87847);
        return;
      }
      this.wLw = 0L;
      if (localg.fkv != 1) {
        break label164;
      }
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.wLw) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(this.wLw, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label164:
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.wLw) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(this.wLw, 1);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dzi())
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.this.wLw != 0L) || (a.this.wLz))
      {
        ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.this.wLw), Boolean.valueOf(a.this.wLz) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.qsU;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fNK()))
      {
        if (bt.isNullOrNil(a.this.talker)) {
          break label1526;
        }
        localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().l(a.this.talker, f1);
      }
      for (i = 1;; i = j)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bp(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dzq();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.dzp())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bo(f2);
            if (aj.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.this.wLw = 0L;
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsV, 10);
            f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsW, 10.0F);
            if (bt.isNullOrNil(a.this.talker)) {
              break label1520;
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
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().s(j, f3);
            i = 6;
          }
          localObject2 = localObject1;
          j = i;
          if (localObject1 == null)
          {
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dzq();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.dzp())
            {
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsX, 20);
              f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsY, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().s(i, f3);
              i = 7;
              break;
              a.this.wLw = ((hp)localObject1).FAf;
              ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.this.wLw), Double.valueOf(((hp)localObject1).FAc), Integer.valueOf(((hp)localObject1).FAd), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(a.this.wLw);
              localObject2 = q.aIF().F(((ei)localObject1).field_talker, ((ei)localObject1).field_msgSvrId);
              if (((com.tencent.mm.aw.g)localObject2).fkv == 1)
              {
                ad.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.wLw + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.wLw, 5);
                a.this.wLw = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              f.aGI().hTO.add("image_" + ((ei)localObject1).field_msgId);
              if ((!bt.isNullOrNil(a.this.talker)) && (a.this.talker.equals(((ei)localObject1).field_talker)))
              {
                j = q.aIG().a(((com.tencent.mm.aw.g)localObject2).dnz, ((ei)localObject1).field_msgId, 0, Long.valueOf(a.this.wLw), a.this.wLx, a.this, 60000, true);
                ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.this.wLw), "image_" + ((ei)localObject1).field_msgId, a.this.talker, Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = q.aIG().a(((com.tencent.mm.aw.g)localObject2).dnz, ((ei)localObject1).field_msgId, 0, Long.valueOf(a.this.wLw), a.this.wLx, a.this, 60000, false);
                  ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.this.wLw), "image_" + ((ei)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.wLw, 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.wLw, 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.this.wLw = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.wLw, 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.this.wLw = 0L;
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 62L, 1L, false);
                }
              }
            }
          }
          break;
          label1520:
          localObject2 = null;
        }
        label1526:
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
      long l3 = l1 - a.this.wLA + (l2 - a.this.wLB);
      if (l3 <= 20480L)
      {
        a.this.wLz = false;
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      ad.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.this.wLA = l1;
      a.this.wLB = l2;
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */