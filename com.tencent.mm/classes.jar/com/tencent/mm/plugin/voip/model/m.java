package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m NMM;
  private l NMN;
  private ReentrantLock eYl;
  
  static
  {
    AppMethodBeat.i(114940);
    NMM = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.eYl = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l gza()
  {
    AppMethodBeat.i(114939);
    if (NMM.NMN == null) {
      NMM.eYl.lock();
    }
    try
    {
      if (NMM.NMN == null) {
        NMM.NMN = new l();
      }
      NMM.eYl.unlock();
      l locall = NMM.NMN;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      NMM.eYl.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */