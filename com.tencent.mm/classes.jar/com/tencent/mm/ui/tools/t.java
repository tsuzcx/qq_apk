package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class t
{
  public static int iF(Context paramContext)
  {
    AppMethodBeat.i(107812);
    float f = a.dr(paramContext);
    if (Float.compare(f, a.gi(paramContext)) > 0)
    {
      AppMethodBeat.o(107812);
      return 2130840639;
    }
    if (Float.compare(f, a.gg(paramContext)) > 0)
    {
      AppMethodBeat.o(107812);
      return 2130840640;
    }
    AppMethodBeat.o(107812);
    return 2130840638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */