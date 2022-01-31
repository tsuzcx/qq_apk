package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    s locals = q.a.clL().Wl(i.eW(this.lPI, this.lPJ));
    if ((locals != null) && ((-1 == this.iiK) || (String.valueOf(this.iiK).equals(locals.field_fileVersion)))) {
      if (this.rWh) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      locals.field_needRetry = bool;
      q.a.clL().g(locals);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */