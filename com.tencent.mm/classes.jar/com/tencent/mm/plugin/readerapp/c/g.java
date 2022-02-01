package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.model.bq xmb;
  private c xmc;
  private a xmd;
  private d xme;
  private f xmf;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.model.bq.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public g()
  {
    AppMethodBeat.i(102673);
    this.xmc = new c();
    this.xmd = new a();
    this.xme = new d();
    this.xmf = new f();
    AppMethodBeat.o(102673);
  }
  
  private static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    com.tencent.mm.kernel.g.ajF().ay(new g.3(parama, paramInt));
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    dDD().oD(20);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    dDD().oD(11);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx("blogapp");
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
        if (this.xmg != null) {
          this.xmg.dDA();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  private static g dDC()
  {
    AppMethodBeat.i(102674);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static com.tencent.mm.model.bq dDD()
  {
    AppMethodBeat.i(102675);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dDC().xmb == null) {
      dDC().xmb = new com.tencent.mm.model.bq(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.model.bq localbq = dDC().xmb;
    AppMethodBeat.o(102675);
    return localbq;
  }
  
  public static void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    eV(dDD().ah(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  private static void eV(List<bp> paramList)
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
      bt.deleteFile(r.aLC(((bp)paramList.get(i)).aCp()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void yA(long paramLong)
  {
    AppMethodBeat.i(102680);
    eV(dDD().rK(paramLong));
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
    d.a.a(this.xmc);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102671);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          AppMethodBeat.o(102671);
          return;
        }
        bt.n(com.tencent.mm.plugin.image.d.azA(), "ReaderApp_", 604800000L);
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
    com.tencent.mm.sdk.b.a.IbL.c(this.xmd);
    com.tencent.mm.sdk.b.a.IbL.c(this.xme);
    com.tencent.mm.sdk.b.a.IbL.c(this.xmf);
    e locale = e.xma;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    d.a.b(this.xmc);
    com.tencent.mm.sdk.b.a.IbL.d(this.xmd);
    com.tencent.mm.sdk.b.a.IbL.d(this.xme);
    com.tencent.mm.sdk.b.a.IbL.d(this.xmf);
    e locale = e.xma;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void dDA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */