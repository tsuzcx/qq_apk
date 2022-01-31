package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax.a;

final class g$1
  implements ax.a
{
  g$1(g paramg) {}
  
  public final void ie(int paramInt)
  {
    AppMethodBeat.i(137346);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137346);
      return;
      if (this.oXl.oXj)
      {
        this.oXl.oXj = false;
        this.oXl.resume();
        AppMethodBeat.o(137346);
        return;
        if (this.oXl.aiw())
        {
          this.oXl.oXj = true;
          this.oXl.pause();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.1
 * JD-Core Version:    0.7.0.1
 */