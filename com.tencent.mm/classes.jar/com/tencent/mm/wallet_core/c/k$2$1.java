package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$2$1
  implements Runnable
{
  k$2$1(k.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(49040);
    if (!this.AWS.AWR.cnz)
    {
      this.AWS.AWR.cnz = true;
      this.AWS.AWR.AWO.onUrlCancel();
    }
    AppMethodBeat.o(49040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k.2.1
 * JD-Core Version:    0.7.0.1
 */