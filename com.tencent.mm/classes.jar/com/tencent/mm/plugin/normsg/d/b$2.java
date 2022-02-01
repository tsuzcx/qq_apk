package com.tencent.mm.plugin.normsg.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  b$2(b paramb, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(149043);
    this.GyW[0] = b.b(this.GyX, this.fgX, this.GyU, this.jzF);
    synchronized (this.GyW)
    {
      this.GyW[1] = true;
      this.GyW.notifyAll();
      AppMethodBeat.o(149043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.b.2
 * JD-Core Version:    0.7.0.1
 */