package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class k$1
  implements Runnable
{
  k$1(k paramk, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(79216);
    Object localObject = this.vKq.cL();
    this.vKq.handler.post(new k.1.1(this, localObject));
    AppMethodBeat.o(79216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k.1
 * JD-Core Version:    0.7.0.1
 */