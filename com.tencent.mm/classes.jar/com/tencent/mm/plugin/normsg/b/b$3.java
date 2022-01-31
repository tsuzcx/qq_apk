package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Runnable
{
  b$3(b paramb, Throwable paramThrowable, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(10391);
    b.b(this.phI, this.phJ);
    synchronized (this.phH)
    {
      this.phH[0] = true;
      this.phH.notifyAll();
      AppMethodBeat.o(10391);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.3
 * JD-Core Version:    0.7.0.1
 */