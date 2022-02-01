package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  extends y
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c
{
  private static a GvS;
  private static HashMap<Integer, h.b> baseDBFactories;
  private i GvT;
  private com.tencent.mm.plugin.newtips.b.b GvU;
  private com.tencent.mm.plugin.newtips.b.d GvV;
  private e GvW;
  private l GvX;
  
  static
  {
    AppMethodBeat.i(127207);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEWTIPSCOMPAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.newtips.b.b.SQL_CREATE;
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
    this.GvT = null;
    this.GvU = null;
    this.GvV = null;
    this.GvW = null;
    this.GvX = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a fiM()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (GvS == null) {
        GvS = new a();
      }
      a locala = GvS;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l fiN()
  {
    AppMethodBeat.i(186594);
    h.aHE().aGH();
    if (fiM().GvT == null) {
      fiM().GvT = new i();
    }
    l locall = fiM().GvX;
    AppMethodBeat.o(186594);
    return locall;
  }
  
  public static i fiO()
  {
    AppMethodBeat.i(127203);
    h.aHE().aGH();
    if (fiM().GvT == null) {
      fiM().GvT = new i();
    }
    i locali = fiM().GvT;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static com.tencent.mm.plugin.newtips.b.b fiP()
  {
    AppMethodBeat.i(127204);
    h.aHE().aGH();
    if (fiM().GvU == null)
    {
      localObject = fiM();
      h.aHH();
      ((a)localObject).GvU = new com.tencent.mm.plugin.newtips.b.b(h.aHG().kcF);
    }
    Object localObject = fiM().GvU;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d fiQ()
  {
    AppMethodBeat.i(127205);
    h.aHE().aGH();
    if (fiM().GvV == null)
    {
      localObject = fiM();
      h.aHH();
      ((a)localObject).GvV = new com.tencent.mm.plugin.newtips.b.d(h.aHG().kcF);
    }
    Object localObject = fiM().GvV;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static e fiR()
  {
    AppMethodBeat.i(127206);
    h.aHE().aGH();
    if (fiM().GvW == null) {
      fiM().GvW = new e();
    }
    e locale = fiM().GvW;
    AppMethodBeat.o(127206);
    return locale;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(127201);
    super.onAccountInitialized(paramc);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("newtips", this.GvX);
    fiO();
    int i = com.tencent.mm.plugin.newtips.a.d.Gwf;
    paramc = com.tencent.mm.plugin.newtips.a.d.Gwm;
    i.g(i, com.tencent.mm.plugin.newtips.a.d.Gwe, "", paramc);
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("newtips", this.GvX);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */