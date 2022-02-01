package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  extends y
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static a ACO;
  private static HashMap<Integer, h.b> baseDBFactories;
  private i ACP;
  private b ACQ;
  private com.tencent.mm.plugin.newtips.b.d ACR;
  private com.tencent.mm.plugin.newtips.a.e ACS;
  private l ACT;
  
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
    this.ACP = null;
    this.ACQ = null;
    this.ACR = null;
    this.ACS = null;
    this.ACT = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a exj()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (ACO == null) {
        ACO = new a();
      }
      a locala = ACO;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l exk()
  {
    AppMethodBeat.i(188556);
    g.aAf().azk();
    if (exj().ACP == null) {
      exj().ACP = new i();
    }
    l locall = exj().ACT;
    AppMethodBeat.o(188556);
    return locall;
  }
  
  public static i exl()
  {
    AppMethodBeat.i(127203);
    g.aAf().azk();
    if (exj().ACP == null) {
      exj().ACP = new i();
    }
    i locali = exj().ACP;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static b exm()
  {
    AppMethodBeat.i(127204);
    g.aAf().azk();
    if (exj().ACQ == null)
    {
      localObject = exj();
      g.aAi();
      ((a)localObject).ACQ = new b(g.aAh().hqK);
    }
    Object localObject = exj().ACQ;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d exn()
  {
    AppMethodBeat.i(127205);
    g.aAf().azk();
    if (exj().ACR == null)
    {
      localObject = exj();
      g.aAi();
      ((a)localObject).ACR = new com.tencent.mm.plugin.newtips.b.d(g.aAh().hqK);
    }
    Object localObject = exj().ACR;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.a.e exo()
  {
    AppMethodBeat.i(127206);
    g.aAf().azk();
    if (exj().ACS == null) {
      exj().ACS = new com.tencent.mm.plugin.newtips.a.e();
    }
    com.tencent.mm.plugin.newtips.a.e locale = exj().ACS;
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
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("newtips", this.ACT);
    exl();
    int i = com.tencent.mm.plugin.newtips.a.d.ADb;
    paramc = com.tencent.mm.plugin.newtips.a.d.ADi;
    i.f(i, com.tencent.mm.plugin.newtips.a.d.ADa, "", paramc);
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("newtips", this.ACT);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */