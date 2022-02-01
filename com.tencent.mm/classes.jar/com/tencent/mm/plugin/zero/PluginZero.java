package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.cm.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vfs.k;
import com.tencent.stubs.logger.Log;
import java.util.HashMap;

public class PluginZero
  extends f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.plugin.zero.a.d
{
  private static final int[] LGm = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a LGj;
  private b LGk;
  private final com.tencent.mm.app.g LGl;
  public com.tencent.mm.plugin.zero.a.b LGn;
  public b LGo;
  public a LGp;
  
  public PluginZero()
  {
    AppMethodBeat.i(133012);
    this.LGj = new a();
    this.LGk = new b();
    this.LGl = new com.tencent.mm.app.g();
    this.LGo = new b();
    this.LGp = new a();
    AppMethodBeat.o(133012);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(133016);
    if (!new k(am.IKh + "SdcardInfo.cfg").exists())
    {
      ae.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.loader.j.b.ase() });
      AppMethodBeat.o(133016);
      return;
    }
    String str2 = com.tencent.mm.loader.j.b.ase();
    int i = 0;
    ai localai = new ai(am.IKh + "SdcardInfo.cfg");
    String str3 = (String)localai.get(1, "");
    int m = ((Integer)localai.get(2, Integer.valueOf(0))).intValue();
    int k = Build.VERSION.SDK_INT;
    String str1;
    int j;
    if (bu.isNullOrNil(str3))
    {
      localai.set(1, str2);
      localai.set(2, Integer.valueOf(k));
      str1 = str2;
      ae.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(m), Integer.valueOf(k) });
      com.tencent.mm.loader.j.b.z(str1, false);
      j = i;
      if (m != k)
      {
        j = i;
        if (!com.tencent.mm.compatible.util.e.abo())
        {
          j = 0;
          if ((!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) || (!new k(str2).canWrite())) {
            break label352;
          }
          localai.set(1, str2);
          localai.set(2, Integer.valueOf(k));
          com.tencent.mm.loader.j.b.z(str2, false);
          ae.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.loader.j.b.asd(), Boolean.valueOf(com.tencent.mm.compatible.util.e.abo()) });
        }
      }
    }
    for (;;)
    {
      if ((ak.coh()) && (j != 0))
      {
        ExtStorageMigrateMonitor.Do(140L);
        if (!str2.equals(str1)) {
          ExtStorageMigrateMonitor.Do(141L);
        }
      }
      AppMethodBeat.o(133016);
      return;
      i = 1;
      str1 = str3;
      break;
      label352:
      ae.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.loader.j.b.asd(), Boolean.valueOf(com.tencent.mm.compatible.util.e.abo()), str2 });
    }
  }
  
  private void setupStubLog()
  {
    AppMethodBeat.i(133018);
    Log.setLogger(new PluginZero.3(this));
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
    parama = this.LGp.bu(parama);
    AppMethodBeat.o(133021);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(133020);
    ae.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.LGo.bu(paramc);
    AppMethodBeat.o(133020);
    return paramc;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(193582);
    ae.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new PluginZero.5(this));
    AppMethodBeat.o(193582);
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
      if (paramg.akL())
      {
        com.tencent.mm.kernel.a.a.k("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.LGj));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.LGk));
        com.tencent.mm.kernel.a.a.k("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.ajS();
        if (!localg.gED)
        {
          localg.gEw = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.ake());
          localg.gEx = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.ake());
          localg.gEy = new com.tencent.mm.kernel.b(localg.gEA, localg.gDu);
          localg.gEz = new com.tencent.mm.cg.b(ak.getContext());
          localg.gED = true;
        }
        NotifyReceiver.WQ();
        com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
        {
          public final void ML()
          {
            AppMethodBeat.i(132996);
            com.tencent.mm.kernel.a.a.k("onStartupDone", new Object[0]);
            AppMethodBeat.o(132996);
          }
          
          public final void ch(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(132997);
            if (paramAnonymousBoolean)
            {
              l.q(paramg.ca, true);
              l.r(paramg.ca, true);
            }
            ae.foo();
            AppMethodBeat.o(132997);
          }
        });
        com.tencent.mm.kernel.g.ajS();
        i.LXW = new h(com.tencent.mm.cm.d.c(com.tencent.mm.kernel.g.ajU().cZF()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.LXW);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.akL()) || (paramg.xO(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.xO(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(ak.getContext()));
        getClass().getClassLoader();
        j.vN("wechatbase");
        getClass().getClassLoader();
        j.vN("wechatnetwork");
        getClass().getClassLoader();
        j.vN("wechatmm");
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      AppMethodBeat.o(133015);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
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
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.ajS().gEA.bu(new q.a()
      {
        public final void a(q paramAnonymousq)
        {
          AppMethodBeat.i(132998);
          PluginZero.this.LGl.bm(paramg.ca);
          AppMethodBeat.o(132998);
        }
        
        public final void a(q paramAnonymousq, boolean paramAnonymousBoolean) {}
      });
      NotifyReceiver.WR();
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
    this.LGn = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
  
  public static final class a
    extends com.tencent.mm.cm.a<com.tencent.mm.plugin.zero.a.a>
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
    extends com.tencent.mm.cm.a<com.tencent.mm.plugin.zero.a.c>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */