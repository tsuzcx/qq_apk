package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a VPp;
  
  static
  {
    AppMethodBeat.i(62487);
    VPp = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(62485);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(62485);
      }
    };
    AppMethodBeat.o(62487);
  }
  
  public static void a(a parama)
  {
    VPp = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(62486);
    VPp.loadLibrary("mmudp");
    AppMethodBeat.o(62486);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.a
 * JD-Core Version:    0.7.0.1
 */