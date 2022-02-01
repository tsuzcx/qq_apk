package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.r;
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
  private j AGo;
  private com.tencent.mm.plugin.sport.a.b AGp;
  private com.tencent.mm.plugin.sport.model.a AGq;
  private com.tencent.mm.plugin.sport.model.b AGr;
  private h.a AGs;
  private com.tencent.mm.plugin.sport.model.g AGt;
  private BroadcastReceiver AGu;
  
  static
  {
    AppMethodBeat.i(149258);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(149258);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.AGs = new h.a()
    {
      public final void agl()
      {
        AppMethodBeat.i(149249);
        com.tencent.mm.plugin.sport.model.a locala = PluginSport.this.getDeviceStepManager();
        if (locala.AGA != null) {
          locala.AGA.egh();
        }
        AppMethodBeat.o(149249);
      }
    };
    this.AGu = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if (("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) && (l.gq(aj.getContext())) && (l.efY())) {
          PluginSport.this.getDeviceStepManager().egb();
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
    if (this.AGo == null) {
      this.AGo = k.egu();
    }
    if (paramg.akw())
    {
      this.AGp = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.AGp));
      AppMethodBeat.o(149252);
      return;
    }
    if (paramg.xf(":push"))
    {
      getPushSportStepDetector();
      SportForegroundService.egx();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.AGq;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.AGr;
  }
  
  public com.tencent.mm.plugin.sport.model.g getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((aj.fkG()) && (this.AGt == null)) {
      this.AGt = new com.tencent.mm.plugin.sport.model.g();
    }
    com.tencent.mm.plugin.sport.model.g localg = this.AGt;
    AppMethodBeat.o(149257);
    return localg;
  }
  
  public j getSportFileStorage()
  {
    AppMethodBeat.i(149254);
    if (this.AGo == null) {
      this.AGo = k.egu();
    }
    j localj = this.AGo;
    AppMethodBeat.o(149254);
    return localj;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(149253);
    this.AGq = new com.tencent.mm.plugin.sport.model.a();
    this.AGr = new com.tencent.mm.plugin.sport.model.b();
    h.a(this.AGs);
    this.AGs.agl();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    aj.getContext().registerReceiver(this.AGu, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    aj.getContext().unregisterReceiver(this.AGu);
    h.a(null);
    Object localObject;
    if (this.AGq != null)
    {
      localObject = this.AGq;
      ((com.tencent.mm.plugin.sport.model.a)localObject).AGA.egi();
      ((com.tencent.mm.plugin.sport.model.a)localObject).AGB.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).AGC != null) {
        com.tencent.mm.kernel.g.aiU().a(((com.tencent.mm.plugin.sport.model.a)localObject).AGC);
      }
      this.AGq = null;
    }
    if (this.AGr != null)
    {
      localObject = this.AGr;
      ((com.tencent.mm.plugin.sport.model.b)localObject).AGH.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).AGB.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).AGC != null) {
        com.tencent.mm.kernel.g.aiU().a(((com.tencent.mm.plugin.sport.model.b)localObject).AGC);
      }
      this.AGr = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(r.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */