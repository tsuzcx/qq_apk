package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
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
  Map<Integer, Set<u>> iMA;
  
  public e()
  {
    AppMethodBeat.i(151661);
    this.iMA = new HashMap();
    g.aAg().hqi.a(452, this);
    AppMethodBeat.o(151661);
  }
  
  public static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151664);
    paramaa = new ab(paramInt, paramaa);
    g.aAg().hqi.a(paramaa, 0);
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
        if (!e.this.iMA.containsKey(Integer.valueOf(paramInt))) {
          e.this.iMA.put(Integer.valueOf(paramInt), new HashSet());
        }
        if ((e.this.iMA.get(Integer.valueOf(paramInt)) != null) && (!((Set)e.this.iMA.get(Integer.valueOf(paramInt))).contains(paramu))) {
          ((Set)e.this.iMA.get(Integer.valueOf(paramInt))).add(paramu);
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
        if (e.this.iMA.get(Integer.valueOf(paramInt)) != null) {
          ((Set)e.this.iMA.get(Integer.valueOf(paramInt))).remove(paramu);
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
    Set localSet = (Set)this.iMA.get(Integer.valueOf(paramq.JWw));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        u localu = (u)((Iterator)localObject).next();
        if ((localu != null) && (localSet.contains(localu))) {
          localu.a(paramInt1, paramInt2, paramString, paramq.JWx);
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