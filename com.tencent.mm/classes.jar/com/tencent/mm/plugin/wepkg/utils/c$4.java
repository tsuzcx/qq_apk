package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.i;
import java.util.List;

final class c$4
  implements Runnable
{
  c$4(c paramc, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(141561);
    int i = 0;
    while ((i < this.vHe.size()) && (i < 5))
    {
      String str = (String)this.vHe.get(i);
      i.dkE().bX(str, false);
      i += 1;
    }
    AppMethodBeat.o(141561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.4
 * JD-Core Version:    0.7.0.1
 */