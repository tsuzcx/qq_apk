package com.tencent.mm.tcp.libmmtcp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a adpo;
  
  static
  {
    AppMethodBeat.i(233703);
    adpo = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(233710);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/tcp/libmmtcp/TcpLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/tcp/libmmtcp/TcpLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(233710);
      }
    };
    AppMethodBeat.o(233703);
  }
  
  public static void a(a parama)
  {
    adpo = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(233694);
    adpo.loadLibrary("mmtcp");
    AppMethodBeat.o(233694);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.tcp.libmmtcp.a
 * JD-Core Version:    0.7.0.1
 */