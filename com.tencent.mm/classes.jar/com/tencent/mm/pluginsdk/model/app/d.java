package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements f
{
  public Map<Integer, Set<t>> edB = new HashMap();
  
  public d()
  {
    g.DO().dJT.a(452, this);
  }
  
  public static void a(int paramInt, x paramx)
  {
    paramx = new y(paramInt, paramx);
    g.DO().dJT.a(paramx, 0);
  }
  
  public final void a(int paramInt, t paramt)
  {
    if (!this.edB.containsKey(Integer.valueOf(paramInt))) {
      this.edB.put(Integer.valueOf(paramInt), new HashSet());
    }
    if (!((Set)this.edB.get(Integer.valueOf(paramInt))).contains(paramt)) {
      ((Set)this.edB.get(Integer.valueOf(paramInt))).add(paramt);
    }
  }
  
  public final void b(int paramInt, t paramt)
  {
    if (this.edB.get(Integer.valueOf(paramInt)) != null) {
      ((Set)this.edB.get(Integer.valueOf(paramInt))).remove(paramt);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (!(paramm instanceof y)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
    }
    for (;;)
    {
      return;
      paramm = (y)paramm;
      Set localSet = (Set)this.edB.get(Integer.valueOf(paramm.rUy));
      if ((localSet != null) && (localSet.size() > 0))
      {
        Object localObject = new HashSet();
        ((Set)localObject).addAll(localSet);
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          t localt = (t)((Iterator)localObject).next();
          if ((localt != null) && (localSet.contains(localt))) {
            localt.a(paramInt1, paramInt2, paramString, paramm.rUz);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d
 * JD-Core Version:    0.7.0.1
 */