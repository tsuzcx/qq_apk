package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.am.s.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.n;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.at;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public class PluginZero
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.plugin.zero.a.d
{
  private static final int[] akjK = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a akjH;
  private b akjI;
  private final com.tencent.mm.app.i akjJ;
  public com.tencent.mm.plugin.zero.a.b akjL;
  public b akjM;
  public PluginZero.a akjN;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.akjH = new a();
    this.akjI = new b();
    this.akjJ = new com.tencent.mm.app.i();
    this.akjM = new b();
    this.akjN = new PluginZero.a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new u(at.acHq + "SdcardInfo.cfg").jKS())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.i.b.bmu() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.i.b.bmu();
    int i = 0;
    ap localap = new ap(at.acHq + "SdcardInfo.cfg");
    String str3 = (String)localap.d(1, "");
    int m = ((Integer)localap.d(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (Util.isNullOrNil(str3))
    {
      localap.B(1, str2);
      localap.B(2, Integer.valueOf(k));
      str1 = str2;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.i.b.F(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.aPU())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.aQd().equals("mounted")) || (!new u(str2).jKR())) {
            break label352;
          }
          localap.B(1, str2);
          localap.B(2, Integer.valueOf(k));
          com.tencent.mm.loader.i.b.F(str2, false);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.i.b.bmt(), Boolean.valueOf(com.tencent.mm.compatible.util.e.aPU()) });
        }
      }
    }
    for (;;)
    {
      if ((MMApplicationContext.isMainProcess()) && (j != 0))
      {
        ExtStorageMigrateMonitor.yy(140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.yy(141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label352:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.i.b.bmt(), Boolean.valueOf(com.tencent.mm.compatible.util.e.aPU()), str2 });
    }
  }
  
  private void setupStubLog()
  {
    AppMethodBeat.i(133018);
    com.tencent.stubs.logger.Log.setLogger(new PluginZero.3(this));
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
    parama = this.akjN.add(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.akjM.add(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(260981);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ao.SQL_CREATE;
      }
    });
    AppMethodBeat.o(260981);
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
      if (paramg.bbA())
      {
        com.tencent.mm.kernel.a.a.j("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.akjH));
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.akjI));
        com.tencent.mm.kernel.a.a.j("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.h localh = com.tencent.mm.kernel.h.baF();
        if (!localh.mDv)
        {
          localh.mDo = new com.tencent.mm.kernel.f(com.tencent.mm.kernel.a.c.baR());
          localh.mDp = new com.tencent.mm.kernel.b(com.tencent.mm.kernel.a.c.baR());
          localh.mDq = new com.tencent.mm.kernel.c(localh.mDs, localh.mCl);
          localh.mDr = new com.tencent.mm.ch.b(MMApplicationContext.getContext());
          localh.mDv = true;
        }
        NotifyReceiver.aKy();
        com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
        {
          public final void aDv()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.j("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void dZ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              n.w(paramg.bGP, true);
              n.x(paramg.bGP, true);
            }
            com.tencent.mm.sdk.platformtools.Log.appenderFlush();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.cp.i.agWI = new com.tencent.mm.vending.h.h(com.tencent.mm.cp.d.c(com.tencent.mm.kernel.h.baH().getWorkerHandler()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.cp.i.agWI);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.bbA()) || (paramg.FH(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.FH(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
        getClass().getClassLoader();
        k.DA("wechatbase");
        getClass().getClassLoader();
        k.DA("wechatnetwork");
        getClass().getClassLoader();
        k.DA("wechatmm");
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
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.baF().mDs.add(new s.a()
      {
        public final void a(s paramAnonymouss)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.akjJ.cs(paramg.bGP);
          AppMethodBeat.o(132998);
        }
        
        public final void a(s paramAnonymouss, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.aKz();
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
    this.akjL = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
  
  public static final class b
    extends com.tencent.mm.cp.a<com.tencent.mm.plugin.zero.a.c>
    implements com.tencent.mm.plugin.zero.a.c
  {
    public final void a(final NotifyReceiver.NotifyService paramNotifyService, final int paramInt, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final long paramLong)
    {
      AppMethodBeat.i(133011);
      a(new com.tencent.mm.cp.a.a() {});
      AppMethodBeat.o(133011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */