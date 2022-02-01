package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.h;
import com.tencent.mm.plugin.sport.model.h.a;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSport
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private j AXR;
  private com.tencent.mm.plugin.sport.a.b AXS;
  private com.tencent.mm.plugin.sport.model.a AXT;
  private com.tencent.mm.plugin.sport.model.b AXU;
  private h.a AXV;
  private com.tencent.mm.plugin.sport.model.g AXW;
  private BroadcastReceiver AXX;
  
  static
  {
    AppMethodBeat.i(149258);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(149258);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.AXV = new h.a()
    {
      public final void agz()
      {
        AppMethodBeat.i(149249);
        com.tencent.mm.plugin.sport.model.a locala = PluginSport.this.getDeviceStepManager();
        if (locala.AYd != null) {
          locala.AYd.ejP();
        }
        AppMethodBeat.o(149249);
      }
    };
    this.AXX = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if (("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) && (l.gv(ak.getContext())) && (l.ejG())) {
          PluginSport.this.getDeviceStepManager().ejJ();
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
    if (this.AXR == null) {
      this.AXR = k.ekc();
    }
    if (paramg.akL())
    {
      this.AXS = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.AXS));
      AppMethodBeat.o(149252);
      return;
    }
    if (paramg.xO(":push"))
    {
      getPushSportStepDetector();
      SportForegroundService.ekf();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.AXT;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.AXU;
  }
  
  public com.tencent.mm.plugin.sport.model.g getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((ak.foA()) && (this.AXW == null)) {
      this.AXW = new com.tencent.mm.plugin.sport.model.g();
    }
    com.tencent.mm.plugin.sport.model.g localg = this.AXW;
    AppMethodBeat.o(149257);
    return localg;
  }
  
  public j getSportFileStorage()
  {
    AppMethodBeat.i(149254);
    if (this.AXR == null) {
      this.AXR = k.ekc();
    }
    j localj = this.AXR;
    AppMethodBeat.o(149254);
    return localj;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(149253);
    this.AXT = new com.tencent.mm.plugin.sport.model.a();
    this.AXU = new com.tencent.mm.plugin.sport.model.b();
    h.a(this.AXV);
    this.AXV.agz();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    ak.getContext().registerReceiver(this.AXX, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    ak.getContext().unregisterReceiver(this.AXX);
    h.a(null);
    Object localObject;
    if (this.AXT != null)
    {
      localObject = this.AXT;
      ((com.tencent.mm.plugin.sport.model.a)localObject).AYd.ejQ();
      ((com.tencent.mm.plugin.sport.model.a)localObject).AYe.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).AYf != null) {
        com.tencent.mm.kernel.g.ajj().a(((com.tencent.mm.plugin.sport.model.a)localObject).AYf);
      }
      this.AXT = null;
    }
    if (this.AXU != null)
    {
      localObject = this.AXU;
      ((com.tencent.mm.plugin.sport.model.b)localObject).AYk.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).AYe.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).AYf != null) {
        com.tencent.mm.kernel.g.ajj().a(((com.tencent.mm.plugin.sport.model.b)localObject).AYf);
      }
      this.AXU = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(s.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */