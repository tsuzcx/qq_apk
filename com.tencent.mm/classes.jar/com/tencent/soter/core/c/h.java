package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a Zsr;
  
  static
  {
    AppMethodBeat.i(88671);
    Zsr = new h.1();
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    Zsr = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void ioT()
  {
    AppMethodBeat.i(88668);
    Zsr.ioV();
    AppMethodBeat.o(88668);
  }
  
  public static boolean ioU()
  {
    AppMethodBeat.i(88669);
    boolean bool = Zsr.ioU();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    Zsr.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean ioU();
    
    public abstract void ioV();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */