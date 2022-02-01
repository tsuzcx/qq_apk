package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bx Hyd;
  private c Hye;
  private a Hyf;
  private d Hyg;
  private f Hyh;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bx.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public g()
  {
    AppMethodBeat.i(102673);
    this.Hye = new c();
    this.Hyf = new a();
    this.Hyg = new d();
    this.Hyh = new f();
    AppMethodBeat.o(102673);
  }
  
  public static void Pk(long paramLong)
  {
    AppMethodBeat.i(102680);
    gD(ftN().Gl(paramLong));
    AppMethodBeat.o(102680);
  }
  
  private static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!h.aHB())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    h.aHJ().postToWorker(new g.3(parama, paramInt));
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    ftN().ve(20);
    ((n)h.ae(n.class)).bbR().bwv("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    ftN().ve(11);
    ((n)h.ae(n.class)).bbR().bwv("blogapp");
    a(11, parama);
    AppMethodBeat.o(102679);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(102683);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102668);
        if (this.Hyi != null) {
          this.Hyi.ftK();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  public static void fK(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    gD(ftN().aD(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  private static g ftM()
  {
    AppMethodBeat.i(102674);
    g localg = (g)y.as(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static bx ftN()
  {
    AppMethodBeat.i(102675);
    h.aHE().aGH();
    if (ftM().Hyd == null) {
      ftM().Hyd = new bx(h.aHG().kcF);
    }
    bx localbx = ftM().Hyd;
    AppMethodBeat.o(102675);
    return localbx;
  }
  
  private static void gD(List<com.tencent.mm.model.bw> paramList)
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
      Util.deleteFile(w.bpO(((com.tencent.mm.model.bw)paramList.get(i)).bfg()));
      i += 1;
    }
    AppMethodBeat.o(102682);
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
    com.tencent.mm.an.g.a.a(this.Hye);
    h.aHJ().postToWorker(new g.4(this));
    EventCenter.instance.addListener(this.Hyf);
    EventCenter.instance.addListener(this.Hyg);
    EventCenter.instance.addListener(this.Hyh);
    e locale = e.Hyc;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    com.tencent.mm.an.g.a.b(this.Hye);
    EventCenter.instance.removeListener(this.Hyf);
    EventCenter.instance.removeListener(this.Hyg);
    EventCenter.instance.removeListener(this.Hyh);
    e locale = e.Hyc;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void ftK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */