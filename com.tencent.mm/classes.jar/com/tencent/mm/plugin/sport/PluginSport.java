package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.message.k.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.k.a;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.plugin.sport.model.n.a;
import com.tencent.mm.plugin.sport.model.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public class PluginSport
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.plugin.sport.a.b SaO;
  private com.tencent.mm.plugin.sport.model.a SaP;
  private com.tencent.mm.plugin.sport.model.b SaQ;
  private k.a SaR;
  private com.tencent.mm.plugin.sport.model.h SaS;
  private BroadcastReceiver SaT;
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.SaR = new k.a()
    {
      public final void cwC()
      {
        AppMethodBeat.i(263896);
        PluginSport.this.getDeviceStepManager().htY();
        AppMethodBeat.o(263896);
      }
    };
    this.SaT = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(149250);
        if ("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) {
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(263894);
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 3L, 1L, false);
              if ((p.jX(MMApplicationContext.getContext())) && (p.htT())) {
                PluginSport.this.getDeviceStepManager().htV();
              }
              AppMethodBeat.o(263894);
            }
          }, "UploadSportStepEventHandle");
        }
        AppMethodBeat.o(149250);
      }
    };
    AppMethodBeat.o(149251);
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(149252);
    Object localObject;
    if (MMApplicationContext.isPushProcess())
    {
      localObject = n.Scc;
      if (!y.ZC(com.tencent.mm.plugin.sport.a.a.Sbk)) {}
    }
    try
    {
      localObject = new l(com.tencent.mm.plugin.sport.a.a.Sbk);
      locala = new n.a();
      locala.SbH = (((l)localObject).amW(202) * 10000L);
      locala.SbF = ((l)localObject).amW(201);
      locala.SbE = ((l)localObject).amW(203);
      locala.SbI = ((l)localObject).amW(204);
      locala.SbK = ((l)localObject).amW(209);
      locala.SbG = locala.SbF;
      locala.SbJ = locala.SbI;
      n.hur().encode("KEY_STEP_DETAIL_INFO", locala.toString());
      y.deleteFile(com.tencent.mm.plugin.sport.a.a.Sbk);
      Log.i("MicroMsg.Sport.SportKvStorage", "compat first file:" + com.tencent.mm.plugin.sport.a.a.Sbk + " detailInfo:" + locala);
      if (!y.ZC(com.tencent.mm.plugin.sport.a.a.Sbl)) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        localObject = new l(com.tencent.mm.plugin.sport.a.a.Sbl);
        localObject = ((l)localObject).bbx("");
        n.a locala = new n.a();
        kotlin.g.b.s.s(localObject, "info");
        locala.bby((String)localObject);
        n.hur().encode("KEY_STEP_DETAIL_INFO", locala.toString());
        y.deleteFile(com.tencent.mm.plugin.sport.a.a.Sbl);
        Log.i("MicroMsg.Sport.SportKvStorage", "compat second file:" + com.tencent.mm.plugin.sport.a.a.Sbl + " detailInfo:" + locala);
        if (paramg.bbA())
        {
          this.SaO = new c();
          com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.SaO));
          AppMethodBeat.o(149252);
          return;
          localOutOfMemoryError1 = localOutOfMemoryError1;
          Log.printErrStackTrace("MicroMsg.Sport.SportKvStorage", (Throwable)localOutOfMemoryError1, "", new Object[0]);
          y.deleteFile(com.tencent.mm.plugin.sport.a.a.Sbk);
          l locall1 = new l(com.tencent.mm.plugin.sport.a.a.Sbk);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Sport.SportKvStorage", (Throwable)localOutOfMemoryError2, "", new Object[0]);
          y.deleteFile(com.tencent.mm.plugin.sport.a.a.Sbl);
          l locall2 = new l(com.tencent.mm.plugin.sport.a.a.Sbl);
        }
        if (MMApplicationContext.isPushProcess())
        {
          getPushSportStepDetector();
          SportForegroundService.huo();
        }
        AppMethodBeat.o(149252);
      }
    }
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.SaP;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.SaQ;
  }
  
  public com.tencent.mm.plugin.sport.model.h getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((MMApplicationContext.isPushProcess()) && (this.SaS == null)) {
      this.SaS = new com.tencent.mm.plugin.sport.model.h();
    }
    com.tencent.mm.plugin.sport.model.h localh = this.SaS;
    AppMethodBeat.o(149257);
    return localh;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(149253);
    this.SaP = new com.tencent.mm.plugin.sport.model.a();
    this.SaQ = new com.tencent.mm.plugin.sport.model.b();
    k.a(this.SaR);
    this.SaR.cwC();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    MMApplicationContext.getContext().registerReceiver(this.SaT, paramc);
    k.c.a(new com.tencent.mm.cp.c() {});
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    MMApplicationContext.getContext().unregisterReceiver(this.SaT);
    k.a(null);
    Object localObject;
    if (this.SaP != null)
    {
      localObject = this.SaP;
      ((com.tencent.mm.plugin.sport.model.a)localObject).Sbm.hue();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).Sbo != null) {
        com.tencent.mm.kernel.h.aZW().a(((com.tencent.mm.plugin.sport.model.a)localObject).Sbo);
      }
      this.SaP = null;
    }
    if (this.SaQ != null)
    {
      localObject = this.SaQ;
      ((com.tencent.mm.plugin.sport.model.b)localObject).Sbs.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).Sbo != null) {
        com.tencent.mm.kernel.h.aZW().a(((com.tencent.mm.plugin.sport.model.b)localObject).Sbo);
      }
      this.SaQ = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.az(v.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */