package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ff$1
  extends el
{
  public final void a(ff paramff)
  {
    AppMethodBeat.i(147873);
    if ((paramff instanceof ev))
    {
      ((ev)paramff).o();
      AppMethodBeat.o(147873);
      return;
    }
    int j = ff.a(paramff);
    int i = j;
    if (j == 0) {
      i = ff.b(paramff);
    }
    if (i == 13)
    {
      ff.a(paramff, 9);
      AppMethodBeat.o(147873);
      return;
    }
    if (i == 12)
    {
      ff.a(paramff, 8);
      AppMethodBeat.o(147873);
      return;
    }
    if (i == 14)
    {
      ff.a(paramff, 10);
      AppMethodBeat.o(147873);
      return;
    }
    paramff = new IllegalStateException("Expected a name but was " + paramff.f() + "  at line " + ff.c(paramff) + " column " + ff.d(paramff));
    AppMethodBeat.o(147873);
    throw paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ff.1
 * JD-Core Version:    0.7.0.1
 */