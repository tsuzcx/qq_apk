package com.tencent.mm.plugin.search.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.ui.a.a.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements be
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28070);
    Object localObject = new a();
    ((n)h.az(n.class)).registerItemClickHandler(3, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
    localObject = new com.tencent.mm.plugin.search.ui.a.a.b();
    ((n)h.az(n.class)).registerItemClickHandler(5, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
    AppMethodBeat.o(28070);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28071);
    ((n)h.az(n.class)).unregisterItemClickHandler(3);
    ((n)h.az(n.class)).unregisterItemClickHandler(5);
    AppMethodBeat.o(28071);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.b
 * JD-Core Version:    0.7.0.1
 */