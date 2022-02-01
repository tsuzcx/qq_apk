package com.tencent.mm.plugin.readerapp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.List;

public class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.model.by NvI;
  private b NvJ;
  private BindQQEventListenerImpl NvK;
  private ReaderAppOperationListener NvL;
  private RollbackTencentNewsListener NvM;
  
  static
  {
    AppMethodBeat.i(102687);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.model.by.SQL_CREATE;
      }
    });
    AppMethodBeat.o(102687);
  }
  
  public d()
  {
    AppMethodBeat.i(102673);
    this.NvJ = new b();
    this.NvK = new BindQQEventListenerImpl();
    this.NvL = new ReaderAppOperationListener();
    this.NvM = new RollbackTencentNewsListener();
    AppMethodBeat.o(102673);
  }
  
  private static void a(final int paramInt, a parama)
  {
    AppMethodBeat.i(102684);
    if (!h.baz())
    {
      c(parama);
      AppMethodBeat.o(102684);
      return;
    }
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(102669);
        Object localObject = new u(com.tencent.mm.plugin.image.d.bzL());
        if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
        {
          d.d(d.this);
          AppMethodBeat.o(102669);
          return;
        }
        localObject = ((u)localObject).jKX();
        if ((localObject == null) || (localObject.length <= 0))
        {
          d.d(d.this);
          AppMethodBeat.o(102669);
          return;
        }
        String str1 = String.format("reader_%d_", new Object[] { Integer.valueOf(paramInt) });
        String str2 = String.format("ReaderApp_%d", new Object[] { Integer.valueOf(paramInt) });
        while (i < localObject.length)
        {
          if ((d.this != null) && (d.this.aMJ()))
          {
            d.d(d.this);
            AppMethodBeat.o(102669);
            return;
          }
          if (localObject[i].getName().startsWith(str1)) {
            localObject[i].diJ();
          }
          if (localObject[i].getName().startsWith(str2)) {
            localObject[i].diJ();
          }
          i += 1;
        }
        d.d(d.this);
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
    gFB().vo(20);
    ((n)h.ax(n.class)).bzG().bxK("newsapp");
    a(20, parama);
    AppMethodBeat.o(102678);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(102679);
    gFB().vo(11);
    ((n)h.ax(n.class)).bzG().bxK("blogapp");
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
        if (d.this != null) {
          d.this.gFy();
        }
        AppMethodBeat.o(102668);
      }
    });
    AppMethodBeat.o(102683);
  }
  
  public static void gC(String paramString, int paramInt)
  {
    AppMethodBeat.i(102681);
    jD(gFB().aP(paramString, paramInt));
    AppMethodBeat.o(102681);
  }
  
  private static d gFA()
  {
    AppMethodBeat.i(102674);
    d locald = (d)com.tencent.mm.model.y.aL(d.class);
    AppMethodBeat.o(102674);
    return locald;
  }
  
  public static com.tencent.mm.model.by gFB()
  {
    AppMethodBeat.i(102675);
    h.baC().aZJ();
    if (gFA().NvI == null) {
      gFA().NvI = new com.tencent.mm.model.by(h.baE().mCN);
    }
    com.tencent.mm.model.by localby = gFA().NvI;
    AppMethodBeat.o(102675);
    return localby;
  }
  
  private static void jD(List<bx> paramList)
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
      Util.deleteFile(com.tencent.mm.pluginsdk.model.y.bpF(((bx)paramList.get(i)).bCX()));
      i += 1;
    }
    AppMethodBeat.o(102682);
  }
  
  public static void tk(long paramLong)
  {
    AppMethodBeat.i(102680);
    jD(gFB().iv(paramLong));
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
    f.a.a(this.NvJ);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102671);
        if (!h.baz())
        {
          AppMethodBeat.o(102671);
          return;
        }
        Util.deleteOutOfDateFile(com.tencent.mm.plugin.image.d.bzL(), "ReaderApp_", 604800000L);
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
    this.NvK.alive();
    this.NvL.alive();
    this.NvM.alive();
    c localc = c.NvH;
    AppMethodBeat.o(102685);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102676);
    f.a.b(this.NvJ);
    this.NvK.dead();
    this.NvL.dead();
    this.NvM.dead();
    c localc = c.NvH;
    AppMethodBeat.o(102676);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract boolean aMJ();
    
    public abstract void gFy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.d
 * JD-Core Version:    0.7.0.1
 */