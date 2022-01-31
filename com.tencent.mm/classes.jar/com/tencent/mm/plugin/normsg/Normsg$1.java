package com.tencent.mm.plugin.normsg;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class Normsg$1
  implements Runnable
{
  Normsg$1(boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(10253);
    synchronized (this.pgE)
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("wechatxlog");
      System.loadLibrary("wechatnormsg");
      this.pgE[0] = true;
      this.pgE.notifyAll();
      AppMethodBeat.o(10253);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.1
 * JD-Core Version:    0.7.0.1
 */