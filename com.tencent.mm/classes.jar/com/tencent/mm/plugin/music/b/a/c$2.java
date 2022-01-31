package com.tencent.mm.plugin.music.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;

final class c$2
  implements Runnable
{
  c$2(c paramc, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(104817);
    String str = this.oXh + "-" + ag.cE(this.hvi);
    for (;;)
    {
      synchronized (c.bFm())
      {
        if (c.bFm().containsKey(str))
        {
          c.bFm().put(str, Integer.valueOf(((Integer)c.bFm().get(str)).intValue() + 1));
          if (!this.oXP)
          {
            c.alA();
            AppMethodBeat.o(104817);
          }
        }
        else
        {
          c.bFm().put(str, Integer.valueOf(1));
        }
      }
      c.bUN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.c.2
 * JD-Core Version:    0.7.0.1
 */