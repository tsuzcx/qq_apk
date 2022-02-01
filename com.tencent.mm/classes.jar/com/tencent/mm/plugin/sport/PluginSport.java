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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSport
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private BroadcastReceiver zoA;
  private j zou;
  private com.tencent.mm.plugin.sport.a.b zov;
  private com.tencent.mm.plugin.sport.model.a zow;
  private com.tencent.mm.plugin.sport.model.b zox;
  private h.a zoy;
  private com.tencent.mm.plugin.sport.model.g zoz;
  
  static
  {
    AppMethodBeat.i(149258);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(149258);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.zoy = new h.a()
    {
      public final void adF()
      {
        AppMethodBeat.i(149249);
        com.tencent.mm.plugin.sport.model.a locala = PluginSport.this.getDeviceStepManager();
        if (locala.zoG != null) {
          locala.zoG.dTT();
        }
        AppMethodBeat.o(149249);
      }
    };
    this.zoA = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if (("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) && (l.gn(ai.getContext())) && (l.dTK())) {
          PluginSport.this.getDeviceStepManager().dTN();
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
    if (this.zou == null) {
      this.zou = k.dUg();
    }
    if (paramg.ahL())
    {
      this.zov = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.zov));
      AppMethodBeat.o(149252);
      return;
    }
    if (paramg.up(":push"))
    {
      getPushSportStepDetector();
      SportForegroundService.dUj();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.zow;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.zox;
  }
  
  public com.tencent.mm.plugin.sport.model.g getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((ai.eVb()) && (this.zoz == null)) {
      this.zoz = new com.tencent.mm.plugin.sport.model.g();
    }
    com.tencent.mm.plugin.sport.model.g localg = this.zoz;
    AppMethodBeat.o(149257);
    return localg;
  }
  
  public j getSportFileStorage()
  {
    AppMethodBeat.i(149254);
    if (this.zou == null) {
      this.zou = k.dUg();
    }
    j localj = this.zou;
    AppMethodBeat.o(149254);
    return localj;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(149253);
    this.zow = new com.tencent.mm.plugin.sport.model.a();
    this.zox = new com.tencent.mm.plugin.sport.model.b();
    h.a(this.zoy);
    this.zoy.adF();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    ai.getContext().registerReceiver(this.zoA, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    ai.getContext().unregisterReceiver(this.zoA);
    h.a(null);
    Object localObject;
    if (this.zow != null)
    {
      localObject = this.zow;
      ((com.tencent.mm.plugin.sport.model.a)localObject).zoG.dTU();
      ((com.tencent.mm.plugin.sport.model.a)localObject).zoH.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).zoI != null) {
        com.tencent.mm.kernel.g.agi().a(((com.tencent.mm.plugin.sport.model.a)localObject).zoI);
      }
      this.zow = null;
    }
    if (this.zox != null)
    {
      localObject = this.zox;
      ((com.tencent.mm.plugin.sport.model.b)localObject).zoN.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).zoH.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).zoI != null) {
        com.tencent.mm.kernel.g.agi().a(((com.tencent.mm.plugin.sport.model.b)localObject).zoI);
      }
      this.zox = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).by(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */