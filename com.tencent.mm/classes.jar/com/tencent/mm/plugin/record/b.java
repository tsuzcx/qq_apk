package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;

public final class b
{
  public static String YN()
  {
    AppMethodBeat.i(111119);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "recbiz/";
    AppMethodBeat.o(111119);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b
 * JD-Core Version:    0.7.0.1
 */