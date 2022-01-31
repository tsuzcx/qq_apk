package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;

final class n$1
  implements Runnable
{
  n$1(n paramn, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(4738);
    if (this.tzW.callback != null) {
      this.tzW.callback.onSceneEnd(this.val$errType, this.val$errCode, this.ftO, this.tzW);
    }
    AppMethodBeat.o(4738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n.1
 * JD-Core Version:    0.7.0.1
 */