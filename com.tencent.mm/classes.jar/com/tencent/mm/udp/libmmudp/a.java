package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a adtu;
  
  static
  {
    AppMethodBeat.i(62487);
    adtu = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(62485);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/udp/libmmudp/UdpLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/udp/libmmudp/UdpLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(62485);
      }
    };
    AppMethodBeat.o(62487);
  }
  
  public static void a(a parama)
  {
    adtu = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(62486);
    adtu.loadLibrary("mmudp");
    AppMethodBeat.o(62486);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.a
 * JD-Core Version:    0.7.0.1
 */