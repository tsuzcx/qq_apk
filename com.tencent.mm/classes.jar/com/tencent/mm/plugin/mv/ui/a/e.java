package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"toLowerSec", "", "toRoundSec", "toUpperSec", "plugin-mv_release"})
public final class e
{
  public static final int Tl(int paramInt)
  {
    AppMethodBeat.i(257039);
    paramInt = (int)(float)Math.ceil(paramInt / 1000.0F);
    AppMethodBeat.o(257039);
    return paramInt;
  }
  
  public static final int Tm(int paramInt)
  {
    AppMethodBeat.i(257040);
    paramInt = (int)(float)Math.floor(paramInt / 1000.0F);
    AppMethodBeat.o(257040);
    return paramInt;
  }
  
  public static final int Tn(int paramInt)
  {
    AppMethodBeat.i(257041);
    paramInt = (int)(float)Math.rint(paramInt / 1000.0F);
    AppMethodBeat.o(257041);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.e
 * JD-Core Version:    0.7.0.1
 */