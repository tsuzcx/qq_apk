package com.tencent.mm.plugin.search.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.b.a.a.a;
import java.util.HashMap;

public final class b
  implements at
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24403);
    Object localObject = new a();
    ((n)g.G(n.class)).registerItemClickHandler(3, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
    localObject = new com.tencent.mm.plugin.search.b.a.a.b();
    ((n)g.G(n.class)).registerItemClickHandler(6, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
    AppMethodBeat.o(24403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24404);
    ((n)g.G(n.class)).unregisterItemClickHandler(3);
    ((n)g.G(n.class)).unregisterItemClickHandler(6);
    AppMethodBeat.o(24404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.b
 * JD-Core Version:    0.7.0.1
 */