package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;

public final class a
  implements com.tencent.mm.plugin.sns.b.a
{
  public final void r(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(94884);
    paramString = new i(paramInt1, paramString, paramInt2);
    g.aAi();
    g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(94884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a
 * JD-Core Version:    0.7.0.1
 */