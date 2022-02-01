package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.k.a;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.m;
import com.tencent.mm.plugin.sport.model.m.a;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;

public class PluginSport
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.plugin.sport.a.b Lxp;
  private com.tencent.mm.plugin.sport.model.a Lxq;
  private com.tencent.mm.plugin.sport.model.b Lxr;
  private k.a Lxs;
  private com.tencent.mm.plugin.sport.model.h Lxt;
  private BroadcastReceiver Lxu;
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.Lxs = new k.a()
    {
      public final void bWp()
      {
        AppMethodBeat.i(149249);
        PluginSport.this.getDeviceStepManager().gaH();
        AppMethodBeat.o(149249);
      }
    };
    this.Lxu = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if ("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) {
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221443);
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(323L, 9L, 1L, false);
              if ((n.ih(MMApplicationContext.getContext())) && (n.gaC())) {
                PluginSport.this.getDeviceStepManager().gaE();
              }
              AppMethodBeat.o(221443);
            }
          }, "UploadSportStepEventHandle");
        }
        AppMethodBeat.o(161588);
      }
    };
    AppMethodBeat.o(149251);
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(149252);
    if (MMApplicationContext.isPushProcess())
    {
      Object localObject = m.Lyn;
      m.a locala;
      if (u.agG(com.tencent.mm.plugin.sport.a.a.Lxy))
      {
        localObject = new l(com.tencent.mm.plugin.sport.a.a.Lxy);
        locala = new m.a();
        locala.LxU = (((l)localObject).ahV(202) * 10000L);
        locala.LxS = ((l)localObject).ahV(201);
        locala.LxR = ((l)localObject).ahV(203);
        locala.LxV = ((l)localObject).ahV(204);
        locala.LxX = ((l)localObject).ahV(209);
        locala.LxT = locala.LxS;
        locala.LxW = locala.LxV;
        m.gaY().encode("KEY_STEP_DETAIL_INFO", locala.toString());
        u.deleteFile(com.tencent.mm.plugin.sport.a.a.Lxy);
        Log.i("MicroMsg.Sport.SportKvStorage", "compat first file:" + com.tencent.mm.plugin.sport.a.a.Lxy + " detailInfo:" + locala);
      }
      if (u.agG(com.tencent.mm.plugin.sport.a.a.Lxz))
      {
        localObject = new l(com.tencent.mm.plugin.sport.a.a.Lxz).bcJ("");
        locala = new m.a();
        p.j(localObject, "info");
        locala.bcK((String)localObject);
        m.gaY().encode("KEY_STEP_DETAIL_INFO", locala.toString());
        u.deleteFile(com.tencent.mm.plugin.sport.a.a.Lxz);
        Log.i("MicroMsg.Sport.SportKvStorage", "compat second file:" + com.tencent.mm.plugin.sport.a.a.Lxz + " detailInfo:" + locala);
      }
    }
    if (paramg.aIE())
    {
      this.Lxp = new c();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.Lxp));
      AppMethodBeat.o(149252);
      return;
    }
    if (MMApplicationContext.isPushProcess())
    {
      getPushSportStepDetector();
      SportForegroundService.gaX();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.Lxq;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.Lxr;
  }
  
  public com.tencent.mm.plugin.sport.model.h getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((MMApplicationContext.isPushProcess()) && (this.Lxt == null)) {
      this.Lxt = new com.tencent.mm.plugin.sport.model.h();
    }
    com.tencent.mm.plugin.sport.model.h localh = this.Lxt;
    AppMethodBeat.o(149257);
    return localh;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(149253);
    this.Lxq = new com.tencent.mm.plugin.sport.model.a();
    this.Lxr = new com.tencent.mm.plugin.sport.model.b();
    k.a(this.Lxs);
    this.Lxs.bWp();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    MMApplicationContext.getContext().registerReceiver(this.Lxu, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    MMApplicationContext.getContext().unregisterReceiver(this.Lxu);
    k.a(null);
    Object localObject;
    if (this.Lxq != null)
    {
      localObject = this.Lxq;
      ((com.tencent.mm.plugin.sport.model.a)localObject).LxA.gaN();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).LxC != null) {
        com.tencent.mm.kernel.h.aGY().a(((com.tencent.mm.plugin.sport.model.a)localObject).LxC);
      }
      this.Lxq = null;
    }
    if (this.Lxr != null)
    {
      localObject = this.Lxr;
      ((com.tencent.mm.plugin.sport.model.b)localObject).LxG.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).LxC != null) {
        com.tencent.mm.kernel.h.aGY().a(((com.tencent.mm.plugin.sport.model.b)localObject).LxC);
      }
      this.Lxr = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.h.ag(v.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */