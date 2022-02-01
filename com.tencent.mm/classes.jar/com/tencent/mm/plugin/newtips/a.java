package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
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
  private static a MrR;
  private static HashMap<Integer, h.b> baseDBFactories;
  private i MrS;
  private com.tencent.mm.plugin.newtips.b.b MrT;
  private com.tencent.mm.plugin.newtips.b.d MrU;
  private e MrV;
  private l MrW;
  
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
    this.MrS = null;
    this.MrT = null;
    this.MrU = null;
    this.MrV = null;
    this.MrW = new l();
    AppMethodBeat.o(127199);
  }
  
  public static a gtd()
  {
    try
    {
      AppMethodBeat.i(127200);
      if (MrR == null) {
        MrR = new a();
      }
      a locala = MrR;
      AppMethodBeat.o(127200);
      return locala;
    }
    finally {}
  }
  
  public static l gte()
  {
    AppMethodBeat.i(266284);
    h.baC().aZJ();
    if (gtd().MrS == null) {
      gtd().MrS = new i();
    }
    l locall = gtd().MrW;
    AppMethodBeat.o(266284);
    return locall;
  }
  
  public static i gtf()
  {
    AppMethodBeat.i(127203);
    h.baC().aZJ();
    if (gtd().MrS == null) {
      gtd().MrS = new i();
    }
    i locali = gtd().MrS;
    AppMethodBeat.o(127203);
    return locali;
  }
  
  public static com.tencent.mm.plugin.newtips.b.b gtg()
  {
    AppMethodBeat.i(127204);
    h.baC().aZJ();
    if (gtd().MrT == null)
    {
      localObject = gtd();
      h.baF();
      ((a)localObject).MrT = new com.tencent.mm.plugin.newtips.b.b(h.baE().mCN);
    }
    Object localObject = gtd().MrT;
    AppMethodBeat.o(127204);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.newtips.b.d gth()
  {
    AppMethodBeat.i(127205);
    h.baC().aZJ();
    if (gtd().MrU == null)
    {
      localObject = gtd();
      h.baF();
      ((a)localObject).MrU = new com.tencent.mm.plugin.newtips.b.d(h.baE().mCN);
    }
    Object localObject = gtd().MrU;
    AppMethodBeat.o(127205);
    return localObject;
  }
  
  public static e gti()
  {
    AppMethodBeat.i(127206);
    h.baC().aZJ();
    if (gtd().MrV == null) {
      gtd().MrV = new e();
    }
    e locale = gtd().MrV;
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
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("newtips", this.MrW);
    gtf();
    int i = com.tencent.mm.plugin.newtips.a.d.Mse;
    paramc = com.tencent.mm.plugin.newtips.a.d.Msl;
    i.h(i, com.tencent.mm.plugin.newtips.a.d.Msd, "", paramc);
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[] { Integer.valueOf(i), paramc });
    AppMethodBeat.o(127201);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127202);
    super.onAccountRelease();
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("newtips", this.MrW);
    AppMethodBeat.o(127202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a
 * JD-Core Version:    0.7.0.1
 */