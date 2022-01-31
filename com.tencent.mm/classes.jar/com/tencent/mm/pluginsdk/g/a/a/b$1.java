package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(79467);
    s locals = q.a.dmz().alQ(i.hd(this.onf, this.ong));
    if ((locals != null) && ((-1 == this.gTU) || (String.valueOf(this.gTU).equals(locals.field_fileVersion)))) {
      if (this.vMY) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      locals.field_needRetry = bool;
      q.a.dmz().h(locals);
      AppMethodBeat.o(79467);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */