package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bp wes;
  private c wet;
  private a weu;
  private d wev;
  private f wew;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bp.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public g()
  {
    AppMethodBeat.i(102673);
    this.wet = new c();
    this.weu = new a();
    this.wev = new d();
    this.wew = new f();
    AppMethodBeat.o(102673);
  }
  
  private static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!com.tencent.mm.kernel.g.agM())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    com.tencent.mm.kernel.g.agU().az(new g.3(parama, paramInt));
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    dtg().od(20);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    dtg().od(11);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG("blogapp");
    a(11, parama);
    AppMethodBeat.o(102679);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(102683);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102668);
        if (this.wex != null) {
          this.wex.dtd();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  private static g dtf()
  {
    AppMethodBeat.i(102674);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static bp dtg()
  {
    AppMethodBeat.i(102675);
    com.tencent.mm.kernel.g.agP().afT();
    if (dtf().wes == null) {
      dtf().wes = new bp(com.tencent.mm.kernel.g.agR().ghG);
    }
    bp localbp = dtf().wes;
    AppMethodBeat.o(102675);
    return localbp;
  }
  
  private static void eG(List<bo> paramList)
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
      bs.deleteFile(r.aGc(((bo)paramList.get(i)).azl()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void ep(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    eG(dtg().ad(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  public static void wp(long paramLong)
  {
    AppMethodBeat.i(102680);
    eG(dtg().pL(paramLong));
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
    e.a.a(this.wet);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102671);
        if (!com.tencent.mm.kernel.g.agM())
        {
          AppMethodBeat.o(102671);
          return;
        }
        bs.z(com.tencent.mm.plugin.image.d.awL(), "ReaderApp_", 604800000L);
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
    com.tencent.mm.sdk.b.a.GpY.c(this.weu);
    com.tencent.mm.sdk.b.a.GpY.c(this.wev);
    com.tencent.mm.sdk.b.a.GpY.c(this.wew);
    e locale = e.wer;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    e.a.b(this.wet);
    com.tencent.mm.sdk.b.a.GpY.d(this.weu);
    com.tencent.mm.sdk.b.a.GpY.d(this.wev);
    com.tencent.mm.sdk.b.a.GpY.d(this.wew);
    e locale = e.wer;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void dtd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */