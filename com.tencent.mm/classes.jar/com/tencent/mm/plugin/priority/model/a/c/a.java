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
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Calendar;
import java.util.HashSet;

public final class a
  implements d.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public com.tencent.mm.sdk.b.c hGv;
  String talker;
  int uid;
  public long vEq;
  int vEr;
  int vEs;
  boolean vEt;
  long vEu;
  long vEv;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.vEq = 0L;
    this.vEr = 0;
    this.vEs = 0;
    this.talker = "";
    this.vEt = false;
    this.vEu = 0L;
    this.vEv = 0L;
    this.hGv = new com.tencent.mm.sdk.b.c() {};
    this.uid = Process.myUid();
    this.hGv.alive();
    this.vEr = 2131231564;
    AppMethodBeat.o(87846);
  }
  
  public static boolean doN()
  {
    AppMethodBeat.i(87851);
    if (!ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(87851);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if (i == 1)
    {
      com.tencent.mm.kernel.g.agP();
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
    ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", new Object[] { Long.valueOf(paramLong2) });
    this.vEq = 0L;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ac.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.vEq = 0L;
      ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.vEt = true;
      this.vEu = TrafficStats.getUidRxBytes(this.uid);
      this.vEv = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      c(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 54L, 1L, false);
    }
  }
  
  public final void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(87848);
    if (paramBoolean)
    {
      if (ax.isWifi(ai.getContext()))
      {
        ac.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
        AppMethodBeat.o(87848);
        return;
      }
      long l1 = bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GER, null), 0L);
      long l2 = bs.aLz((String)DateFormat.format("M", System.currentTimeMillis()));
      ac.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GER, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GES, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.vEq != 0L)
    {
      com.tencent.mm.av.e locale = o.aFx().qg(this.vEq);
      if (o.aFy().a(locale.dcd, this.vEq, locale.hGP))
      {
        ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.vEq) });
        AppMethodBeat.o(87847);
        return;
      }
      this.vEq = 0L;
      if (locale.eSg != 1) {
        break label160;
      }
      ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.vEq) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(this.vEq, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label160:
      ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.vEq) });
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(this.vEq, 1);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.doG())
      {
        ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.this.vEq != 0L) || (a.this.vEt))
      {
        ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.this.vEq), Boolean.valueOf(a.this.vEt) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject2;
      if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOV, com.tencent.mm.util.c.fwW()))
      {
        if (bs.isNullOrNil(a.this.talker)) {
          break label1510;
        }
        localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().k(a.this.talker, f1);
      }
      for (i = 1;; i = j)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bm(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().doO();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.doN())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bl(f2);
            if (ai.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.this.vEq = 0L;
              ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOW, 10);
            f3 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOX, 10.0F);
            if (bs.isNullOrNil(a.this.talker)) {
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
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().doO();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.doN())
            {
              i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOY, 20);
              f3 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOZ, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().r(i, f3);
              i = 7;
              break;
              a.this.vEq = ((hi)localObject1).DUK;
              ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.this.vEq), Double.valueOf(((hi)localObject1).DUH), Integer.valueOf(((hi)localObject1).DUI), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(a.this.vEq);
              localObject2 = o.aFx().qf(((dy)localObject1).field_msgSvrId);
              if (((com.tencent.mm.av.e)localObject2).eSg == 1)
              {
                ac.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.vEq + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(a.this.vEq, 5);
                a.this.vEq = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              f.aDD().hBp.add("image_" + ((dy)localObject1).field_msgId);
              if ((!bs.isNullOrNil(a.this.talker)) && (a.this.talker.equals(((dy)localObject1).field_talker)))
              {
                j = o.aFy().a(((com.tencent.mm.av.e)localObject2).dcd, ((dy)localObject1).field_msgId, 0, Long.valueOf(a.this.vEq), a.this.vEr, a.this, 60000, true);
                ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.this.vEq), "image_" + ((dy)localObject1).field_msgId, a.this.talker, Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = o.aFy().a(((com.tencent.mm.av.e)localObject2).dcd, ((dy)localObject1).field_msgId, 0, Long.valueOf(a.this.vEq), a.this.vEr, a.this, 60000, false);
                  ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.this.vEq), "image_" + ((dy)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(a.this.vEq, 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(a.this.vEq, 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.this.vEq = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(a.this.vEq, 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.this.vEq = 0L;
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 62L, 1L, false);
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
      long l3 = l1 - a.this.vEu + (l2 - a.this.vEv);
      if (l3 <= 20480L)
      {
        a.this.vEt = false;
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      ac.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.this.vEu = l1;
      a.this.vEv = l2;
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */