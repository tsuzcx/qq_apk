package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a IuN;
  
  static
  {
    AppMethodBeat.i(88671);
    IuN = new a()
    {
      private boolean IuO = false;
      
      public final boolean fnc()
      {
        return this.IuO;
      }
      
      public final void fnd()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.IuO = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.IuO = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    IuN = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void fnb()
  {
    AppMethodBeat.i(88668);
    IuN.fnd();
    AppMethodBeat.o(88668);
  }
  
  public static boolean fnc()
  {
    AppMethodBeat.i(88669);
    boolean bool = IuN.fnc();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    IuN.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean fnc();
    
    public abstract void fnd();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */