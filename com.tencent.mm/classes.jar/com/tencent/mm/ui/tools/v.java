package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class v
{
  public static int aQ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(177648);
    if (Float.compare(a.ez(paramContext), a.iZ(paramContext)) > 0)
    {
      if (paramInt < 10)
      {
        AppMethodBeat.o(177648);
        return 2131235383;
      }
      AppMethodBeat.o(177648);
      return 2131235382;
    }
    if (paramInt < 10)
    {
      AppMethodBeat.o(177648);
      return 2131235381;
    }
    AppMethodBeat.o(177648);
    return 2131235380;
  }
  
  public static int kH(Context paramContext)
  {
    AppMethodBeat.i(143282);
    float f = a.ez(paramContext);
    if (Float.compare(f, a.iZ(paramContext)) > 0)
    {
      AppMethodBeat.o(143282);
      return 2131235382;
    }
    if (Float.compare(f, a.iX(paramContext)) > 0)
    {
      AppMethodBeat.o(143282);
      return 2131235384;
    }
    AppMethodBeat.o(143282);
    return 2131235380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.v
 * JD-Core Version:    0.7.0.1
 */