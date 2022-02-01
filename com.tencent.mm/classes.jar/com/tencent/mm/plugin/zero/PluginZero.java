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
import com.tencent.mm.co.i;
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
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vending.h.h;
import com.tencent.stubs.logger.Log;
import com.tencent.stubs.logger.Log.Logger;

public class PluginZero
  extends f
  implements com.tencent.mm.plugin.zero.a.d
{
  private static final int[] Lwo = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a Lwl;
  private b Lwm;
  private final com.tencent.mm.app.g Lwn;
  public com.tencent.mm.plugin.zero.a.b Lwp;
  public b Lwq;
  public a Lwr;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.Lwl = new a();
    this.Lwm = new b();
    this.Lwn = new com.tencent.mm.app.g();
    this.Lwq = new b();
    this.Lwr = new a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new com.tencent.mm.vfs.e(ae.FfH + "SdcardInfo.cfg").exists())
    {
      ad.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.j.b.aic() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.j.b.aic();
    int i = 0;
    aa localaa = new aa(ae.FfH + "SdcardInfo.cfg");
    String str3 = (String)localaa.get(1, "");
    int m = ((Integer)localaa.get(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (bt.isNullOrNil(str3))
    {
      localaa.set(1, str2);
      localaa.set(2, Integer.valueOf(k));
      str1 = str2;
      ad.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.j.b.y(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.XG())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) || (!new com.tencent.mm.vfs.e(str2).canWrite())) {
            break label358;
          }
          localaa.set(1, str2);
          localaa.set(2, Integer.valueOf(k));
          com.tencent.mm.loader.j.b.y(str2, false);
          ad.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.j.b.aib(), Boolean.valueOf(com.tencent.mm.compatible.util.e.XG()) });
        }
      }
    }
    for (;;)
    {
      if ((aj.cbe()) && (j != 0))
      {
        ExtStorageMigrateMonitor.at(1315L, 140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.at(1315L, 141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label358:
      ad.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.j.b.aib(), Boolean.valueOf(com.tencent.mm.compatible.util.e.XG()), str2 });
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
        if ((paramAnonymousInt >= 2) && (paramAnonymousInt <= 7) && (PluginZero.Lwo[paramAnonymousInt] >= ad.getLogLevel()))
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
        ad.a locala = ad.eFv();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(132999);
          return;
        case 2: 
          locala.logV(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 3: 
          locala.logD(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 4: 
          locala.logI(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 5: 
          locala.logW(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 6: 
          locala.logE(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        }
        locala.logF(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
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
    parama = this.Lwr.bv(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    ad.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.Lwq.bv(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public void configure(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(133015);
    try
    {
      initSDRoot();
      aj.setProcessName(paramg.mProcessName);
      com.tencent.mm.kernel.a.a.h("configure [%s], setup broken library handler...", new Object[] { this });
      setupStubLog();
      setupVendingLog();
      if (paramg.agu())
      {
        com.tencent.mm.kernel.a.a.h("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.Lwl));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.Lwm));
        com.tencent.mm.kernel.a.a.h("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.afC();
        if (!localg.gdG)
        {
          localg.gdz = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.afO());
          localg.gdA = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.afO());
          localg.gdB = new com.tencent.mm.kernel.b(localg.gdD, localg.gcx);
          localg.gdC = new com.tencent.mm.ci.b(aj.getContext());
          localg.gdG = true;
        }
        NotifyReceiver.Tx();
        com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
        {
          public final void Lk()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.h("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void ce(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              l.o(paramg.ca, true);
              l.p(paramg.ca, true);
            }
            ad.eFw();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.g.afC();
        i.Igq = new h(com.tencent.mm.co.d.c(com.tencent.mm.kernel.g.afE().cBt()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.Igq);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.agu()) || (paramg.ra(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.ra(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(aj.getContext()));
        getClass().getClassLoader();
        j.pq("wechatbase");
        getClass().getClassLoader();
        j.pq("wechatnetwork");
        getClass().getClassLoader();
        j.pq("wechatmm");
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
    if (paramg.agu())
    {
      com.tencent.mm.kernel.g.afC().gdD.bv(new q.a()
      {
        public final void a(q paramAnonymousq)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.Lwn.bk(paramg.ca);
          AppMethodBeat.o(132998);
        }
        
        public final void a(q paramAnonymousq, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.Ty();
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
    this.Lwp = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
  
  public static final class a
    extends com.tencent.mm.co.a<com.tencent.mm.plugin.zero.a.a>
    implements com.tencent.mm.plugin.zero.a.a
  {
    public final void a(final Service paramService)
    {
      AppMethodBeat.i(133008);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(133008);
    }
    
    public final void b(final Service paramService)
    {
      AppMethodBeat.i(133009);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(133009);
    }
  }
  
  public static final class b
    extends com.tencent.mm.co.a<com.tencent.mm.plugin.zero.a.c>
    implements com.tencent.mm.plugin.zero.a.c
  {
    public final void a(final NotifyReceiver.NotifyService paramNotifyService, final int paramInt, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final long paramLong)
    {
      AppMethodBeat.i(133011);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(133011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */