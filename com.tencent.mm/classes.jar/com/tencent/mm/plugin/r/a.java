package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bn;
import java.util.HashMap;

public final class a
  extends q
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static a pfW;
  private d pfX;
  private bn pfY;
  private com.tencent.mm.ax.c pfZ;
  private com.tencent.mm.ax.e pga;
  private final com.tencent.mm.ai.f pgb;
  
  static
  {
    AppMethodBeat.i(79113);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new a.2());
    AppMethodBeat.o(79113);
  }
  
  private a()
  {
    super(com.tencent.mm.ax.f.class);
    AppMethodBeat.i(79106);
    this.pfX = null;
    this.pfY = null;
    this.pfZ = null;
    this.pga = new com.tencent.mm.ax.e();
    this.pgb = new a.1(this);
    AppMethodBeat.o(79106);
  }
  
  public static a bWR()
  {
    try
    {
      AppMethodBeat.i(79107);
      if (pfW == null) {
        pfW = new a();
      }
      a locala = pfW;
      AppMethodBeat.o(79107);
      return locala;
    }
    finally {}
  }
  
  public static d bWS()
  {
    AppMethodBeat.i(79110);
    g.RJ().QQ();
    if (bWR().pfX == null) {
      bWR().pfX = new d();
    }
    d locald = bWR().pfX;
    AppMethodBeat.o(79110);
    return locald;
  }
  
  public static bn bWT()
  {
    AppMethodBeat.i(79111);
    g.RJ().QQ();
    if (bWR().pfY == null)
    {
      localObject = bWR();
      g.RM();
      ((a)localObject).pfY = new bn(g.RL().eHS);
    }
    Object localObject = bWR().pfY;
    AppMethodBeat.o(79111);
    return localObject;
  }
  
  public static com.tencent.mm.ax.c bWU()
  {
    AppMethodBeat.i(79112);
    g.RJ().QQ();
    if (bWR().pfZ == null) {
      bWR().pfZ = new com.tencent.mm.ax.c();
    }
    com.tencent.mm.ax.c localc = bWR().pfZ;
    AppMethodBeat.o(79112);
    return localc;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(79108);
    super.onAccountInitialized(paramc);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("newtips", this.pga);
    g.Rc().a(597, this.pgb);
    bWS();
    int i = b.fKS;
    paramc = b.fKZ;
    d.b(i, b.fKR, "", paramc);
    ab.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(79108);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(79109);
    super.onAccountRelease();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("newtips", this.pga);
    g.Rc().b(597, this.pgb);
    AppMethodBeat.o(79109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.r.a
 * JD-Core Version:    0.7.0.1
 */