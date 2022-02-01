package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.r;
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
  private static a wrV;
  private i wrW;
  private b wrX;
  private com.tencent.mm.plugin.newtips.b.d wrY;
  private com.tencent.mm.plugin.newtips.a.e wrZ;
  private l wsa;
  
  static
  {
    AppMethodBeat.i(127207);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEWTIPSCOMPAT_TABLE".hashCode()), new a.1());
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
    this.wrW = null;
    this.wrX = null;
    this.wrY = null;
    this.wrZ = null;
    this.wsa = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a dul()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (wrV == null) {
        wrV = new a();
      }
      a locala = wrV;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l dum()
  {
    AppMethodBeat.i(214422);
    g.ajA().aiF();
    if (dul().wrW == null) {
      dul().wrW = new i();
    }
    l locall = dul().wsa;
    AppMethodBeat.o(214422);
    return locall;
  }
  
  public static i dun()
  {
    AppMethodBeat.i(127203);
    g.ajA().aiF();
    if (dul().wrW == null) {
      dul().wrW = new i();
    }
    i locali = dul().wrW;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static b duo()
  {
    AppMethodBeat.i(127204);
    g.ajA().aiF();
    if (dul().wrX == null)
    {
      localObject = dul();
      g.ajD();
      ((a)localObject).wrX = new b(g.ajC().gBq);
    }
    Object localObject = dul().wrX;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d dup()
  {
    AppMethodBeat.i(127205);
    g.ajA().aiF();
    if (dul().wrY == null)
    {
      localObject = dul();
      g.ajD();
      ((a)localObject).wrY = new com.tencent.mm.plugin.newtips.b.d(g.ajC().gBq);
    }
    Object localObject = dul().wrY;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.a.e duq()
  {
    AppMethodBeat.i(127206);
    g.ajA().aiF();
    if (dul().wrZ == null) {
      dul().wrZ = new com.tencent.mm.plugin.newtips.a.e();
    }
    com.tencent.mm.plugin.newtips.a.e locale = dul().wrZ;
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
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("newtips", this.wsa);
    dun();
    int i = com.tencent.mm.plugin.newtips.a.d.wsi;
    paramc = com.tencent.mm.plugin.newtips.a.d.wsp;
    i.g(i, com.tencent.mm.plugin.newtips.a.d.wsh, "", paramc);
    ad.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("newtips", this.wsa);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */