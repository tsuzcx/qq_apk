package com.tencent.mm.plugin.sns.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  implements a
{
  public final int cfL()
  {
    return 11855;
  }
  
  public final void e(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35693);
    switch (paramInt)
    {
    default: 
      ab.e("Kv_11855", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35693);
      return;
    case 0: 
    case 1: 
      h.qsU.e(11855, paramVarArgs);
      AppMethodBeat.o(35693);
      return;
    }
    h.qsU.e(14646, paramVarArgs);
    AppMethodBeat.o(35693);
  }
  
  public final void u(Object... paramVarArgs)
  {
    AppMethodBeat.i(35692);
    e(0, paramVarArgs);
    AppMethodBeat.o(35692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.a.b
 * JD-Core Version:    0.7.0.1
 */