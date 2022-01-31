package com.tencent.mm.plugin.search.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.b.a.a.a;
import java.util.HashMap;

public final class b
  implements ar
{
  public final void bh(boolean paramBoolean)
  {
    Object localObject = new a();
    ((n)g.t(n.class)).registerItemClickHandler(3, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
    localObject = new com.tencent.mm.plugin.search.b.a.a.b();
    ((n)g.t(n.class)).registerItemClickHandler(6, (com.tencent.mm.plugin.fts.a.d.a.b)localObject);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((n)g.t(n.class)).unregisterItemClickHandler(3);
    ((n)g.t(n.class)).unregisterItemClickHandler(6);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.b
 * JD-Core Version:    0.7.0.1
 */