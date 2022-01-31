package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$1
  implements Runnable
{
  h$1(h paramh, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(36230);
    Object localObject = this.rej.cL();
    this.rej.handler.post(new h.1.1(this, localObject));
    AppMethodBeat.o(36230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h.1
 * JD-Core Version:    0.7.0.1
 */