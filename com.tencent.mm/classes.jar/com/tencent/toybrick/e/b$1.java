package com.tencent.toybrick.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.d.a.a;
import java.lang.ref.WeakReference;

public final class b$1
  implements Runnable
{
  public b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(113228);
    com.tencent.toybrick.b.b localb = (com.tencent.toybrick.b.b)this.Byd.Byb.get();
    if (localb != null) {
      a.dWP().execute(new b.b(this.Byd, localb.BwX.BxV, localb.BwT, localb.BwS));
    }
    AppMethodBeat.o(113228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.e.b.1
 * JD-Core Version:    0.7.0.1
 */