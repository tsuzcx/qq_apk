package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  implements a
{
  public final int dHw()
  {
    return 11855;
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94967);
    switch (paramInt)
    {
    default: 
      ae.e("Kv_11855", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(94967);
      return;
    case 0: 
    case 1: 
      g.yxI.f(11855, paramVarArgs);
      AppMethodBeat.o(94967);
      return;
    }
    g.yxI.f(14646, paramVarArgs);
    AppMethodBeat.o(94967);
  }
  
  public final void v(Object... paramVarArgs)
  {
    AppMethodBeat.i(94966);
    f(0, paramVarArgs);
    AppMethodBeat.o(94966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b
 * JD-Core Version:    0.7.0.1
 */