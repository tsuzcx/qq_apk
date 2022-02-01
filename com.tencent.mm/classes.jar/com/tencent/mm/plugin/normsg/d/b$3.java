package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Runnable
{
  b$3(b paramb, Throwable paramThrowable, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(149044);
    b.b(this.GyX, this.qRD);
    synchronized (this.GyW)
    {
      this.GyW[0] = true;
      this.GyW.notifyAll();
      AppMethodBeat.o(149044);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.b.3
 * JD-Core Version:    0.7.0.1
 */