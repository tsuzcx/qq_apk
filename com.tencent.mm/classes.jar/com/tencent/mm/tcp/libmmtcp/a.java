package com.tencent.mm.tcp.libmmtcp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a VLk;
  
  static
  {
    AppMethodBeat.i(195563);
    VLk = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(195557);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(195557);
      }
    };
    AppMethodBeat.o(195563);
  }
  
  public static void a(a parama)
  {
    VLk = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(195560);
    VLk.loadLibrary("mmtcp");
    AppMethodBeat.o(195560);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.tcp.libmmtcp.a
 * JD-Core Version:    0.7.0.1
 */