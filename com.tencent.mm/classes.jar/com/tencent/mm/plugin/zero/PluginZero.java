package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.an.t.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cw.i;
import com.tencent.mm.kernel.n;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import com.tencent.stubs.logger.Log.Logger;
import java.util.HashMap;

public class PluginZero
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.plugin.zero.a.d
{
  private static final int[] Svk = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a SuX;
  private b SuZ;
  public a SvF;
  private final com.tencent.mm.app.g Svj;
  public com.tencent.mm.plugin.zero.a.b Svl;
  public PluginZero.b Svm;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.SuX = new a();
    this.SuZ = new b();
    this.Svj = new com.tencent.mm.app.g();
    this.Svm = new PluginZero.b();
    this.SvF = new a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new q(ar.Vgb + "SdcardInfo.cfg").ifE())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.j.b.aSG() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.j.b.aSG();
    int i = 0;
    an localan = new an(ar.Vgb + "SdcardInfo.cfg");
    String str3 = (String)localan.b(1, "");
    int m = ((Integer)localan.b(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (Util.isNullOrNil(str3))
    {
      localan.i(1, str2);
      localan.i(2, Integer.valueOf(k));
      str1 = str2;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.j.b.C(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.avA())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.avJ().equals("mounted")) || (!new q(str2).ifD())) {
            break label352;
          }
          localan.i(1, str2);
          localan.i(2, Integer.valueOf(k));
          com.tencent.mm.loader.j.b.C(str2, false);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.j.b.aSF(), Boolean.valueOf(com.tencent.mm.compatible.util.e.avA()) });
        }
      }
    }
    for (;;)
    {
      if ((MMApplicationContext.isMainProcess()) && (j != 0))
      {
        ExtStorageMigrateMonitor.Um(140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.Um(141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label352:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.j.b.aSF(), Boolean.valueOf(com.tencent.mm.compatible.util.e.avA()), str2 });
    }
  }
  
  private void setupStubLog()
  {
    AppMethodBeat.i(133018);
    com.tencent.stubs.logger.Log.setLogger(new Log.Logger()
    {
      public final boolean isLoggable(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(133000);
        if ((paramAnonymousInt >= 2) && (paramAnonymousInt <= 7) && (PluginZero.Svk[paramAnonymousInt] >= com.tencent.mm.sdk.platformtools.Log.getLogLevel()))
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
        Log.LogImp localLogImp = com.tencent.mm.sdk.platformtools.Log.getImpl();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(132999);
          return;
        case 2: 
          localLogImp.logV(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 3: 
          localLogImp.logD(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 4: 
          localLogImp.logI(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 5: 
          localLogImp.logW(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        case 6: 
          localLogImp.logE(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(132999);
          return;
        }
        localLogImp.logF(0L, paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
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
        com.tencent.mm.sdk.platformtools.Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133004);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133001);
        com.tencent.mm.sdk.platformtools.Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133001);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133003);
        com.tencent.mm.sdk.platformtools.Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133003);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133005);
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133005);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(133002);
        com.tencent.mm.sdk.platformtools.Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(133002);
      }
    });
    AppMethodBeat.o(133019);
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    AppMethodBeat.i(133021);
    parama = this.SvF.add(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.Svm.add(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(198761);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return am.SQL_CREATE;
      }
    });
    AppMethodBeat.o(198761);
    return localHashMap;
  }
  
  public void configure(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(133015);
    try
    {
      initSDRoot();
      com.tencent.mm.kernel.a.a.j("configure [%s], setup broken library handler...", new Object[] { this });
      setupStubLog();
      setupVendingLog();
      if (paramg.aIE())
      {
        com.tencent.mm.kernel.a.a.j("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.SuX));
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.SuZ));
        com.tencent.mm.kernel.a.a.j("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.h localh = com.tencent.mm.kernel.h.aHH();
        if (!localh.kdm)
        {
          localh.kdf = new com.tencent.mm.kernel.f(com.tencent.mm.kernel.a.c.aHV());
          localh.kdg = new com.tencent.mm.kernel.b(com.tencent.mm.kernel.a.c.aHV());
          localh.kdh = new com.tencent.mm.kernel.c(localh.kdj, localh.kcc);
          localh.kdi = new com.tencent.mm.cn.b(MMApplicationContext.getContext());
          localh.kdm = true;
        }
        NotifyReceiver.aqA();
        com.tencent.mm.kernel.h.aHH().a(new com.tencent.mm.kernel.api.g()
        {
          public final void abB()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.j("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void dn(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              n.v(paramg.Zw, true);
              n.w(paramg.Zw, true);
            }
            com.tencent.mm.sdk.platformtools.Log.appenderFlush();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.h.aHH();
        i.YYx = new com.tencent.mm.vending.h.h(com.tencent.mm.cw.d.b(com.tencent.mm.kernel.h.aHJ().getWorkerHandler()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.YYx);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.aIE()) || (paramg.MY(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.MY(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
        getClass().getClassLoader();
        j.KW("wechatbase");
        getClass().getClassLoader();
        j.KW("wechatnetwork");
        getClass().getClassLoader();
        j.KW("wechatmm");
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      AppMethodBeat.o(133015);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
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
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.aHH().kdj.add(new t.a()
      {
        public final void a(t paramAnonymoust)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.Svj.bF(paramg.Zw);
          AppMethodBeat.o(132998);
        }
        
        public final void a(t paramAnonymoust, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.aqB();
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
    this.Svl = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
  
  public static final class a
    extends com.tencent.mm.cw.a<com.tencent.mm.plugin.zero.a.a>
    implements com.tencent.mm.plugin.zero.a.a
  {
    public final void a(final Service paramService)
    {
      AppMethodBeat.i(133008);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(133008);
    }
    
    public final void b(final Service paramService)
    {
      AppMethodBeat.i(133009);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(133009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */