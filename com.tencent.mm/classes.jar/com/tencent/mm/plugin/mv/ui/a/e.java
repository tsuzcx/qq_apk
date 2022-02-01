package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toLowerSec", "", "toRoundSec", "toUpperSec", "plugin-mv_release"})
public final class e
{
  public static final int ZI(int paramInt)
  {
    AppMethodBeat.i(242040);
    paramInt = (int)(float)Math.ceil(paramInt / 1000.0F);
    AppMethodBeat.o(242040);
    return paramInt;
  }
  
  public static final int ZJ(int paramInt)
  {
    AppMethodBeat.i(242041);
    paramInt = (int)(float)Math.floor(paramInt / 1000.0F);
    AppMethodBeat.o(242041);
    return paramInt;
  }
  
  public static final int ZK(int paramInt)
  {
    AppMethodBeat.i(242042);
    paramInt = (int)(float)Math.rint(paramInt / 1000.0F);
    AppMethodBeat.o(242042);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.e
 * JD-Core Version:    0.7.0.1
 */