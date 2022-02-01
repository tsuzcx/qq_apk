package com.tencent.mm.plugin.priority.model.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Calendar;
import java.util.HashSet;

public final class a
  implements e.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public com.tencent.mm.sdk.b.c ibU;
  public String talker;
  int uid;
  public long xbk;
  int xbl;
  int xbm;
  boolean xbn;
  long xbo;
  long xbp;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.xbk = 0L;
    this.xbl = 0;
    this.xbm = 0;
    this.talker = "";
    this.xbn = false;
    this.xbo = 0L;
    this.xbp = 0L;
    this.ibU = new com.tencent.mm.sdk.b.c() {};
    this.uid = Process.myUid();
    this.ibU.alive();
    this.xbl = 2131231564;
    AppMethodBeat.o(87846);
  }
  
  public static boolean dCG()
  {
    AppMethodBeat.i(87851);
    if (!az.isWifi(ak.getContext()))
    {
      AppMethodBeat.o(87851);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if (i == 1)
    {
      com.tencent.mm.kernel.g.ajP();
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
    ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", new Object[] { Long.valueOf(paramLong2) });
    this.xbk = 0L;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ae.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.xbk = 0L;
      ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.xbn = true;
      this.xbo = TrafficStats.getUidRxBytes(this.uid);
      this.xbp = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      c(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 54L, 1L, false);
    }
  }
  
  public final void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(87848);
    if (paramBoolean)
    {
      if (az.isWifi(ak.getContext()))
      {
        ae.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
        AppMethodBeat.o(87848);
        return;
      }
      long l1 = bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILG, null), 0L);
      long l2 = bu.aSC((String)DateFormat.format("M", System.currentTimeMillis()));
      ae.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILG, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILH, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.xbk != 0L)
    {
      com.tencent.mm.av.g localg = q.aIX().G(this.talker, this.xbk);
      if (q.aIY().a(localg.doE, this.xbk, localg.icr))
      {
        ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.xbk) });
        AppMethodBeat.o(87847);
        return;
      }
      this.xbk = 0L;
      if (localg.fms != 1) {
        break label164;
      }
      ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.xbk) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(this.xbk, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label164:
      ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.xbk) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(this.xbk, 1);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dCz())
      {
        ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.this.xbk != 0L) || (a.this.xbn))
      {
        ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.this.xbk), Boolean.valueOf(a.this.xbn) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.qzJ;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fSf()))
      {
        if (bu.isNullOrNil(a.this.talker)) {
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
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dCH();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.dCG())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bo(f2);
            if (ak.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.this.xbk = 0L;
              ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzK, 10);
            f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzL, 10.0F);
            if (bu.isNullOrNil(a.this.talker)) {
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
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().dCH();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.dCG())
            {
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzM, 20);
              f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzN, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().s(i, f3);
              i = 7;
              break;
              a.this.xbk = ((hp)localObject1).FSD;
              ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.this.xbk), Double.valueOf(((hp)localObject1).FSA), Integer.valueOf(((hp)localObject1).FSB), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(a.this.xbk);
              localObject2 = q.aIX().F(((ei)localObject1).field_talker, ((ei)localObject1).field_msgSvrId);
              if (((com.tencent.mm.av.g)localObject2).fms == 1)
              {
                ae.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.xbk + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.xbk, 5);
                a.this.xbk = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              f.aGZ().hWG.add("image_" + ((ei)localObject1).field_msgId);
              if ((!bu.isNullOrNil(a.this.talker)) && (a.this.talker.equals(((ei)localObject1).field_talker)))
              {
                j = q.aIY().a(((com.tencent.mm.av.g)localObject2).doE, ((ei)localObject1).field_msgId, 0, Long.valueOf(a.this.xbk), a.this.xbl, a.this, 60000, true);
                ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.this.xbk), "image_" + ((ei)localObject1).field_msgId, a.this.talker, Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = q.aIY().a(((com.tencent.mm.av.g)localObject2).doE, ((ei)localObject1).field_msgId, 0, Long.valueOf(a.this.xbk), a.this.xbl, a.this, 60000, false);
                  ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.this.xbk), "image_" + ((ei)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.xbk, 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.xbk, 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.this.xbk = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(a.this.xbk, 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.this.xbk = 0L;
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.ywz.idkeyStat(957L, 62L, 1L, false);
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
      long l3 = l1 - a.this.xbo + (l2 - a.this.xbp);
      if (l3 <= 20480L)
      {
        a.this.xbn = false;
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      ae.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.this.xbo = l1;
      a.this.xbp = l2;
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */