package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class mw<T>
  implements Iterable<T>
{
  private static mw<?> c;
  private final T a;
  private final mw<T> b;
  
  static
  {
    AppMethodBeat.i(149358);
    c = new mw();
    AppMethodBeat.o(149358);
  }
  
  public mw()
  {
    this(null, null);
  }
  
  public mw(T paramT, mw<T> parammw)
  {
    this.a = paramT;
    this.b = parammw;
  }
  
  public static <S> mw<S> a()
  {
    return c;
  }
  
  public static <T> mw<T> a(T paramT)
  {
    AppMethodBeat.i(149355);
    paramT = new mw(paramT, a());
    AppMethodBeat.o(149355);
    return paramT;
  }
  
  public final mw<T> b(T paramT)
  {
    AppMethodBeat.i(149356);
    paramT = new mw(paramT, this);
    AppMethodBeat.o(149356);
    return paramT;
  }
  
  public final boolean b()
  {
    return this.a == null;
  }
  
  public final T c()
  {
    return this.a;
  }
  
  public final mw<T> d()
  {
    return this.b;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(149357);
    mw.a locala = new mw.a(this);
    AppMethodBeat.o(149357);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mw
 * JD-Core Version:    0.7.0.1
 */