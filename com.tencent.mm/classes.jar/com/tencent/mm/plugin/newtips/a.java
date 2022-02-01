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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  extends t
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static a udE;
  private i udF;
  private b udG;
  private com.tencent.mm.plugin.newtips.b.d udH;
  private com.tencent.mm.plugin.newtips.a.e udI;
  private l udJ;
  
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
    this.udF = null;
    this.udG = null;
    this.udH = null;
    this.udI = null;
    this.udJ = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a cWr()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (udE == null) {
        udE = new a();
      }
      a locala = udE;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static i cWs()
  {
    AppMethodBeat.i(127203);
    g.afz().aeD();
    if (cWr().udF == null) {
      cWr().udF = new i();
    }
    i locali = cWr().udF;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static b cWt()
  {
    AppMethodBeat.i(127204);
    g.afz().aeD();
    if (cWr().udG == null)
    {
      localObject = cWr();
      g.afC();
      ((a)localObject).udG = new b(g.afB().gda);
    }
    Object localObject = cWr().udG;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d cWu()
  {
    AppMethodBeat.i(127205);
    g.afz().aeD();
    if (cWr().udH == null)
    {
      localObject = cWr();
      g.afC();
      ((a)localObject).udH = new com.tencent.mm.plugin.newtips.b.d(g.afB().gda);
    }
    Object localObject = cWr().udH;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.a.e cWv()
  {
    AppMethodBeat.i(127206);
    g.afz().aeD();
    if (cWr().udI == null) {
      cWr().udI = new com.tencent.mm.plugin.newtips.a.e();
    }
    com.tencent.mm.plugin.newtips.a.e locale = cWr().udI;
    AppMethodBeat.o(127206);
    return locale;
  }
  
  public static l fXX()
  {
    AppMethodBeat.i(202386);
    g.afz().aeD();
    if (cWr().udF == null) {
      cWr().udF = new i();
    }
    l locall = cWr().udJ;
    AppMethodBeat.o(202386);
    return locall;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127201);
    super.onAccountInitialized(paramc);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("newtips", this.udJ);
    cWs();
    int i = com.tencent.mm.plugin.newtips.a.d.udR;
    paramc = com.tencent.mm.plugin.newtips.a.d.udY;
    i.e(i, com.tencent.mm.plugin.newtips.a.d.udQ, "", paramc);
    ad.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("newtips", this.udJ);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */