package com.tencent.mm.plugin.priority.model.c2c.img;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.c;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Calendar;
import java.util.HashSet;

public class a
  implements f.a, com.tencent.mm.plugin.priority.a.a.a.b
{
  public long MQo;
  private int MQp;
  private int MQq;
  private boolean MQr;
  private long MQs;
  private long MQt;
  public IListener oFU;
  public String talker;
  private int uid;
  
  public a()
  {
    AppMethodBeat.i(87846);
    this.MQo = 0L;
    this.MQp = 0;
    this.MQq = 0;
    this.talker = "";
    this.MQr = false;
    this.MQs = 0L;
    this.MQt = 0L;
    this.oFU = new C2CImgAutoDownloader.1(this, com.tencent.mm.app.f.hfK);
    this.uid = Process.myUid();
    this.oFU.alive();
    this.MQp = b.c.chat_img_template;
    AppMethodBeat.o(87846);
  }
  
  public static boolean gzV()
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
      com.tencent.mm.kernel.h.baC();
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
    this.MQo = 0L;
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, false, true);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 57L, 1L, false);
    AppMethodBeat.o(87850);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(87849);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, false, false);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 53L, 1L, false);
    }
    for (;;)
    {
      this.MQo = 0L;
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
      this.MQr = true;
      this.MQs = TrafficStats.getUidRxBytes(this.uid);
      this.MQt = TrafficStats.getUidTxBytes(this.uid);
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getPriorityTaskRunner().b(new b((byte)0));
      AppMethodBeat.o(87849);
      return;
      b(paramLong1, paramLong2, true);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, true, false);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 54L, 1L, false);
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
      long l1 = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJc, null), 0L);
      long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
      Log.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acJc, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acJd, Long.valueOf(l2));
      AppMethodBeat.o(87848);
      return;
    }
    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(87848);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87847);
    if (this.MQo != 0L)
    {
      com.tencent.mm.modelimage.h localh = r.bKa().H(this.talker, this.MQo);
      if ((localh != null) && (r.bKb().c(localh.localId, this.MQo, localh.oGu)))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", new Object[] { Long.valueOf(this.MQo) });
        AppMethodBeat.o(87847);
        return;
      }
      this.MQo = 0L;
      if (localh.kLl != 1) {
        break label168;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.MQo) });
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(this.MQo, 5);
    }
    for (;;)
    {
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getPriorityTaskRunner().a(new a((byte)0));
      AppMethodBeat.o(87847);
      return;
      label168:
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", new Object[] { Long.valueOf(this.MQo) });
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(this.MQo, 1);
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private a() {}
    
    public final String getName()
    {
      return "Priority.C2CImgAutoDownloaderTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87844);
      if (!com.tencent.mm.plugin.priority.a.a.a.a.gzN())
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
        AppMethodBeat.o(87844);
        return;
      }
      if ((a.d(a.this) != 0L) || (a.e(a.this)))
      {
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(a.d(a.this)), Boolean.valueOf(a.e(a.this)) });
        AppMethodBeat.o(87844);
        return;
      }
      float f1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getImgBorderPriority();
      float f2 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getImgBgBorderPriority();
      int i = 0;
      int j = 0;
      Object localObject2;
      if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLT, false))
      {
        if (Util.isNullOrNil(a.c(a.this))) {
          break label1668;
        }
        localObject2 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().l(a.c(a.this), f1);
      }
      for (i = 1;; i = j)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().cR(f1);
          i = 2;
        }
        localObject2 = localObject1;
        j = i;
        if (localObject1 == null)
        {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().gzW();
          j = 4;
        }
        localObject1 = localObject2;
        i = j;
        float f3;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          i = j;
          if (a.gzV())
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().cQ(f2);
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
            j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLU, 10);
            f3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLV, 10.0F);
            if (Util.isNullOrNil(a.c(a.this))) {
              break label1662;
            }
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().b(a.c(a.this), j, f3);
            i = 5;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().x(j, f3);
            i = 6;
          }
          localObject2 = localObject1;
          j = i;
          if (localObject1 == null)
          {
            localObject2 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().gzW();
            j = 4;
          }
          localObject1 = localObject2;
          i = j;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            i = j;
            if (a.gzV())
            {
              i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLW, 20);
              f3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLX, 10.0F);
              localObject1 = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().x(i, f3);
              i = 7;
              break;
              a.a(a.this, ((io)localObject1).YKx);
              Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(a.d(a.this)), Double.valueOf(((io)localObject1).YKu), Integer.valueOf(((io)localObject1).YKv), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(a.d(a.this));
              if (localObject1 == null)
              {
                Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "can't get msgInfo of " + a.d(a.this));
                ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().delete(a.d(a.this));
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              localObject2 = r.bKa().G(((fi)localObject1).field_talker, ((fi)localObject1).field_msgSvrId);
              if (localObject2 == null)
              {
                Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "can't get imgInfo of " + a.d(a.this));
                ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().delete(a.d(a.this));
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              if (((com.tencent.mm.modelimage.h)localObject2).kLl == 1)
              {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", a.d(a.this) + " already has hd thumb");
                ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(a.d(a.this), 5);
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
              }
              k.bHW().oAv.add("image_" + ((fi)localObject1).field_msgId);
              if ((!Util.isNullOrNil(a.c(a.this))) && (a.c(a.this).equals(((fi)localObject1).field_talker)))
              {
                j = r.bKb().a(((com.tencent.mm.modelimage.h)localObject2).localId, ((fi)localObject1).field_msgId, 0, Long.valueOf(a.d(a.this)), a.f(a.this), a.this, 60000, true);
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(a.d(a.this)), "image_" + ((fi)localObject1).field_msgId, a.c(a.this), Integer.valueOf(j) });
              }
              for (;;)
              {
                switch (j)
                {
                default: 
                  AppMethodBeat.o(87844);
                  return;
                  j = r.bKb().a(((com.tencent.mm.modelimage.h)localObject2).localId, ((fi)localObject1).field_msgId, 0, Long.valueOf(a.d(a.this)), a.f(a.this), a.this, 60000, false);
                  Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(a.d(a.this)), "image_" + ((fi)localObject1).field_msgId, Integer.valueOf(j) });
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(a.d(a.this), 2);
              if (i == 3)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 52L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 1)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 50L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 4)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 57L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 5)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 58L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 6)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 59L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              if (i == 7)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 60L, 1L, false);
                AppMethodBeat.o(87844);
                return;
              }
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 51L, 1L, false);
              AppMethodBeat.o(87844);
              return;
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(a.d(a.this), 3);
              if (i == 3) {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 55L, 1L, false);
              }
              for (;;)
              {
                a.a(a.this, 0L);
                a.this.start();
                AppMethodBeat.o(87844);
                return;
                if (i == 7) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 61L, 1L, false);
                }
              }
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(a.d(a.this), 4);
              if (i == 3) {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 56L, 1L, false);
              }
              for (;;)
              {
                a.a(a.this, 0L);
                a.this.start();
                break;
                if (i == 7) {
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(957L, 62L, 1L, false);
                }
              }
            }
          }
          break;
          label1662:
          localObject2 = null;
        }
        label1668:
        localObject2 = null;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private b() {}
    
    public final String getName()
    {
      return "Priority.CheckNetworkNetStatTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87845);
      long l1 = TrafficStats.getUidRxBytes(a.g(a.this));
      long l2 = TrafficStats.getUidTxBytes(a.g(a.this));
      long l3 = l1 - a.h(a.this) + (l2 - a.i(a.this));
      if (l3 <= 20480L)
      {
        a.j(a.this);
        a.this.start();
        AppMethodBeat.o(87845);
        return;
      }
      Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
      a.b(a.this, l1);
      a.c(a.this, l2);
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getPriorityTaskRunner().b(new b(a.this));
      AppMethodBeat.o(87845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.img.a
 * JD-Core Version:    0.7.0.1
 */