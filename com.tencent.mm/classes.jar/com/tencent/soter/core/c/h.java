package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a JWw;
  
  static
  {
    AppMethodBeat.i(88671);
    JWw = new a()
    {
      private boolean JWx = false;
      
      public final boolean fDs()
      {
        return this.JWx;
      }
      
      public final void fDt()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.JWx = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.JWx = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    JWw = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void fDr()
  {
    AppMethodBeat.i(88668);
    JWw.fDt();
    AppMethodBeat.o(88668);
  }
  
  public static boolean fDs()
  {
    AppMethodBeat.i(88669);
    boolean bool = JWw.fDs();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    JWw.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean fDs();
    
    public abstract void fDt();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */