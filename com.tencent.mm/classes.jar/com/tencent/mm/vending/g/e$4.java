package com.tencent.mm.vending.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

final class e$4
  implements a<Void, Void>
{
  e$4(e parame, Pair paramPair, Object paramObject, RuntimeException paramRuntimeException) {}
  
  private Void bFz()
  {
    AppMethodBeat.i(177476);
    try
    {
      ((d.b)this.GwC.first).bz(this.YAG);
      Void localVoid = YAb;
      AppMethodBeat.o(177476);
      return localVoid;
    }
    catch (ClassCastException localClassCastException)
    {
      if (this.YAH.getCause() == null) {
        this.YAH.initCause(localClassCastException);
      }
      RuntimeException localRuntimeException = this.YAH;
      AppMethodBeat.o(177476);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.g.e.4
 * JD-Core Version:    0.7.0.1
 */