package com.tencent.mm.plugin.normsg.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, View paramView, List paramList, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(149042);
    b.b(this.GyX, this.GyU, this.jzF, this.GyV);
    synchronized (this.GyW)
    {
      this.GyW[0] = true;
      this.GyW.notifyAll();
      AppMethodBeat.o(149042);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.b.1
 * JD-Core Version:    0.7.0.1
 */