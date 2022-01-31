package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax.a;

final class a$1
  implements ax.a
{
  a$1(a parama) {}
  
  public final void ie(int paramInt)
  {
    AppMethodBeat.i(137547);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137547);
      return;
      if (this.paC.oXj)
      {
        this.paC.oXj = false;
        this.paC.resume();
        AppMethodBeat.o(137547);
        return;
        if (this.paC.aiw())
        {
          this.paC.oXj = true;
          this.paC.pause();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.1
 * JD-Core Version:    0.7.0.1
 */