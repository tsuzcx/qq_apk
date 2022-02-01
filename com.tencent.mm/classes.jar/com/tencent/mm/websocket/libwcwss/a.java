package com.tencent.mm.websocket.libwcwss;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a LAQ;
  
  static
  {
    AppMethodBeat.i(3490);
    LAQ = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(3488);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(3488);
      }
    };
    AppMethodBeat.o(3490);
  }
  
  public static void a(a parama)
  {
    LAQ = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(3489);
    LAQ.loadLibrary("mmwcwss");
    AppMethodBeat.o(3489);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.a
 * JD-Core Version:    0.7.0.1
 */