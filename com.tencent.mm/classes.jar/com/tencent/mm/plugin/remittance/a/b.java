package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.ir;
import com.tencent.mm.h.a.mw;
import com.tencent.mm.h.a.tu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.e.j.a;
import java.util.HashMap;
import java.util.HashSet;

public class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private j.a dYS = new b.3(this);
  private bx.a jwQ = new b.4(this);
  private ab nuJ = null;
  public com.tencent.mm.plugin.remittance.b.b nuK = null;
  private com.tencent.mm.plugin.remittance.b.d nuL = null;
  private com.tencent.mm.sdk.b.c<mw> nuM = new b.5(this);
  private com.tencent.mm.sdk.b.c<tu> nuN = new b.6(this);
  private com.tencent.mm.sdk.b.c<ir> nuO = new b.7(this);
  
  static
  {
    com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new b.1());
    dgp.put(Integer.valueOf("RemittanceRecord".hashCode()), new b.2());
  }
  
  public static b bvS()
  {
    return (b)com.tencent.mm.model.p.B(b.class);
  }
  
  public static com.tencent.mm.plugin.remittance.b.b bvT()
  {
    if (bvS().nuK == null)
    {
      b localb = bvS();
      g.DQ();
      localb.nuK = new com.tencent.mm.plugin.remittance.b.b(g.DP().dKu);
    }
    return bvS().nuK;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d bvU()
  {
    if (bvS().nuL == null)
    {
      b localb = bvS();
      g.DQ();
      localb.nuL = new com.tencent.mm.plugin.remittance.b.d(g.DP().dKu);
    }
    return bvS().nuL;
  }
  
  public final void bh(boolean paramBoolean)
  {
    ab localab;
    if (this.nuJ != null) {
      localab = this.nuJ;
    }
    synchronized (localab.lock)
    {
      localab.nzE = new HashSet();
      localab.nzF.clear();
      com.tencent.mm.model.c.c.IX().c(this.dYS);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.jwQ, true);
      com.tencent.mm.sdk.b.a.udP.b(this.nuM);
      com.tencent.mm.sdk.b.a.udP.b(this.nuN);
      com.tencent.mm.sdk.b.a.udP.b(this.nuO);
      return;
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final ab bvV()
  {
    if (this.nuJ == null) {
      this.nuJ = new ab();
    }
    return this.nuJ;
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.model.c.c.IX().d(this.dYS);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.jwQ, true);
    com.tencent.mm.sdk.b.a.udP.d(this.nuM);
    com.tencent.mm.sdk.b.a.udP.d(this.nuN);
    com.tencent.mm.sdk.b.a.udP.d(this.nuO);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.b
 * JD-Core Version:    0.7.0.1
 */