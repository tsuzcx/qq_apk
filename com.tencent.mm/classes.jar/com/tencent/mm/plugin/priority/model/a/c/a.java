package com.tencent.mm.plugin.priority.model.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.ay.g;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.c;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Calendar;
import java.util.HashSet;

public class a
  implements e.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public long GSK;
  private int GSL;
  private int GSM;
  private boolean GSN;
  private long GSO;
  private long GSP;
  public IListener lNn;
  public String talker;
  private int uid;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.GSK = 0L;
    this.GSL = 0;
    this.GSM = 0;
    this.talker = "";
    this.GSN = false;
    this.GSO = 0L;
    this.GSP = 0L;
    this.lNn = new IListener() {};
    this.uid = Process.myUid();
    this.lNn.alive();
    this.GSL = b.c.chat_img_template;
    AppMethodBeat.o(87846);
  }
  
  public static boolean foR()
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
      h.aHE();
      if (j >= Math.abs(com.tencent.mm.kernel.b.getUin()) % 30)
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
    this.GSK = 0L;
    ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.GSK = 0L;
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.GSN = true;
      this.GSO = TrafficStats.getUidRxBytes(this.uid);
      this.GSP = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      b(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 54L, 1L, false);
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
      long l1 = Util.nullAs((Long)h.aHG().aHp().get(ar.a.VhI, null), 0L);
      long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
      Log.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      h.aHG().aHp().set(ar.a.VhI, Long.valueOf(l1 + 1L));
      h.aHG().aHp().set(ar.a.VhJ, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.GSK != 0L)
    {
      g localg = com.tencent.mm.ay.q.bmh().D(this.talker, this.GSK);
      if (com.tencent.mm.ay.q.bmi().a(localg.localId, this.GSK, localg.lNK))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.GSK) });
        AppMethodBeat.o(87847);
        return;
      }
      this.GSK = 0L;
      if (localg.ilm != 1) {
        break label164;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.GSK) });
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(this.GSK, 5);
    }
    for (;;)
    {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label164:
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.GSK) });
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(this.GSK, 1);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.foK())
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.c(a.this) != 0L) || (a.d(a.this)))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)h.ag(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)h.ag(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject2;
      if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyr, false))
      {
        if (Util.isNullOrNil(a.b(a.this))) {
          break label1516;
        }
        localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().k(a.b(a.this), f1);
      }
      for (i = 1;; i = j)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bN(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().foS();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.foR())
          {
            localObject1 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bM(f2);
            if (MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", new Object[] { Boolean.valueOf(bool) });
              i = 3;
              if (localObject1 != null) {
                break;
              }
              a.a(a.this, 0L);
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
              AppMethodBeat.o(87844);
              return;
            }
            j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vys, 10);
            f3 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyt, 10.0F);
            if (Util.isNullOrNil(a.b(a.this))) {
              break label1510;
            }
            localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().b(a.b(a.this), j, f3);
            i = 5;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().u(j, f3);
            i = 6;
          }
          localObject2 = localObject1;
          j = i;
          if (localObject1 == null)
          {
            localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().foS();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.foR())
            {
              i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyu, 20);
              f3 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyv, 10.0F);
              localObject1 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().u(i, f3);
              i = 7;
              break;
              a.a(a.this, ((hs)localObject1).RNj);
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.c(a.this)), Double.valueOf(((hs)localObject1).RNg), Integer.valueOf(((hs)localObject1).RNh), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((n)h.ae(n.class)).eSe().Oq(a.c(a.this));
              localObject2 = com.tencent.mm.ay.q.bmh().C(((et)localObject1).field_talker, ((et)localObject1).field_msgSvrId);
              if (((g)localObject2).ilm == 1)
              {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", a.c(a.this) + " already has hd thumb");
                ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(a.c(a.this), 5);
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.aq.f.bkg().lHW.add("image_" + ((et)localObject1).field_msgId);
              if ((!Util.isNullOrNil(a.b(a.this))) && (a.b(a.this).equals(((et)localObject1).field_talker)))
              {
                j = com.tencent.mm.ay.q.bmi().a(((g)localObject2).localId, ((et)localObject1).field_msgId, 0, Long.valueOf(a.c(a.this)), a.e(a.this), a.this, 60000, true);
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.c(a.this)), "image_" + ((et)localObject1).field_msgId, a.b(a.this), Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = com.tencent.mm.ay.q.bmi().a(((g)localObject2).localId, ((et)localObject1).field_msgId, 0, Long.valueOf(a.c(a.this)), a.e(a.this), a.this, 60000, false);
                  Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.c(a.this)), "image_" + ((et)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(a.c(a.this), 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(a.c(a.this), 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(a.c(a.this), 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.a(a.this, 0L);
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(957L, 62L, 1L, false);
                }
              }
            }
          }
          break;
          label1510:
          localObject2 = null;
        }
        label1516:
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
      long l1 = TrafficStats.getUidRxBytes(a.f(a.this));
      long l2 = TrafficStats.getUidTxBytes(a.f(a.this));
      long l3 = l1 - a.g(a.this) + (l2 - a.h(a.this));
      if (l3 <= 20480L)
      {
        a.i(a.this);
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.b(a.this, l1);
      a.c(a.this, l2);
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.a
 * JD-Core Version:    0.7.0.1
 */