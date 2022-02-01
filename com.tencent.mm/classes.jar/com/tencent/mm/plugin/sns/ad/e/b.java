package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements a
{
  public final void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94967);
    switch (paramInt)
    {
    default: 
      Log.e("Kv_11855", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(94967);
      return;
    case 0: 
    case 1: 
      h.OAn.b(11855, paramVarArgs);
      AppMethodBeat.o(94967);
      return;
    }
    h.OAn.b(14646, paramVarArgs);
    AppMethodBeat.o(94967);
  }
  
  public final int getKey()
  {
    return 11855;
  }
  
  public final void x(Object... paramVarArgs)
  {
    AppMethodBeat.i(94966);
    b(0, paramVarArgs);
    AppMethodBeat.o(94966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.b
 * JD-Core Version:    0.7.0.1
 */