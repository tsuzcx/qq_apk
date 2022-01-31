package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class g$8
  implements Runnable
{
  g$8(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(36143);
    if (g.d(this.rdL))
    {
      ab.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(36143);
      return;
    }
    if (g.e(this.rdL).size() > 0)
    {
      ab.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(this.rdL).size());
      ((g.b)g.e(this.rdL).removeLast()).v(new String[] { "" });
    }
    AppMethodBeat.o(36143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.8
 * JD-Core Version:    0.7.0.1
 */