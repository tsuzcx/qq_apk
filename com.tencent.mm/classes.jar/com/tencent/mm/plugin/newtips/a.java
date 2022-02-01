package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  extends t
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static a vmD;
  private i vmE;
  private b vmF;
  private com.tencent.mm.plugin.newtips.b.d vmG;
  private com.tencent.mm.plugin.newtips.a.e vmH;
  private l vmI;
  
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
    this.vmE = null;
    this.vmF = null;
    this.vmG = null;
    this.vmH = null;
    this.vmI = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a djZ()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (vmD == null) {
        vmD = new a();
      }
      a locala = vmD;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l dka()
  {
    AppMethodBeat.i(204964);
    g.agP().afT();
    if (djZ().vmE == null) {
      djZ().vmE = new i();
    }
    l locall = djZ().vmI;
    AppMethodBeat.o(204964);
    return locall;
  }
  
  public static i dkb()
  {
    AppMethodBeat.i(127203);
    g.agP().afT();
    if (djZ().vmE == null) {
      djZ().vmE = new i();
    }
    i locali = djZ().vmE;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static b dkc()
  {
    AppMethodBeat.i(127204);
    g.agP().afT();
    if (djZ().vmF == null)
    {
      localObject = djZ();
      g.agS();
      ((a)localObject).vmF = new b(g.agR().ghG);
    }
    Object localObject = djZ().vmF;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d dkd()
  {
    AppMethodBeat.i(127205);
    g.agP().afT();
    if (djZ().vmG == null)
    {
      localObject = djZ();
      g.agS();
      ((a)localObject).vmG = new com.tencent.mm.plugin.newtips.b.d(g.agR().ghG);
    }
    Object localObject = djZ().vmG;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.a.e dke()
  {
    AppMethodBeat.i(127206);
    g.agP().afT();
    if (djZ().vmH == null) {
      djZ().vmH = new com.tencent.mm.plugin.newtips.a.e();
    }
    com.tencent.mm.plugin.newtips.a.e locale = djZ().vmH;
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
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("newtips", this.vmI);
    dkb();
    int i = com.tencent.mm.plugin.newtips.a.d.vmQ;
    paramc = com.tencent.mm.plugin.newtips.a.d.vmX;
    i.g(i, com.tencent.mm.plugin.newtips.a.d.vmP, "", paramc);
    ac.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("newtips", this.vmI);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */