package com.tencent.mm.plugin.priority.model.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Calendar;
import java.util.HashSet;

public final class a
  implements e.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public long AYM;
  int AYN;
  int AYO;
  boolean AYP;
  long AYQ;
  long AYR;
  public IListener iWS;
  public String talker;
  int uid;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.AYM = 0L;
    this.AYN = 0;
    this.AYO = 0;
    this.talker = "";
    this.AYP = false;
    this.AYQ = 0L;
    this.AYR = 0L;
    this.iWS = new a.1(this);
    this.uid = Process.myUid();
    this.iWS.alive();
    this.AYN = 2131231628;
    AppMethodBeat.o(87846);
  }
  
  public static boolean eCY()
  {
    AppMethodBeat.i(87851);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(87851);
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if (i == 1)
    {
      com.tencent.mm.kernel.g.aAf();
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
    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", new Object[] { Long.valueOf(paramLong2) });
    this.AYM = 0L;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ak.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.AYM = 0L;
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.AYP = true;
      this.AYQ = TrafficStats.getUidRxBytes(this.uid);
      this.AYR = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      b(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 54L, 1L, false);
    }
  }
  
  public final void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(87848);
    if (paramBoolean)
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        Log.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
        AppMethodBeat.o(87848);
        return;
      }
      long l1 = Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTI, null), 0L);
      long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
      Log.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTI, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTJ, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.AYM != 0L)
    {
      com.tencent.mm.av.g localg = com.tencent.mm.av.q.bcR().H(this.talker, this.AYM);
      if (com.tencent.mm.av.q.bcS().a(localg.localId, this.AYM, localg.iXp))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.AYM) });
        AppMethodBeat.o(87847);
        return;
      }
      this.AYM = 0L;
      if (localg.fQW != 1) {
        break label164;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.AYM) });
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(this.AYM, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label164:
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.AYM) });
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(this.AYM, 1);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.eCR())
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.this.AYM != 0L) || (a.this.AYP))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.this.AYM), Boolean.valueOf(a.this.AYP) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.rRU;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.hde()))
      {
        if (Util.isNullOrNil(a.this.talker)) {
          break label1526;
        }
        localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().j(a.this.talker, f1);
      }
      for (i = 1;; i = j)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bH(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().eCZ();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.eCY())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bG(f2);
            if (MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.this.AYM = 0L;
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRV, 10);
            f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRW, 10.0F);
            if (Util.isNullOrNil(a.this.talker)) {
              break label1520;
            }
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().b(a.this.talker, j, f3);
            i = 5;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().t(j, f3);
            i = 6;
          }
          localObject2 = localObject1;
          j = i;
          if (localObject1 == null)
          {
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().eCZ();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.eCY())
            {
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRX, 20);
              f3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRY, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().t(i, f3);
              i = 7;
              break;
              a.this.AYM = ((ic)localObject1).KMm;
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.this.AYM), Double.valueOf(((ic)localObject1).KMj), Integer.valueOf(((ic)localObject1).KMk), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(a.this.AYM);
              localObject2 = com.tencent.mm.av.q.bcR().G(((eo)localObject1).field_talker, ((eo)localObject1).field_msgSvrId);
              if (((com.tencent.mm.av.g)localObject2).fQW == 1)
              {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.AYM + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 5);
                a.this.AYM = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              f.baQ().iRE.add("image_" + ((eo)localObject1).field_msgId);
              if ((!Util.isNullOrNil(a.this.talker)) && (a.this.talker.equals(((eo)localObject1).field_talker)))
              {
                j = com.tencent.mm.av.q.bcS().a(((com.tencent.mm.av.g)localObject2).localId, ((eo)localObject1).field_msgId, 0, Long.valueOf(a.this.AYM), a.this.AYN, a.this, 60000, true);
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.this.AYM), "image_" + ((eo)localObject1).field_msgId, a.this.talker, Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = com.tencent.mm.av.q.bcS().a(((com.tencent.mm.av.g)localObject2).localId, ((eo)localObject1).field_msgId, 0, Long.valueOf(a.this.AYM), a.this.AYN, a.this, 60000, false);
                  Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.this.AYM), "image_" + ((eo)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.this.AYM = 0L;
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.this.AYM = 0L;
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(957L, 62L, 1L, false);
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
      long l3 = l1 - a.this.AYQ + (l2 - a.this.AYR);
      if (l3 <= 20480L)
      {
        a.this.AYP = false;
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.this.AYQ = l1;
      a.this.AYR = l2;
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */