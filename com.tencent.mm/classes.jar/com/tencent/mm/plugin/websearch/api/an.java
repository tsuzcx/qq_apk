package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import org.xwalk.core.XWalkEnvironment;

public final class an
{
  public static int vP(int paramInt)
  {
    AppMethodBeat.i(161715);
    if (XWalkEnvironment.getUsingCustomContext())
    {
      paramInt = Math.round(com.tencent.mm.cb.a.getDensity(ak.getContext()) * paramInt);
      AppMethodBeat.o(161715);
      return paramInt;
    }
    paramInt = Math.round(com.tencent.mm.cc.a.flD() * paramInt);
    AppMethodBeat.o(161715);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */