package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.al.q.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cn.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.al;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vending.h.h;
import com.tencent.stubs.logger.Log;
import com.tencent.stubs.logger.Log.Logger;
import java.util.HashMap;

public class PluginZero
  extends f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.plugin.zero.a.d
{
  private static final int[] Oen = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a Oek;
  private b Oel;
  private final com.tencent.mm.app.g Oem;
  public com.tencent.mm.plugin.zero.a.b Oeo;
  public b Oep;
  public a Oeq;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.Oek = new a();
    this.Oel = new b();
    this.Oem = new com.tencent.mm.app.g();
    this.Oep = new b();
    this.Oeq = new a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new com.tencent.mm.vfs.e(al.IpN + "SdcardInfo.cfg").exists())
    {
      ad.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.j.b.arP() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.j.b.arP();
    int i = 0;
    ah localah = new ah(al.IpN + "SdcardInfo.cfg");
    String str3 = (String)localah.get(1, "");
    int m = ((Integer)localah.get(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (bt.isNullOrNil(str3))
    {
      localah.set(1, str2);
      localah.set(2, Integer.valueOf(k));
      str1 = str2;
      ad.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.j.b.z(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.abf())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) || (!new com.tencent.mm.vfs.e(str2).canWrite())) {
            break label352;
          }
          localah.set(1, str2);
          localah.set(2, Integer.valueOf(k));
          com.tencent.mm.loader.j.b.z(str2, false);
          ad.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.j.b.arO(), Boolean.valueOf(com.tencent.mm.compatible.util.e.abf()) });
        }
      }
    }
    for (;;)
    {
      if ((aj.cmR()) && (j != 0))
      {
        ExtStorageMigrateMonitor.CQ(140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.CQ(141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label352:
      ad.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.j.b.arO(), Boolean.valueOf(com.tencent.mm.compatible.util.e.abf()), str2 });
    }
  }
  
  private void setupStubLog()
  {
    AppMethodBeat.i(133018);
    Log.setLogger(new Log.Logger()
    {
      public final boolean isLoggable(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(133000);
        if ((paramAnonymousInt >= 2) && (paramAnonymousInt <= 7) && (PluginZero.Oen[paramAnonymousInt] >= ad.getLogLevel()))
        {
          AppMethodBeat.o(133000);
          return true;
        }
        AppMethodBeat.o(133000);
        return false;
      }
      
      public final void println(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(132999);
        if (!isLoggable(paramAnonymousString1, paramAnonymousInt))
        {
          AppMethodBeat.o(132999);
          return;
        }
        ad.a locala = ad.fkt();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(132999);
          return;
        case 2: 
          locala.logV(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 3: 
          locala.logD(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 4: 
          locala.logI(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 5: 
          locala.logW(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 6: 
          locala.logE(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        }
        locala.logF(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
        AppMethodBeat.o(132999);
      }
    });
    AppMethodBeat.o(133018);
  }
  
  private void setupVendingLog()
  {
    AppMethodBeat.i(133019);
    com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133004);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133004);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133001);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133001);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133003);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133003);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133005);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133005);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133002);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133002);
      }
    });
    AppMethodBeat.o(133019);
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    AppMethodBeat.i(133021);
    parama = this.Oeq.bu(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    ad.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.Oep.bu(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(189864);
    ad.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ag.SQL_CREATE;
      }
    });
    AppMethodBeat.o(189864);
    return localHashMap;
  }
  
  public void configure(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(133015);
    try
    {
      initSDRoot();
      com.tencent.mm.kernel.a.a.k("configure [%s], setup broken library handler...", new Object[] { this });
      setupStubLog();
      setupVendingLog();
      if (paramg.akw())
      {
        com.tencent.mm.kernel.a.a.k("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.Oek));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.Oel));
        com.tencent.mm.kernel.a.a.k("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.ajD();
        if (!localg.gBW)
        {
          localg.gBP = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.ajP());
          localg.gBQ = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.ajP());
          localg.gBR = new com.tencent.mm.kernel.b(localg.gBT, localg.gAN);
          localg.gBS = new com.tencent.mm.ch.b(aj.getContext());
          localg.gBW = true;
        }
        NotifyReceiver.WI();
        com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
        {
          public final void MP()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.k("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void cg(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              l.q(paramg.ca, true);
              l.r(paramg.ca, true);
            }
            ad.fku();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.g.ajD();
        i.LAV = new h(com.tencent.mm.cn.d.c(com.tencent.mm.kernel.g.ajF().cWY()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.LAV);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.akw()) || (paramg.xf(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.xf(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(aj.getContext()));
        getClass().getClassLoader();
        j.vr("wechatbase");
        getClass().getClassLoader();
        j.vr("wechatnetwork");
        getClass().getClassLoader();
        j.vr("wechatmm");
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      AppMethodBeat.o(133015);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
      }
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(133014);
    dependsOnRoot();
    AppMethodBeat.o(133014);
  }
  
  public void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(133017);
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.ajD().gBT.bu(new q.a()
      {
        public final void a(q paramAnonymousq)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.Oem.bl(paramg.ca);
          AppMethodBeat.o(132998);
        }
        
        public final void a(q paramAnonymousq, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.WJ();
    }
    AppMethodBeat.o(133017);
  }
  
  public void installed()
  {
    AppMethodBeat.i(133013);
    alias(com.tencent.mm.plugin.zero.a.d.class);
    AppMethodBeat.o(133013);
  }
  
  public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b paramb)
  {
    this.Oeo = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
  
  public static final class a
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.zero.a.a>
    implements com.tencent.mm.plugin.zero.a.a
  {
    public final void a(final Service paramService)
    {
      AppMethodBeat.i(133008);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(133008);
    }
    
    public final void b(final Service paramService)
    {
      AppMethodBeat.i(133009);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(133009);
    }
  }
  
  public static final class b
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.zero.a.c>
    implements com.tencent.mm.plugin.zero.a.c
  {
    public final void a(final NotifyReceiver.NotifyService paramNotifyService, final int paramInt, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final long paramLong)
    {
      AppMethodBeat.i(133011);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(133011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */