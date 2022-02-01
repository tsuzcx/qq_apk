package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;

public final class m
  implements g
{
  public final void Pm(long paramLong)
  {
    AppMethodBeat.i(27804);
    ao.hhJ();
    an.a.Pm(paramLong);
    AppMethodBeat.o(27804);
  }
  
  public final boolean h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27805);
    boolean bool = p.b(p.jM(paramString1, paramString2), paramLong, true);
    AppMethodBeat.o(27805);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.m
 * JD-Core Version:    0.7.0.1
 */