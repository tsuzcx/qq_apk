package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m Cbp;
  private l Cbq;
  private ReentrantLock cPz;
  
  static
  {
    AppMethodBeat.i(114940);
    Cbp = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.cPz = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l ewp()
  {
    AppMethodBeat.i(114939);
    if (Cbp.Cbq == null) {
      Cbp.cPz.lock();
    }
    try
    {
      if (Cbp.Cbq == null) {
        Cbp.Cbq = new l();
      }
      Cbp.cPz.unlock();
      l locall = Cbp.Cbq;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      Cbp.cPz.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */