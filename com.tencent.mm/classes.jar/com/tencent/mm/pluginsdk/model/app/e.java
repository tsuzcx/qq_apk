package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
  implements i
{
  private Map<Integer, Set<u>> lCH;
  
  public e()
  {
    AppMethodBeat.i(151661);
    this.lCH = new HashMap();
    h.aHF().kcd.a(452, this);
    AppMethodBeat.o(151661);
  }
  
  public static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151664);
    paramaa = new ab(paramInt, paramaa);
    h.aHF().kcd.a(paramaa, 0);
    AppMethodBeat.o(151664);
  }
  
  public final void a(final int paramInt, final u paramu)
  {
    AppMethodBeat.i(151662);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151658);
        if (!e.a(e.this).containsKey(Integer.valueOf(paramInt))) {
          e.a(e.this).put(Integer.valueOf(paramInt), new HashSet());
        }
        if ((e.a(e.this).get(Integer.valueOf(paramInt)) != null) && (!((Set)e.a(e.this).get(Integer.valueOf(paramInt))).contains(paramu))) {
          ((Set)e.a(e.this).get(Integer.valueOf(paramInt))).add(paramu);
        }
        AppMethodBeat.o(151658);
      }
    });
    AppMethodBeat.o(151662);
  }
  
  public final void b(final int paramInt, final u paramu)
  {
    AppMethodBeat.i(151663);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151659);
        if (e.a(e.this).get(Integer.valueOf(paramInt)) != null) {
          ((Set)e.a(e.this).get(Integer.valueOf(paramInt))).remove(paramu);
        }
        AppMethodBeat.o(151659);
      }
    });
    AppMethodBeat.o(151663);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(151665);
    if (!(paramq instanceof ab))
    {
      Log.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
      AppMethodBeat.o(151665);
      return;
    }
    paramq = (ab)paramq;
    Set localSet = (Set)this.lCH.get(Integer.valueOf(paramq.QWP));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        u localu = (u)((Iterator)localObject).next();
        if ((localu != null) && (localSet.contains(localu))) {
          localu.a(paramInt1, paramInt2, paramString, paramq.QWQ);
        }
      }
    }
    AppMethodBeat.o(151665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e
 * JD-Core Version:    0.7.0.1
 */