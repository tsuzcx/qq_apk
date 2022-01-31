package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class dk$a<T>
  extends eb<T>
{
  private eb<T> a;
  
  public void a(eb<T> parameb)
  {
    AppMethodBeat.i(147464);
    if (this.a != null)
    {
      parameb = new AssertionError();
      AppMethodBeat.o(147464);
      throw parameb;
    }
    this.a = parameb;
    AppMethodBeat.o(147464);
  }
  
  public void a(fh paramfh, T paramT)
  {
    AppMethodBeat.i(147466);
    if (this.a == null)
    {
      paramfh = new IllegalStateException();
      AppMethodBeat.o(147466);
      throw paramfh;
    }
    this.a.a(paramfh, paramT);
    AppMethodBeat.o(147466);
  }
  
  public T b(ff paramff)
  {
    AppMethodBeat.i(147465);
    if (this.a == null)
    {
      paramff = new IllegalStateException();
      AppMethodBeat.o(147465);
      throw paramff;
    }
    paramff = this.a.b(paramff);
    AppMethodBeat.o(147465);
    return paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dk.a
 * JD-Core Version:    0.7.0.1
 */