package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, View paramView, List paramList, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(10389);
    b.b(this.phI, this.phE, this.phF, this.phG);
    synchronized (this.phH)
    {
      this.phH[0] = true;
      this.phH.notifyAll();
      AppMethodBeat.o(10389);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.1
 * JD-Core Version:    0.7.0.1
 */