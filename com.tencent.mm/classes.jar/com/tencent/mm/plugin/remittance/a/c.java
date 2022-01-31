package com.tencent.mm.plugin.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.e.k.a;
import java.util.HashMap;
import java.util.HashSet;

public class c
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private k.a foV;
  private bz.a lGp;
  private ab qfC;
  public b qfD;
  private com.tencent.mm.plugin.remittance.b.d qfE;
  private com.tencent.mm.sdk.b.c<nt> qfF;
  private com.tencent.mm.sdk.b.c<vq> qfG;
  private com.tencent.mm.sdk.b.c<iy> qfH;
  
  static
  {
    AppMethodBeat.i(44442);
    com.tencent.mm.wallet_core.a.h("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c.1());
    baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new c.2());
    AppMethodBeat.o(44442);
  }
  
  public c()
  {
    AppMethodBeat.i(44434);
    this.qfC = null;
    this.qfD = null;
    this.qfE = null;
    this.foV = new c.3(this);
    this.lGp = new c.4(this);
    this.qfF = new c.5(this);
    this.qfG = new c.6(this);
    this.qfH = new c.7(this);
    AppMethodBeat.o(44434);
  }
  
  public static c cgH()
  {
    AppMethodBeat.i(44435);
    c localc = (c)q.S(c.class);
    AppMethodBeat.o(44435);
    return localc;
  }
  
  public static b cgI()
  {
    AppMethodBeat.i(44436);
    if (cgH().qfD == null)
    {
      localObject = cgH();
      g.RM();
      ((c)localObject).qfD = new b(g.RL().eHS);
    }
    Object localObject = cgH().qfD;
    AppMethodBeat.o(44436);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d cgJ()
  {
    AppMethodBeat.i(44437);
    if (cgH().qfE == null)
    {
      localObject = cgH();
      g.RM();
      ((c)localObject).qfE = new com.tencent.mm.plugin.remittance.b.d(g.RL().eHS);
    }
    Object localObject = cgH().qfE;
    AppMethodBeat.o(44437);
    return localObject;
  }
  
  public final ab cgK()
  {
    AppMethodBeat.i(44440);
    if (this.qfC == null) {
      this.qfC = new ab();
    }
    ab localab = this.qfC;
    AppMethodBeat.o(44440);
    return localab;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(44438);
    ab localab;
    if (this.qfC != null) {
      localab = this.qfC;
    }
    synchronized (localab.lock)
    {
      localab.qkQ = new HashSet();
      localab.qkR.clear();
      com.tencent.mm.model.c.c.abU().add(this.foV);
      ((p)g.G(p.class)).getSysCmdMsgExtension().a("paymsg", this.lGp, true);
      com.tencent.mm.sdk.b.a.ymk.b(this.qfF);
      com.tencent.mm.sdk.b.a.ymk.b(this.qfG);
      com.tencent.mm.sdk.b.a.ymk.b(this.qfH);
      AppMethodBeat.o(44438);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(44439);
    com.tencent.mm.model.c.c.abU().remove(this.foV);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("paymsg", this.lGp, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.qfF);
    com.tencent.mm.sdk.b.a.ymk.d(this.qfG);
    com.tencent.mm.sdk.b.a.ymk.d(this.qfH);
    AppMethodBeat.o(44439);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */