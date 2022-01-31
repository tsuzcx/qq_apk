package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ek$1
  extends eb<T>
{
  private eb<T> f;
  
  ek$1(ek paramek, boolean paramBoolean1, boolean paramBoolean2, dk paramdk, fe paramfe) {}
  
  private eb<T> a()
  {
    AppMethodBeat.i(147584);
    eb localeb = this.f;
    if (localeb != null)
    {
      AppMethodBeat.o(147584);
      return localeb;
    }
    localeb = this.c.a(this.e, this.d);
    this.f = localeb;
    AppMethodBeat.o(147584);
    return localeb;
  }
  
  public void a(fh paramfh, T paramT)
  {
    AppMethodBeat.i(147583);
    if (this.b)
    {
      paramfh.f();
      AppMethodBeat.o(147583);
      return;
    }
    a().a(paramfh, paramT);
    AppMethodBeat.o(147583);
  }
  
  public T b(ff paramff)
  {
    AppMethodBeat.i(147582);
    if (this.a)
    {
      paramff.n();
      AppMethodBeat.o(147582);
      return null;
    }
    paramff = a().b(paramff);
    AppMethodBeat.o(147582);
    return paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ek.1
 * JD-Core Version:    0.7.0.1
 */