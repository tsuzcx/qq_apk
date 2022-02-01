package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.h;
import com.tencent.mm.plugin.sport.model.h.a;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSport
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private BroadcastReceiver ybA;
  private j ybu;
  private com.tencent.mm.plugin.sport.a.b ybv;
  private com.tencent.mm.plugin.sport.model.a ybw;
  private com.tencent.mm.plugin.sport.model.b ybx;
  private h.a yby;
  private com.tencent.mm.plugin.sport.model.g ybz;
  
  static
  {
    AppMethodBeat.i(149258);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(149258);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.yby = new h.a()
    {
      public final void acz()
      {
        AppMethodBeat.i(149249);
        com.tencent.mm.plugin.sport.model.a locala = PluginSport.this.getDeviceStepManager();
        if (locala.ybG != null) {
          locala.ybG.dFs();
        }
        AppMethodBeat.o(149249);
      }
    };
    this.ybA = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if (("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) && (l.gb(aj.getContext())) && (l.dFj())) {
          PluginSport.this.getDeviceStepManager().dFm();
        }
        AppMethodBeat.o(161588);
      }
    };
    AppMethodBeat.o(149251);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(149252);
    if (this.ybu == null) {
      this.ybu = k.dFF();
    }
    if (paramg.agu())
    {
      this.ybv = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.ybv));
      AppMethodBeat.o(149252);
      return;
    }
    if (paramg.ra(":push"))
    {
      getPushSportStepDetector();
      SportForegroundService.dFI();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.ybw;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.ybx;
  }
  
  public com.tencent.mm.plugin.sport.model.g getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((aj.eFH()) && (this.ybz == null)) {
      this.ybz = new com.tencent.mm.plugin.sport.model.g();
    }
    com.tencent.mm.plugin.sport.model.g localg = this.ybz;
    AppMethodBeat.o(149257);
    return localg;
  }
  
  public j getSportFileStorage()
  {
    AppMethodBeat.i(149254);
    if (this.ybu == null) {
      this.ybu = k.dFF();
    }
    j localj = this.ybu;
    AppMethodBeat.o(149254);
    return localj;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(149253);
    this.ybw = new com.tencent.mm.plugin.sport.model.a();
    this.ybx = new com.tencent.mm.plugin.sport.model.b();
    h.a(this.yby);
    this.yby.acz();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    aj.getContext().registerReceiver(this.ybA, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    aj.getContext().unregisterReceiver(this.ybA);
    h.a(null);
    Object localObject;
    if (this.ybw != null)
    {
      localObject = this.ybw;
      ((com.tencent.mm.plugin.sport.model.a)localObject).ybG.dFt();
      ((com.tencent.mm.plugin.sport.model.a)localObject).ybH.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).ybI != null) {
        com.tencent.mm.kernel.g.aeS().a(((com.tencent.mm.plugin.sport.model.a)localObject).ybI);
      }
      this.ybw = null;
    }
    if (this.ybx != null)
    {
      localObject = this.ybx;
      ((com.tencent.mm.plugin.sport.model.b)localObject).ybN.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).ybH.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).ybI != null) {
        com.tencent.mm.kernel.g.aeS().a(((com.tencent.mm.plugin.sport.model.b)localObject).ybI);
      }
      this.ybx = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bB(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */