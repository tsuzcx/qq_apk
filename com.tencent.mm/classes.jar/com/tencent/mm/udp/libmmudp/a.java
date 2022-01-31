package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a.a yTc;
  
  static
  {
    AppMethodBeat.i(96561);
    yTc = new a.1();
    AppMethodBeat.o(96561);
  }
  
  public static void a(a.a parama)
  {
    yTc = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(96560);
    yTc.loadLibrary("mmudp");
    AppMethodBeat.o(96560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.a
 * JD-Core Version:    0.7.0.1
 */