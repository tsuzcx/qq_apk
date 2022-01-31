package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.d.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.vfs.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private bm pTI;
  private c pTJ;
  private a pTK;
  private d pTL;
  private f pTM;
  
  static
  {
    AppMethodBeat.i(76783);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new g.1());
    AppMethodBeat.o(76783);
  }
  
  public g()
  {
    AppMethodBeat.i(76769);
    this.pTJ = new c();
    this.pTK = new a();
    this.pTL = new d();
    this.pTM = new f();
    AppMethodBeat.o(76769);
  }
  
  private static void a(final int paramInt, g.a parama)
  {
    AppMethodBeat.i(76780);
    if (!com.tencent.mm.kernel.g.RG())
    {
      c(parama);
      AppMethodBeat.o(76780);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(76765);
        Object localObject = new b(com.tencent.mm.plugin.i.c.YK());
        if ((!((b)localObject).exists()) || (!((b)localObject).isDirectory()))
        {
          g.d(this.pTN);
          AppMethodBeat.o(76765);
          return;
        }
        localObject = ((b)localObject).dQL();
        if ((localObject == null) || (localObject.length <= 0))
        {
          g.d(this.pTN);
          AppMethodBeat.o(76765);
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
        g.d(this.pTN);
        AppMethodBeat.o(76765);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(76766);
        String str = super.toString() + "|deleteAllPic";
        AppMethodBeat.o(76766);
        return str;
      }
    });
    AppMethodBeat.o(76780);
  }
  
  public static void a(g.a parama)
  {
    AppMethodBeat.i(76774);
    cfl().kI(20);
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arF("newsapp");
    a(20, parama);
    AppMethodBeat.o(76774);
  }
  
  public static void b(g.a parama)
  {
    AppMethodBeat.i(76775);
    cfl().kI(11);
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arF("blogapp");
    a(11, parama);
    AppMethodBeat.o(76775);
  }
  
  private static void c(g.a parama)
  {
    AppMethodBeat.i(76779);
    al.d(new g.2(parama));
    AppMethodBeat.o(76779);
  }
  
  private static void cG(List<bl> paramList)
  {
    AppMethodBeat.i(141044);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(141044);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      bo.deleteFile(p.aln(((bl)paramList.get(i)).aaZ()));
      i += 1;
    }
    AppMethodBeat.o(141044);
  }
  
  private static g cfk()
  {
    AppMethodBeat.i(76770);
    g localg = (g)q.S(g.class);
    AppMethodBeat.o(76770);
    return localg;
  }
  
  public static bm cfl()
  {
    AppMethodBeat.i(76771);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (cfk().pTI == null) {
      cfk().pTI = new bm(com.tencent.mm.kernel.g.RL().eHS);
    }
    bm localbm = cfk().pTI;
    AppMethodBeat.o(76771);
    return localbm;
  }
  
  public static void de(String paramString, int paramInt)
  {
    AppMethodBeat.i(76777);
    cG(cfl().Q(paramString, paramInt));
    AppMethodBeat.o(76777);
  }
  
  public static void kV(long paramLong)
  {
    AppMethodBeat.i(76776);
    cG(cfl().gx(paramLong));
    AppMethodBeat.o(76776);
  }
  
  public void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(76773);
    if ((0x80000 & paramInt) != 0) {
      a(null);
    }
    if ((0x40000 & paramInt) != 0) {
      b(null);
    }
    AppMethodBeat.o(76773);
  }
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(76781);
    d.a.a(this.pTJ);
    com.tencent.mm.kernel.g.RO().ac(new g.4(this));
    com.tencent.mm.sdk.b.a.ymk.c(this.pTK);
    com.tencent.mm.sdk.b.a.ymk.c(this.pTL);
    com.tencent.mm.sdk.b.a.ymk.c(this.pTM);
    e locale = e.pTH;
    AppMethodBeat.o(76781);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76772);
    d.a.b(this.pTJ);
    com.tencent.mm.sdk.b.a.ymk.d(this.pTK);
    com.tencent.mm.sdk.b.a.ymk.d(this.pTL);
    com.tencent.mm.sdk.b.a.ymk.d(this.pTM);
    e locale = e.pTH;
    AppMethodBeat.o(76772);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */