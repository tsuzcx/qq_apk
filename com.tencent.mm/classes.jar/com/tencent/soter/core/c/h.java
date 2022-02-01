package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a RPM;
  
  static
  {
    AppMethodBeat.i(88671);
    RPM = new a()
    {
      private boolean RPN = false;
      
      public final boolean hlu()
      {
        return this.RPN;
      }
      
      public final void hlv()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.RPN = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.RPN = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    RPM = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void hlt()
  {
    AppMethodBeat.i(88668);
    RPM.hlv();
    AppMethodBeat.o(88668);
  }
  
  public static boolean hlu()
  {
    AppMethodBeat.i(88669);
    boolean bool = RPM.hlu();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    RPM.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean hlu();
    
    public abstract void hlv();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */