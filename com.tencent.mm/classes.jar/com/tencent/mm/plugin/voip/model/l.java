package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class l
{
  private static l tvD;
  private ReentrantLock bVf;
  private k tvE;
  
  static
  {
    AppMethodBeat.i(4435);
    tvD = new l();
    AppMethodBeat.o(4435);
  }
  
  private l()
  {
    AppMethodBeat.i(4433);
    this.bVf = new ReentrantLock();
    AppMethodBeat.o(4433);
  }
  
  public static k cMn()
  {
    AppMethodBeat.i(4434);
    if (tvD.tvE == null) {
      tvD.bVf.lock();
    }
    try
    {
      if (tvD.tvE == null) {
        tvD.tvE = new k();
      }
      tvD.bVf.unlock();
      k localk = tvD.tvE;
      AppMethodBeat.o(4434);
      return localk;
    }
    finally
    {
      tvD.bVf.unlock();
      AppMethodBeat.o(4434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */