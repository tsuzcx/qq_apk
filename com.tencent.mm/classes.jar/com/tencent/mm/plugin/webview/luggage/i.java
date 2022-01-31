package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class i
{
  private static Set<n> uSm;
  
  static
  {
    AppMethodBeat.i(6156);
    uSm = new HashSet();
    AppMethodBeat.o(6156);
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(6154);
    uSm.add(paramn);
    AppMethodBeat.o(6154);
  }
  
  public static void c(n paramn)
  {
    AppMethodBeat.i(6155);
    uSm.remove(paramn);
    AppMethodBeat.o(6155);
  }
  
  public static Set<n> dbp()
  {
    return uSm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i
 * JD-Core Version:    0.7.0.1
 */