package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  b$2(b paramb, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(10390);
    this.phH[0] = b.b(this.phI, this.caF, this.phE, this.phF);
    synchronized (this.phH)
    {
      this.phH[1] = true;
      this.phH.notifyAll();
      AppMethodBeat.o(10390);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.2
 * JD-Core Version:    0.7.0.1
 */