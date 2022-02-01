package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bs xBY;
  private c xBZ;
  private a xCa;
  private d xCb;
  private f xCc;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bs.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public g()
  {
    AppMethodBeat.i(102673);
    this.xBZ = new c();
    this.xCa = new a();
    this.xCb = new d();
    this.xCc = new f();
    AppMethodBeat.o(102673);
  }
  
  private static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    com.tencent.mm.kernel.g.ajU().aw(new g.3(parama, paramInt));
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    dGU().oG(20);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    dGU().oG(11);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY("blogapp");
    a(11, parama);
    AppMethodBeat.o(102679);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(102683);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102668);
        if (this.xCd != null) {
          this.xCd.dGR();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  private static g dGT()
  {
    AppMethodBeat.i(102674);
    g localg = (g)u.ap(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static bs dGU()
  {
    AppMethodBeat.i(102675);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dGT().xBY == null) {
      dGT().xBY = new bs(com.tencent.mm.kernel.g.ajR().gDX);
    }
    bs localbs = dGT().xBY;
    AppMethodBeat.o(102675);
    return localbs;
  }
  
  public static void eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    fd(dGU().ai(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  private static void fd(List<com.tencent.mm.model.br> paramList)
  {
    AppMethodBeat.i(102682);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(102682);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      bu.deleteFile(r.aMY(((com.tencent.mm.model.br)paramList.get(i)).aCF()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void yZ(long paramLong)
  {
    AppMethodBeat.i(102680);
    fd(dGU().rX(paramLong));
    AppMethodBeat.o(102680);
  }
  
  public void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(102677);
    if ((0x80000 & paramInt) != 0) {
      a(null);
    }
    if ((0x40000 & paramInt) != 0) {
      b(null);
    }
    AppMethodBeat.o(102677);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(102685);
    d.a.a(this.xBZ);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102671);
        if (!com.tencent.mm.kernel.g.ajM())
        {
          AppMethodBeat.o(102671);
          return;
        }
        bu.n(com.tencent.mm.plugin.image.d.azQ(), "ReaderApp_", 604800000L);
        AppMethodBeat.o(102671);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(102672);
        String str = super.toString() + "|onAccountPostReset";
        AppMethodBeat.o(102672);
        return str;
      }
    });
    com.tencent.mm.sdk.b.a.IvT.c(this.xCa);
    com.tencent.mm.sdk.b.a.IvT.c(this.xCb);
    com.tencent.mm.sdk.b.a.IvT.c(this.xCc);
    e locale = e.xBX;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    d.a.b(this.xBZ);
    com.tencent.mm.sdk.b.a.IvT.d(this.xCa);
    com.tencent.mm.sdk.b.a.IvT.d(this.xCb);
    com.tencent.mm.sdk.b.a.IvT.d(this.xCc);
    e locale = e.xBX;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void dGR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */