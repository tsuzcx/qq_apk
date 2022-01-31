package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$2
  implements Runnable
{
  f$2(f paramf, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(10482);
    synchronized (f.a(this.BnJ))
    {
      d locald = (d)f.Qk().get(this.uZD);
      if (locald != null) {
        locald.dVC();
      }
      AppMethodBeat.o(10482);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.f.2
 * JD-Core Version:    0.7.0.1
 */