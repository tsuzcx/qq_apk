package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public final class u
{
  public static int aG(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(177648);
    if (Float.compare(a.dT(paramContext), a.hH(paramContext)) > 0)
    {
      if (paramInt < 10)
      {
        AppMethodBeat.o(177648);
        return 2131234445;
      }
      AppMethodBeat.o(177648);
      return 2131234444;
    }
    if (paramInt < 10)
    {
      AppMethodBeat.o(177648);
      return 2131234443;
    }
    AppMethodBeat.o(177648);
    return 2131234442;
  }
  
  public static int kh(Context paramContext)
  {
    AppMethodBeat.i(143282);
    float f = a.dT(paramContext);
    if (Float.compare(f, a.hH(paramContext)) > 0)
    {
      AppMethodBeat.o(143282);
      return 2131234444;
    }
    if (Float.compare(f, a.hF(paramContext)) > 0)
    {
      AppMethodBeat.o(143282);
      return 2131234446;
    }
    AppMethodBeat.o(143282);
    return 2131234442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */