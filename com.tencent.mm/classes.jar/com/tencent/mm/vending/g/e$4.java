package com.tencent.mm.vending.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

final class e$4
  implements a<Void, Void>
{
  e$4(e parame, Pair paramPair, Object paramObject, RuntimeException paramRuntimeException) {}
  
  private Void ceW()
  {
    AppMethodBeat.i(177476);
    try
    {
      ((d.b)this.MsC.first).onTerminate(this.LiD);
      Void localVoid = aguz;
      AppMethodBeat.o(177476);
      return localVoid;
    }
    catch (ClassCastException localClassCastException)
    {
      if (this.agve.getCause() == null) {
        this.agve.initCause(localClassCastException);
      }
      RuntimeException localRuntimeException = this.agve;
      AppMethodBeat.o(177476);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.g.e.4
 * JD-Core Version:    0.7.0.1
 */