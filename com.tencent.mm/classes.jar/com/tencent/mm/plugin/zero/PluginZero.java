package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.cn.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.ac.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vending.h.h;
import com.tencent.stubs.logger.Log;
import com.tencent.stubs.logger.Log.Logger;
import java.util.HashMap;

public class PluginZero
  extends f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.plugin.zero.a.d
{
  private static final int[] Hao = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a Hal;
  private b Ham;
  private final com.tencent.mm.app.g Han;
  public com.tencent.mm.plugin.zero.a.b Hap;
  public b Haq;
  public a Har;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.Hal = new a();
    this.Ham = new b();
    this.Han = new com.tencent.mm.app.g();
    this.Haq = new b();
    this.Har = new a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new com.tencent.mm.vfs.e(ah.GDu + "SdcardInfo.cfg").exists())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.j.b.apc() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.j.b.apc();
    int i = 0;
    ad localad = new ad(ah.GDu + "SdcardInfo.cfg");
    String str3 = (String)localad.get(1, "");
    int m = ((Integer)localad.get(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (bs.isNullOrNil(str3))
    {
      localad.set(1, str2);
      localad.set(2, Integer.valueOf(k));
      str1 = str2;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.j.b.z(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.YD())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) || (!new com.tencent.mm.vfs.e(str2).canWrite())) {
            break label358;
          }
          localad.set(1, str2);
          localad.set(2, Integer.valueOf(k));
          com.tencent.mm.loader.j.b.z(str2, false);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.j.b.apb(), Boolean.valueOf(com.tencent.mm.compatible.util.e.YD()) });
        }
      }
    }
    for (;;)
    {
      if ((ai.cin()) && (j != 0))
      {
        ExtStorageMigrateMonitor.as(1315L, 140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.as(1315L, 141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label358:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.j.b.apb(), Boolean.valueOf(com.tencent.mm.compatible.util.e.YD()), str2 });
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
        if ((paramAnonymousInt >= 2) && (paramAnonymousInt <= 7) && (PluginZero.Hao[paramAnonymousInt] >= com.tencent.mm.sdk.platformtools.ac.getLogLevel()))
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
        ac.a locala = com.tencent.mm.sdk.platformtools.ac.eUP();
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
    com.tencent.mm.vending.f.a.a(new PluginZero.4(this));
    AppMethodBeat.o(133019);
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    AppMethodBeat.i(133021);
    parama = this.Har.bs(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.Haq.bs(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(206901);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.ac.SQL_CREATE;
      }
    });
    AppMethodBeat.o(206901);
    return localHashMap;
  }
  
  public void configure(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(133015);
    try
    {
      initSDRoot();
      ai.setProcessName(paramg.mProcessName);
      com.tencent.mm.kernel.a.a.h("configure [%s], setup broken library handler...", new Object[] { this });
      setupStubLog();
      setupVendingLog();
      if (paramg.ahL())
      {
        com.tencent.mm.kernel.a.a.h("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.Hal));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.Ham));
        com.tencent.mm.kernel.a.a.h("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.agS();
        if (!localg.gim)
        {
          localg.gif = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.ahe());
          localg.gig = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.ahe());
          localg.gih = new com.tencent.mm.kernel.b(localg.gij, localg.ghd);
          localg.gii = new com.tencent.mm.ch.b(ai.getContext());
          localg.gim = true;
        }
        NotifyReceiver.Ur();
        com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
        {
          public final void Lh()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.h("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void cf(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              l.o(paramg.ca, true);
              l.p(paramg.ca, true);
            }
            com.tencent.mm.sdk.platformtools.ac.eUQ();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.g.agS();
        i.JHS = new h(com.tencent.mm.cn.d.c(com.tencent.mm.kernel.g.agU().cOC()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.JHS);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.ahL()) || (paramg.up(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.up(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(ai.getContext()));
        getClass().getClassLoader();
        j.sC("wechatbase");
        getClass().getClassLoader();
        j.sC("wechatnetwork");
        getClass().getClassLoader();
        j.sC("wechatmm");
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      AppMethodBeat.o(133015);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
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
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.agS().gij.bs(new q.a()
      {
        public final void a(q paramAnonymousq)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.Han.bl(paramg.ca);
          AppMethodBeat.o(132998);
        }
        
        public final void a(q paramAnonymousq, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.Us();
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
    this.Hap = paramb;
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
      a(new a.a() {});
      AppMethodBeat.o(133008);
    }
    
    public final void b(final Service paramService)
    {
      AppMethodBeat.i(133009);
      a(new a.a() {});
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
      a(new a.a() {});
      AppMethodBeat.o(133011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */