package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  extends u
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static a wHE;
  private i wHF;
  private b wHG;
  private com.tencent.mm.plugin.newtips.b.d wHH;
  private com.tencent.mm.plugin.newtips.a.e wHI;
  private l wHJ;
  
  static
  {
    AppMethodBeat.i(127207);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEWTIPSCOMPAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.newtips.b.d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(127207);
  }
  
  private a()
  {
    super(c.class);
    AppMethodBeat.i(127199);
    this.wHF = null;
    this.wHG = null;
    this.wHH = null;
    this.wHI = null;
    this.wHJ = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a dxB()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (wHE == null) {
        wHE = new a();
      }
      a locala = wHE;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l dxC()
  {
    AppMethodBeat.i(200589);
    g.ajP().aiU();
    if (dxB().wHF == null) {
      dxB().wHF = new i();
    }
    l locall = dxB().wHJ;
    AppMethodBeat.o(200589);
    return locall;
  }
  
  public static i dxD()
  {
    AppMethodBeat.i(127203);
    g.ajP().aiU();
    if (dxB().wHF == null) {
      dxB().wHF = new i();
    }
    i locali = dxB().wHF;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static b dxE()
  {
    AppMethodBeat.i(127204);
    g.ajP().aiU();
    if (dxB().wHG == null)
    {
      localObject = dxB();
      g.ajS();
      ((a)localObject).wHG = new b(g.ajR().gDX);
    }
    Object localObject = dxB().wHG;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d dxF()
  {
    AppMethodBeat.i(127205);
    g.ajP().aiU();
    if (dxB().wHH == null)
    {
      localObject = dxB();
      g.ajS();
      ((a)localObject).wHH = new com.tencent.mm.plugin.newtips.b.d(g.ajR().gDX);
    }
    Object localObject = dxB().wHH;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.a.e dxG()
  {
    AppMethodBeat.i(127206);
    g.ajP().aiU();
    if (dxB().wHI == null) {
      dxB().wHI = new com.tencent.mm.plugin.newtips.a.e();
    }
    com.tencent.mm.plugin.newtips.a.e locale = dxB().wHI;
    AppMethodBeat.o(127206);
    return locale;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127201);
    super.onAccountInitialized(paramc);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("newtips", this.wHJ);
    dxD();
    int i = com.tencent.mm.plugin.newtips.a.d.wHR;
    paramc = com.tencent.mm.plugin.newtips.a.d.wHY;
    i.g(i, com.tencent.mm.plugin.newtips.a.d.wHQ, "", paramc);
    ae.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("newtips", this.wHJ);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */