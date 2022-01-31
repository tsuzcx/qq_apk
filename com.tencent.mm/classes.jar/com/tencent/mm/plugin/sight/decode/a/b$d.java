package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class b$d
  implements Runnable
{
  private b$d(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(70240);
    if (b.l(this.qTn).get() == null)
    {
      AppMethodBeat.o(70240);
      return;
    }
    ((View)b.l(this.qTn).get()).startAnimation(b.m(this.qTn));
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.d
 * JD-Core Version:    0.7.0.1
 */