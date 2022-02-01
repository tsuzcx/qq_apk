package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"toLowerSec", "", "toRoundSec", "toUpperSec", "plugin-mv_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final int adV(int paramInt)
  {
    AppMethodBeat.i(288168);
    paramInt = (int)(float)Math.ceil(paramInt / 1000.0F);
    AppMethodBeat.o(288168);
    return paramInt;
  }
  
  public static final int adW(int paramInt)
  {
    AppMethodBeat.i(288173);
    paramInt = (int)(float)Math.floor(paramInt / 1000.0F);
    AppMethodBeat.o(288173);
    return paramInt;
  }
  
  public static final int adX(int paramInt)
  {
    AppMethodBeat.i(288180);
    paramInt = (int)(float)Math.rint(paramInt / 1000.0F);
    AppMethodBeat.o(288180);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.e
 * JD-Core Version:    0.7.0.1
 */