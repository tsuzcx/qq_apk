package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class mh<T, S extends mq>
{
  private final mg<T, S> a;
  private final int b;
  
  mh(mg<T, S> parammg, int paramInt)
  {
    this.a = parammg;
    this.b = paramInt;
  }
  
  final mg<T, S> a()
  {
    return this.a;
  }
  
  final int b()
  {
    return this.b;
  }
  
  final mh<T, S> c()
  {
    AppMethodBeat.i(149298);
    mh localmh = new mh(this.a, this.b + 1);
    AppMethodBeat.o(149298);
    return localmh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mh
 * JD-Core Version:    0.7.0.1
 */