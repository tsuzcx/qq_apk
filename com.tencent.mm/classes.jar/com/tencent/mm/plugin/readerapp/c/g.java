package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.model.bw BBY;
  private c BBZ;
  private a BCa;
  private d BCb;
  private f BCc;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.model.bw.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public g()
  {
    AppMethodBeat.i(102673);
    this.BBZ = new c();
    this.BCa = new a();
    this.BCb = new d();
    this.BCc = new f();
    AppMethodBeat.o(102673);
  }
  
  public static void HP(long paramLong)
  {
    AppMethodBeat.i(102680);
    fZ(eHI().Ae(paramLong));
    AppMethodBeat.o(102680);
  }
  
  private static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new g.3(parama, paramInt));
    AppMethodBeat.o(102684);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(102678);
    eHI().sh(20);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    eHI().sh(11);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW("blogapp");
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
        if (this.BCd != null) {
          this.BCd.eHF();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  private static g eHH()
  {
    AppMethodBeat.i(102674);
    g localg = (g)y.at(g.class);
    AppMethodBeat.o(102674);
    return localg;
  }
  
  public static com.tencent.mm.model.bw eHI()
  {
    AppMethodBeat.i(102675);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eHH().BBY == null) {
      eHH().BBY = new com.tencent.mm.model.bw(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.model.bw localbw = eHH().BBY;
    AppMethodBeat.o(102675);
    return localbw;
  }
  
  private static void fZ(List<bv> paramList)
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
      Util.deleteFile(s.bdu(((bv)paramList.get(i)).aWd()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    fZ(eHI().al(paramString, paramInt));
    AppMethodBeat.o(102681);
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
    com.tencent.mm.ak.g.a.a(this.BBZ);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102671);
        if (!com.tencent.mm.kernel.g.aAc())
        {
          AppMethodBeat.o(102671);
          return;
        }
        Util.deleteOutOfDateFile(com.tencent.mm.plugin.image.d.aSY(), "ReaderApp_", 604800000L);
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
    EventCenter.instance.addListener(this.BCa);
    EventCenter.instance.addListener(this.BCb);
    EventCenter.instance.addListener(this.BCc);
    e locale = e.BBX;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    com.tencent.mm.ak.g.a.b(this.BBZ);
    EventCenter.instance.removeListener(this.BCa);
    EventCenter.instance.removeListener(this.BCb);
    EventCenter.instance.removeListener(this.BCc);
    e locale = e.BBX;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void eHF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */