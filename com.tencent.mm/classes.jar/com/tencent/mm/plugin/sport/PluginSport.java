package com.tencent.mm.plugin.sport;

import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.sport.c.g.a;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.j;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import java.util.HashMap;

public class PluginSport
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, a
{
  public static HashMap<Integer, h.d> dgp;
  private h psR;
  private com.tencent.mm.plugin.sport.b.b psS;
  private com.tencent.mm.plugin.sport.c.a psT;
  private com.tencent.mm.plugin.sport.c.b psU;
  private l psV;
  private m psW;
  private g.a psX = new PluginSport.1(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new PluginSport.2());
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return dgp;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    MMReceivers.ExdeviceProcessReceiver.a(new j());
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (this.psR == null) {
      this.psR = i.bLr();
    }
    if (paramg.Ex())
    {
      this.psS = new c();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.b.b.class, new e(this.psS));
    }
  }
  
  public com.tencent.mm.plugin.sport.c.a getDeviceStepManager()
  {
    return this.psT;
  }
  
  public com.tencent.mm.plugin.sport.c.b getExtApiStepManager()
  {
    return this.psU;
  }
  
  public h getSportFileStorage()
  {
    if (this.psR == null) {
      this.psR = i.bLr();
    }
    return this.psR;
  }
  
  public l getSportStepManager()
  {
    return this.psV;
  }
  
  public m getSportStepStorage()
  {
    return this.psW;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    this.psT = new com.tencent.mm.plugin.sport.c.a();
    this.psU = new com.tencent.mm.plugin.sport.c.b();
    this.psW = new m();
    this.psV = new l();
    com.tencent.mm.plugin.sport.c.g.a(this.psX);
    this.psX.aYu();
  }
  
  public void onAccountRelease()
  {
    com.tencent.mm.plugin.sport.c.g.a(null);
    Object localObject;
    if (this.psT != null)
    {
      localObject = this.psT;
      ((com.tencent.mm.plugin.sport.c.a)localObject).ptc.dead();
      if (((com.tencent.mm.plugin.sport.c.a)localObject).ptd != null) {
        com.tencent.mm.kernel.g.Dk().c(((com.tencent.mm.plugin.sport.c.a)localObject).ptd);
      }
      this.psT = null;
    }
    if (this.psU != null)
    {
      localObject = this.psU;
      ((com.tencent.mm.plugin.sport.c.b)localObject).ptj.dead();
      ((com.tencent.mm.plugin.sport.c.b)localObject).ptc.dead();
      if (((com.tencent.mm.plugin.sport.c.b)localObject).ptd != null) {
        com.tencent.mm.kernel.g.Dk().c(((com.tencent.mm.plugin.sport.c.b)localObject).ptd);
      }
      this.psU = null;
    }
  }
  
  public void parallelsDependency()
  {
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport
 * JD-Core Version:    0.7.0.1
 */