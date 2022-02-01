package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m zjG;
  private ReentrantLock cHm;
  private l zjH;
  
  static
  {
    AppMethodBeat.i(114940);
    zjG = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.cHm = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l dTs()
  {
    AppMethodBeat.i(114939);
    if (zjG.zjH == null) {
      zjG.cHm.lock();
    }
    try
    {
      if (zjG.zjH == null) {
        zjG.zjH = new l();
      }
      zjG.cHm.unlock();
      l locall = zjG.zjH;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      zjG.cHm.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */