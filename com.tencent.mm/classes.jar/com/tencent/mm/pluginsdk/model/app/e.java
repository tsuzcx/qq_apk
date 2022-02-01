package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
  implements f
{
  Map<Integer, Set<u>> hOz;
  
  public e()
  {
    AppMethodBeat.i(151661);
    this.hOz = new HashMap();
    g.ajB().gAO.a(452, this);
    AppMethodBeat.o(151661);
  }
  
  public static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151664);
    paramaa = new ab(paramInt, paramaa);
    g.ajB().gAO.a(paramaa, 0);
    AppMethodBeat.o(151664);
  }
  
  public final void a(final int paramInt, final u paramu)
  {
    AppMethodBeat.i(151662);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151658);
        if (!e.this.hOz.containsKey(Integer.valueOf(paramInt))) {
          e.this.hOz.put(Integer.valueOf(paramInt), new HashSet());
        }
        if ((e.this.hOz.get(Integer.valueOf(paramInt)) != null) && (!((Set)e.this.hOz.get(Integer.valueOf(paramInt))).contains(paramu))) {
          ((Set)e.this.hOz.get(Integer.valueOf(paramInt))).add(paramu);
        }
        AppMethodBeat.o(151658);
      }
    });
    AppMethodBeat.o(151662);
  }
  
  public final void b(final int paramInt, final u paramu)
  {
    AppMethodBeat.i(151663);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151659);
        if (e.this.hOz.get(Integer.valueOf(paramInt)) != null) {
          ((Set)e.this.hOz.get(Integer.valueOf(paramInt))).remove(paramu);
        }
        AppMethodBeat.o(151659);
      }
    });
    AppMethodBeat.o(151663);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(151665);
    if (!(paramn instanceof ab))
    {
      ad.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
      AppMethodBeat.o(151665);
      return;
    }
    paramn = (ab)paramn;
    Set localSet = (Set)this.hOz.get(Integer.valueOf(paramn.ENi));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        u localu = (u)((Iterator)localObject).next();
        if ((localu != null) && (localSet.contains(localu))) {
          localu.a(paramInt1, paramInt2, paramString, paramn.ENj);
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