package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m ACq;
  private l ACr;
  private ReentrantLock cEu;
  
  static
  {
    AppMethodBeat.i(114940);
    ACq = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.cEu = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l eiE()
  {
    AppMethodBeat.i(114939);
    if (ACq.ACr == null) {
      ACq.cEu.lock();
    }
    try
    {
      if (ACq.ACr == null) {
        ACq.ACr = new l();
      }
      ACq.cEu.unlock();
      l locall = ACq.ACr;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      ACq.cEu.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */