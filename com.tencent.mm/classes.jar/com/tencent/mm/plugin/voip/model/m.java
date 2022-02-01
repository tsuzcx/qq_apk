package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m
{
  private static m UzA;
  private l UzB;
  private ReentrantLock bKF;
  
  static
  {
    AppMethodBeat.i(114940);
    UzA = new m();
    AppMethodBeat.o(114940);
  }
  
  private m()
  {
    AppMethodBeat.i(114938);
    this.bKF = new ReentrantLock();
    AppMethodBeat.o(114938);
  }
  
  public static l hWU()
  {
    AppMethodBeat.i(114939);
    if (UzA.UzB == null) {
      UzA.bKF.lock();
    }
    try
    {
      if (UzA.UzB == null) {
        UzA.UzB = new l();
      }
      UzA.bKF.unlock();
      l locall = UzA.UzB;
      AppMethodBeat.o(114939);
      return locall;
    }
    finally
    {
      UzA.bKF.unlock();
      AppMethodBeat.o(114939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */