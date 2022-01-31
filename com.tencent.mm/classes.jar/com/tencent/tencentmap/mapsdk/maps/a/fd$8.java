package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$8
  extends eb<StringBuilder>
{
  public final StringBuilder a(ff paramff)
  {
    AppMethodBeat.i(147847);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147847);
      return null;
    }
    paramff = new StringBuilder(paramff.h());
    AppMethodBeat.o(147847);
    return paramff;
  }
  
  public final void a(fh paramfh, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(147848);
    if (paramStringBuilder == null) {}
    for (paramStringBuilder = null;; paramStringBuilder = paramStringBuilder.toString())
    {
      paramfh.b(paramStringBuilder);
      AppMethodBeat.o(147848);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.8
 * JD-Core Version:    0.7.0.1
 */