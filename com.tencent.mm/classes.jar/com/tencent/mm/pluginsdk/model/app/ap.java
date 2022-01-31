package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.pluginsdk.model.b;
import java.util.HashMap;

public class ap
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private o rVi;
  private ao.a rVj = null;
  private j rVk = new j();
  private b rVl = new b();
  private com.tencent.mm.sdk.b.c rVm = new ap.4(this);
  private com.tencent.mm.sdk.b.c rVn = new ap.5(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new ap.1());
    dgp.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new ap.2());
  }
  
  public static c avh()
  {
    return com.tencent.mm.plugin.z.a.avh();
  }
  
  public static h brm()
  {
    return com.tencent.mm.plugin.z.a.brm();
  }
  
  public static i brn()
  {
    return com.tencent.mm.plugin.z.a.brn();
  }
  
  public static m brp()
  {
    return com.tencent.mm.plugin.z.a.brp();
  }
  
  public static d brq()
  {
    return com.tencent.mm.plugin.z.a.brq();
  }
  
  private static ap cla()
  {
    au.Hq();
    ap localap2 = (ap)bu.iR(ap.class.getName());
    ap localap1 = localap2;
    if (localap2 == null) {
      localap1 = new ap();
    }
    return localap1;
  }
  
  public static j clb()
  {
    return cla().rVk;
  }
  
  public static k clc()
  {
    return com.tencent.mm.plugin.z.a.bro();
  }
  
  public static o cld()
  {
    g.DN().CX();
    if (cla().rVi == null)
    {
      ap localap = cla();
      au.Hx();
      localap.rVi = new o(com.tencent.mm.model.c.Dv());
    }
    return cla().rVi;
  }
  
  public static ao.a cle()
  {
    g.DN().CX();
    if (cla().rVj == null) {
      cla().rVj = new ao.a();
    }
    return cla().rVj;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.model.ac.a.dVw = com.tencent.mm.plugin.z.a.brm();
    e.d.a(Integer.valueOf(47), this.rVl);
    e.d.a(Integer.valueOf(49), this.rVk);
    com.tencent.mm.sdk.b.a.udP.c(this.rVm);
    com.tencent.mm.sdk.b.a.udP.c(this.rVn);
    ap.3 local3 = new ap.3(this);
    try
    {
      local3.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (com.tencent.mm.compatible.util.d.gG(20))
      {
        local3.run();
        return;
      }
      throw localThrowable;
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ao.a locala = cla().rVj;
    if (locala != null) {
      locala.bDY = 0;
    }
    e.d.b(Integer.valueOf(47), this.rVl);
    e.d.b(Integer.valueOf(49), this.rVk);
    com.tencent.mm.sdk.b.a.udP.d(this.rVm);
    com.tencent.mm.sdk.b.a.udP.d(this.rVn);
    com.tencent.mm.pluginsdk.model.j.ckx();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */