package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile a Mno;
  
  static
  {
    AppMethodBeat.i(88671);
    Mno = new a()
    {
      private boolean Mnp = false;
      
      public final boolean fZj()
      {
        return this.Mnp;
      }
      
      public final void fZk()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.Mnp = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.Mnp = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    Assert.assertNotNull(parama);
    Mno = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void fZi()
  {
    AppMethodBeat.i(88668);
    Mno.fZk();
    AppMethodBeat.o(88668);
  }
  
  public static boolean fZj()
  {
    AppMethodBeat.i(88669);
    boolean bool = Mno.fZj();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    Mno.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean fZj();
    
    public abstract void fZk();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */