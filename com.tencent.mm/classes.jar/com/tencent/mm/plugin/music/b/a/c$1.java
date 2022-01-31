package com.tencent.mm.plugin.music.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(104816);
    String str = this.oXh + "-" + ag.cE(this.hvi);
    synchronized (c.bFm())
    {
      if (c.Nt().containsKey(str))
      {
        c.Nt().put(str, Integer.valueOf(((Integer)c.Nt().get(str)).intValue() + 1));
        c.bUM();
        AppMethodBeat.o(104816);
        return;
      }
      c.Nt().put(str, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.c.1
 * JD-Core Version:    0.7.0.1
 */