package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a LQr;
  
  static
  {
    AppMethodBeat.i(88671);
    LQr = new a()
    {
      private boolean LQs = false;
      
      public final boolean fUK()
      {
        return this.LQs;
      }
      
      public final void fUL()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.LQs = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.LQs = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    LQr = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void fUJ()
  {
    AppMethodBeat.i(88668);
    LQr.fUL();
    AppMethodBeat.o(88668);
  }
  
  public static boolean fUK()
  {
    AppMethodBeat.i(88669);
    boolean bool = LQr.fUK();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    LQr.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean fUK();
    
    public abstract void fUL();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */