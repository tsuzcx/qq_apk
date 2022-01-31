package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class mj<T, S extends mq>
  implements nu.a<md<T, S>>
{
  private final mg<T, S> a;
  private final oe<? super mq, Boolean> b;
  
  mj(mg<T, S> parammg, oe<? super mq, Boolean> paramoe)
  {
    this.a = parammg;
    this.b = paramoe;
  }
  
  public final void a(nx<? super md<T, S>> paramnx)
  {
    AppMethodBeat.i(149308);
    paramnx.a(new mj.a(this.a, this.b, paramnx));
    AppMethodBeat.o(149308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mj
 * JD-Core Version:    0.7.0.1
 */