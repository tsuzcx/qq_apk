package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m CsQ;
  private l CsR;
  private ReentrantLock cQj;
  
  static
  {
    AppMethodBeat.i(114940);
    CsQ = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.cQj = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l ezW()
  {
    AppMethodBeat.i(114939);
    if (CsQ.CsR == null) {
      CsQ.cQj.lock();
    }
    try
    {
      if (CsQ.CsR == null) {
        CsQ.CsR = new l();
      }
      CsQ.cQj.unlock();
      l locall = CsQ.CsR;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      CsQ.cQj.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */