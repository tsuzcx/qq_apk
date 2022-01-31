package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.sport.model.h;
import com.tencent.mm.plugin.sport.model.h.a;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.m;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class PluginSport
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.d> baseDBFactories;
  private j soX;
  private com.tencent.mm.plugin.sport.a.b soY;
  private com.tencent.mm.plugin.sport.model.a soZ;
  private com.tencent.mm.plugin.sport.model.b spa;
  private l spb;
  private m spc;
  private h.a spd;
  private com.tencent.mm.plugin.sport.model.g spe;
  private BroadcastReceiver spf;
  
  static
  {
    AppMethodBeat.i(93614);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new PluginSport.2());
    AppMethodBeat.o(93614);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(93607);
    this.spd = new PluginSport.1(this);
    this.spf = new PluginSport.3(this);
    AppMethodBeat.o(93607);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(93608);
    if (this.soX == null) {
      this.soX = k.cyT();
    }
    if (paramg.SD())
    {
      this.soY = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.soY));
      AppMethodBeat.o(93608);
      return;
    }
    if (paramg.mI(":push")) {
      getPushSportStepDetector();
    }
    AppMethodBeat.o(93608);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.soZ;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.spa;
  }
  
  public com.tencent.mm.plugin.sport.model.g getPushSportStepDetector()
  {
    AppMethodBeat.i(93613);
    if ((ah.dsU()) && (this.spe == null)) {
      this.spe = new com.tencent.mm.plugin.sport.model.g();
    }
    com.tencent.mm.plugin.sport.model.g localg = this.spe;
    AppMethodBeat.o(93613);
    return localg;
  }
  
  public j getSportFileStorage()
  {
    AppMethodBeat.i(93610);
    if (this.soX == null) {
      this.soX = k.cyT();
    }
    j localj = this.soX;
    AppMethodBeat.o(93610);
    return localj;
  }
  
  public l getSportStepManager()
  {
    return this.spb;
  }
  
  public m getSportStepStorage()
  {
    return this.spc;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(93609);
    this.soZ = new com.tencent.mm.plugin.sport.model.a();
    this.spa = new com.tencent.mm.plugin.sport.model.b();
    this.spc = new m();
    this.spb = new l();
    h.a(this.spd);
    this.spd.ye();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    ah.getContext().registerReceiver(this.spf, paramc);
    AppMethodBeat.o(93609);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(93611);
    ah.getContext().unregisterReceiver(this.spf);
    h.a(null);
    Object localObject;
    if (this.soZ != null)
    {
      localObject = this.soZ;
      ((com.tencent.mm.plugin.sport.model.a)localObject).spl.cyG();
      ((com.tencent.mm.plugin.sport.model.a)localObject).spm.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).spn != null) {
        com.tencent.mm.kernel.g.Rc().a(((com.tencent.mm.plugin.sport.model.a)localObject).spn);
      }
      this.soZ = null;
    }
    if (this.spa != null)
    {
      localObject = this.spa;
      ((com.tencent.mm.plugin.sport.model.b)localObject).sps.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).spm.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).spn != null) {
        com.tencent.mm.kernel.g.Rc().a(((com.tencent.mm.plugin.sport.model.b)localObject).spn);
      }
      this.spa = null;
    }
    AppMethodBeat.o(93611);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(93612);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class));
    AppMethodBeat.o(93612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */