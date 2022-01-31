package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class p
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private cc.a mPZ;
  private d oUI;
  private f oUJ;
  private m oUK;
  private i oUL;
  private p.a oUM;
  private h oUN;
  private com.tencent.mm.plugin.multitalk.a.a oUO;
  private c oUP;
  private g oUQ;
  
  static
  {
    AppMethodBeat.i(54102);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new p.1());
    baseDBFactories.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new p.2());
    AppMethodBeat.o(54102);
  }
  
  public p()
  {
    AppMethodBeat.i(54090);
    this.mPZ = new p.3(this);
    AppMethodBeat.o(54090);
  }
  
  private static p bTA()
  {
    AppMethodBeat.i(54091);
    p localp = (p)q.S(p.class);
    AppMethodBeat.o(54091);
    return localp;
  }
  
  public static com.tencent.mm.plugin.multitalk.a.a bTB()
  {
    AppMethodBeat.i(54092);
    com.tencent.mm.kernel.g.RJ();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(54092);
      throw ((Throwable)localObject);
    }
    if (bTA().oUO == null) {
      bTA().oUO = new com.tencent.mm.plugin.multitalk.a.a(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = bTA().oUO;
    AppMethodBeat.o(54092);
    return localObject;
  }
  
  public static c bTC()
  {
    AppMethodBeat.i(54093);
    com.tencent.mm.kernel.g.RJ();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(54093);
      throw ((Throwable)localObject);
    }
    if (bTA().oUP == null) {
      bTA().oUP = new c(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = bTA().oUP;
    AppMethodBeat.o(54093);
    return localObject;
  }
  
  public static i bTD()
  {
    AppMethodBeat.i(54094);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bTA().oUL == null) {
      bTA().oUL = new i();
    }
    i locali = bTA().oUL;
    AppMethodBeat.o(54094);
    return locali;
  }
  
  public static d bTE()
  {
    AppMethodBeat.i(54095);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bTA().oUI == null) {
      bTA().oUI = new d();
    }
    d locald = bTA().oUI;
    AppMethodBeat.o(54095);
    return locald;
  }
  
  public static f bTF()
  {
    AppMethodBeat.i(54096);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bTA().oUJ == null) {
      bTA().oUJ = new f();
    }
    f localf = bTA().oUJ;
    AppMethodBeat.o(54096);
    return localf;
  }
  
  public static m bTG()
  {
    AppMethodBeat.i(54097);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bTA().oUK == null) {
      bTA().oUK = new m();
    }
    m localm = bTA().oUK;
    AppMethodBeat.o(54097);
    return localm;
  }
  
  public static h bTH()
  {
    AppMethodBeat.i(54100);
    if (bTA().oUN == null) {
      bTA().oUN = new h();
    }
    h localh = bTA().oUN;
    AppMethodBeat.o(54100);
    return localh;
  }
  
  public static g bTI()
  {
    AppMethodBeat.i(54101);
    if (bTA().oUQ == null) {
      bTA().oUQ = new g();
    }
    g localg = bTA().oUQ;
    AppMethodBeat.o(54101);
    return localg;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(54098);
    this.oUI = new d();
    this.oUM = new p.a(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("multivoip", this.oUM, true);
    com.tencent.mm.kernel.g.RN().a(this.mPZ);
    com.tencent.mm.kernel.g.b(a.class, bTH());
    bTH().bTt();
    AppMethodBeat.o(54098);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(54099);
    Object localObject;
    if (this.oUI != null)
    {
      localObject = this.oUI;
      com.tencent.mm.kernel.g.Rc().b(1918, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1919, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1927, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1928, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1929, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1931, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1932, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1933, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1935, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1937, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1938, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(1939, (com.tencent.mm.ai.f)localObject);
      this.oUI = null;
    }
    if (this.oUJ != null)
    {
      localObject = this.oUJ;
      ah.getContext().unregisterReceiver(((f)localObject).oTL);
      com.tencent.mm.sdk.b.a.ymk.d(((f)localObject).oTM);
      ((f)localObject).f(false, false, false);
      this.oUJ = null;
    }
    if (this.oUK != null)
    {
      this.oUK.bTz();
      this.oUK = null;
    }
    if (this.oUL != null)
    {
      this.oUL.reset();
      this.oUL = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("multivoip", this.oUM, true);
    com.tencent.mm.kernel.g.RN().b(this.mPZ);
    com.tencent.mm.kernel.g.F(a.class);
    AppMethodBeat.o(54099);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */