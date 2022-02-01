package com.tencent.mm.plugin.sns.ad.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements a
{
  public final int dEf()
  {
    return 11855;
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94967);
    switch (paramInt)
    {
    default: 
      ad.e("Kv_11855", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(94967);
      return;
    case 0: 
    case 1: 
      g.yhR.f(11855, paramVarArgs);
      AppMethodBeat.o(94967);
      return;
    }
    g.yhR.f(14646, paramVarArgs);
    AppMethodBeat.o(94967);
  }
  
  public final void w(Object... paramVarArgs)
  {
    AppMethodBeat.i(94966);
    f(0, paramVarArgs);
    AppMethodBeat.o(94966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.b
 * JD-Core Version:    0.7.0.1
 */