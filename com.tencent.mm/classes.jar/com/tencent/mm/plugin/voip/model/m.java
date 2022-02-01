package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m GWz;
  private l GWA;
  private ReentrantLock dgE;
  
  static
  {
    AppMethodBeat.i(114940);
    GWz = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.dgE = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l fGM()
  {
    AppMethodBeat.i(114939);
    if (GWz.GWA == null) {
      GWz.dgE.lock();
    }
    try
    {
      if (GWz.GWA == null) {
        GWz.GWA = new l();
      }
      GWz.dgE.unlock();
      l locall = GWz.GWA;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      GWz.dgE.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */