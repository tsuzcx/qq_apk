package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gd<T>
{
  public final T a;
  public final gi b;
  public boolean c = false;
  
  private gd(gi paramgi)
  {
    this.a = null;
    this.b = paramgi;
  }
  
  private gd(T paramT)
  {
    this.a = paramT;
    this.b = null;
  }
  
  public static <T> gd<T> a(gi paramgi)
  {
    AppMethodBeat.i(147986);
    paramgi = new gd(paramgi);
    AppMethodBeat.o(147986);
    return paramgi;
  }
  
  public static <T> gd<T> a(T paramT)
  {
    AppMethodBeat.i(147985);
    paramT = new gd(paramT);
    AppMethodBeat.o(147985);
    return paramT;
  }
  
  public boolean a()
  {
    return this.b == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gd
 * JD-Core Version:    0.7.0.1
 */