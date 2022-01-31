package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public final class mb
{
  public static final Comparator<mt<?>> a;
  public static final Comparator<mt<?>> b;
  
  static
  {
    AppMethodBeat.i(149280);
    a = a(me.a);
    b = new mb.1();
    AppMethodBeat.o(149280);
  }
  
  public static <T extends ms> Comparator<ms> a(mv parammv)
  {
    AppMethodBeat.i(149276);
    parammv = a(me.a(parammv));
    AppMethodBeat.o(149276);
    return parammv;
  }
  
  public static <R, T extends Comparable<T>> Comparator<R> a(oe<R, T> paramoe)
  {
    AppMethodBeat.i(149278);
    paramoe = new mb.3(paramoe);
    AppMethodBeat.o(149278);
    return paramoe;
  }
  
  public static <T> Comparator<T> a(Comparator<T>... paramVarArgs)
  {
    AppMethodBeat.i(149279);
    paramVarArgs = new mb.4(paramVarArgs);
    AppMethodBeat.o(149279);
    return paramVarArgs;
  }
  
  public static Comparator<ms> b(mv parammv)
  {
    AppMethodBeat.i(149277);
    parammv = new mb.2(parammv);
    AppMethodBeat.o(149277);
    return parammv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mb
 * JD-Core Version:    0.7.0.1
 */