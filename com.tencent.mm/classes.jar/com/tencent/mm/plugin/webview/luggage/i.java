package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class i
{
  private static Set<n> Cmb;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    Cmb = new HashSet();
    AppMethodBeat.o(78357);
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      Cmb.add(paramn);
      AppMethodBeat.o(78355);
      return;
    }
  }
  
  public static void c(n paramn)
  {
    AppMethodBeat.i(78356);
    synchronized (lock)
    {
      Cmb.remove(paramn);
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static Set<n> eAG()
  {
    AppMethodBeat.i(175738);
    synchronized (lock)
    {
      HashSet localHashSet = new HashSet(Cmb);
      AppMethodBeat.o(175738);
      return localHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i
 * JD-Core Version:    0.7.0.1
 */