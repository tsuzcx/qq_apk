package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.g.a;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSport
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.sport.model.i FiK;
  private com.tencent.mm.plugin.sport.a.b FiL;
  private com.tencent.mm.plugin.sport.model.a FiM;
  private com.tencent.mm.plugin.sport.model.b FiN;
  private g.a FiO;
  private com.tencent.mm.plugin.sport.model.f FiP;
  private BroadcastReceiver FiQ;
  
  static
  {
    AppMethodBeat.i(149258);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(149258);
  }
  
  public PluginSport()
  {
    AppMethodBeat.i(149251);
    this.FiO = new g.a()
    {
      public final void awp()
      {
        AppMethodBeat.i(149249);
        com.tencent.mm.plugin.sport.model.a locala = PluginSport.this.getDeviceStepManager();
        if (locala.FiX != null) {
          locala.FiX.fmp();
        }
        AppMethodBeat.o(149249);
      }
    };
    this.FiQ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(161588);
        if ("com.tencent.mm.plugin.sport.uploadstep".equals(paramAnonymousIntent.getAction())) {
          h.RTc.b(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199373);
              if ((k.hg(MMApplicationContext.getContext())) && (k.fmg())) {
                PluginSport.this.getDeviceStepManager().fmj();
              }
              AppMethodBeat.o(199373);
            }
          }, "UploadSportStepEventHandle");
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
    if (this.FiK == null) {
      this.FiK = j.fmC();
    }
    if (paramg.aBb())
    {
      this.FiL = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.FiL));
      AppMethodBeat.o(149252);
      return;
    }
    if (paramg.FY(":push"))
    {
      getPushSportStepDetector();
      SportForegroundService.fmF();
    }
    AppMethodBeat.o(149252);
  }
  
  public com.tencent.mm.plugin.sport.model.a getDeviceStepManager()
  {
    return this.FiM;
  }
  
  public com.tencent.mm.plugin.sport.model.b getExtApiStepManager()
  {
    return this.FiN;
  }
  
  public com.tencent.mm.plugin.sport.model.f getPushSportStepDetector()
  {
    AppMethodBeat.i(149257);
    if ((MMApplicationContext.isPushProcess()) && (this.FiP == null)) {
      this.FiP = new com.tencent.mm.plugin.sport.model.f();
    }
    com.tencent.mm.plugin.sport.model.f localf = this.FiP;
    AppMethodBeat.o(149257);
    return localf;
  }
  
  public com.tencent.mm.plugin.sport.model.i getSportFileStorage()
  {
    AppMethodBeat.i(149254);
    if (this.FiK == null) {
      this.FiK = j.fmC();
    }
    com.tencent.mm.plugin.sport.model.i locali = this.FiK;
    AppMethodBeat.o(149254);
    return locali;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(149253);
    this.FiM = new com.tencent.mm.plugin.sport.model.a();
    this.FiN = new com.tencent.mm.plugin.sport.model.b();
    com.tencent.mm.plugin.sport.model.g.a(this.FiO);
    this.FiO.awp();
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.plugin.sport.uploadstep");
    MMApplicationContext.getContext().registerReceiver(this.FiQ, paramc);
    AppMethodBeat.o(149253);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149255);
    MMApplicationContext.getContext().unregisterReceiver(this.FiQ);
    com.tencent.mm.plugin.sport.model.g.a(null);
    Object localObject;
    if (this.FiM != null)
    {
      localObject = this.FiM;
      ((com.tencent.mm.plugin.sport.model.a)localObject).FiX.fmq();
      ((com.tencent.mm.plugin.sport.model.a)localObject).FiY.dead();
      if (((com.tencent.mm.plugin.sport.model.a)localObject).FiZ != null) {
        com.tencent.mm.kernel.g.azz().a(((com.tencent.mm.plugin.sport.model.a)localObject).FiZ);
      }
      this.FiM = null;
    }
    if (this.FiN != null)
    {
      localObject = this.FiN;
      ((com.tencent.mm.plugin.sport.model.b)localObject).Fjg.dead();
      ((com.tencent.mm.plugin.sport.model.b)localObject).FiY.dead();
      if (((com.tencent.mm.plugin.sport.model.b)localObject).FiZ != null) {
        com.tencent.mm.kernel.g.azz().a(((com.tencent.mm.plugin.sport.model.b)localObject).FiZ);
      }
      this.FiN = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(149256);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.ah(s.class));
    AppMethodBeat.o(149256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */