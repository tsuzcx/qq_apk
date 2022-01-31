package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements f
{
  Map<Integer, Set<t>> ftE;
  
  public d()
  {
    AppMethodBeat.i(79237);
    this.ftE = new HashMap();
    g.RK().eHt.a(452, this);
    AppMethodBeat.o(79237);
  }
  
  public static void a(int paramInt, x paramx)
  {
    AppMethodBeat.i(79240);
    paramx = new y(paramInt, paramx);
    g.RK().eHt.a(paramx, 0);
    AppMethodBeat.o(79240);
  }
  
  public final void a(int paramInt, t paramt)
  {
    AppMethodBeat.i(79238);
    al.d(new d.1(this, paramInt, paramt));
    AppMethodBeat.o(79238);
  }
  
  public final void b(int paramInt, t paramt)
  {
    AppMethodBeat.i(79239);
    al.d(new d.2(this, paramInt, paramt));
    AppMethodBeat.o(79239);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(79241);
    if (!(paramm instanceof y))
    {
      ab.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
      AppMethodBeat.o(79241);
      return;
    }
    paramm = (y)paramm;
    Set localSet = (Set)this.ftE.get(Integer.valueOf(paramm.vLw));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        t localt = (t)((Iterator)localObject).next();
        if ((localt != null) && (localSet.contains(localt))) {
          localt.a(paramInt1, paramInt2, paramString, paramm.vLx);
        }
      }
    }
    AppMethodBeat.o(79241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d
 * JD-Core Version:    0.7.0.1
 */