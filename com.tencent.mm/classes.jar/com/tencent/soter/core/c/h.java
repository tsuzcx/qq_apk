package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static volatile a ahxf;
  
  static
  {
    AppMethodBeat.i(88671);
    ahxf = new a()
    {
      private boolean ahxg = false;
      
      public final boolean jYh()
      {
        return this.ahxg;
      }
      
      public final void jYi()
      {
        AppMethodBeat.i(88666);
        d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
        this.ahxg = true;
        AppMethodBeat.o(88666);
      }
      
      public final void reset()
      {
        this.ahxg = false;
      }
    };
    AppMethodBeat.o(88671);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(88667);
    ahxf = parama;
    AppMethodBeat.o(88667);
  }
  
  public static void jYg()
  {
    AppMethodBeat.i(88668);
    ahxf.jYi();
    AppMethodBeat.o(88668);
  }
  
  public static boolean jYh()
  {
    AppMethodBeat.i(88669);
    boolean bool = ahxf.jYh();
    AppMethodBeat.o(88669);
    return bool;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(88670);
    ahxf.reset();
    AppMethodBeat.o(88670);
  }
  
  public static abstract interface a
  {
    public abstract boolean jYh();
    
    public abstract void jYi();
    
    public abstract void reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */