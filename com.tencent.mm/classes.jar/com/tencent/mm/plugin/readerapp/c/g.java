package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bp uVD;
  private c uVE;
  private a uVF;
  private d uVG;
  private f uVH;
  
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
    this.uVE = new c();
    this.uVF = new a();
    this.uVG = new d();
    this.uVH = new f();
    AppMethodBeat.o(102673);
  }
  
  private static void a(final int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!com.tencent.mm.kernel.g.afw())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(102669);
        Object localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.image.d.apW());
        if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory()))
        {
          g.d(this.uVI);
          AppMethodBeat.o(102669);
          return;
        }
        localObject = ((com.tencent.mm.vfs.e)localObject).fhW();
        if ((localObject == null) || (localObject.length <= 0))
        {
          g.d(this.uVI);
          AppMethodBeat.o(102669);
          return;
        }
        String str1 = String.format("reader_%d_", new Object[] { Integer.valueOf(paramInt) });
        String str2 = String.format("ReaderApp_%d", new Object[] { Integer.valueOf(paramInt) });
        while (i < localObject.length)
        {
          if (localObject[i].getName().startsWith(str1)) {
            localObject[i].delete();
          }
          if (localObject[i].getName().startsWith(str2)) {
            localObject[i].delete();
          }
          i += 1;
        }
        g.d(this.uVI);
        AppMethodBeat.o(102669);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(102670);
        String str = super.toString() + "|deleteAllPic";
        AppMethodBeat.o(102670);
        return str;
      }
    });
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    dfz().np(20);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIl("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    dfz().np(11);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIl("blogapp");
    a(11, parama);
    AppMethodBeat.o(102679);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(102683);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102668);
        if (this.uVI != null) {
          this.uVI.dfw();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  private static g dfy()
  {
    AppMethodBeat.i(102674);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static bp dfz()
  {
    AppMethodBeat.i(102675);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dfy().uVD == null) {
      dfy().uVD = new bp(com.tencent.mm.kernel.g.afB().gda);
    }
    bp localbp = dfy().uVD;
    AppMethodBeat.o(102675);
    return localbp;
  }
  
  private static void eC(List<bo> paramList)
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
      bt.deleteFile(r.aAK(((bo)paramList.get(i)).asu()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    eC(dfz().Z(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  public static void rM(long paramLong)
  {
    AppMethodBeat.i(102680);
    eC(dfz().lX(paramLong));
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
    e.a.a(this.uVE);
    com.tencent.mm.kernel.g.afE().ax(new g.4(this));
    com.tencent.mm.sdk.b.a.ESL.c(this.uVF);
    com.tencent.mm.sdk.b.a.ESL.c(this.uVG);
    com.tencent.mm.sdk.b.a.ESL.c(this.uVH);
    e locale = e.uVC;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    e.a.b(this.uVE);
    com.tencent.mm.sdk.b.a.ESL.d(this.uVF);
    com.tencent.mm.sdk.b.a.ESL.d(this.uVG);
    com.tencent.mm.sdk.b.a.ESL.d(this.uVH);
    e locale = e.uVC;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void dfw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */