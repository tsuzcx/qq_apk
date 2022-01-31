package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;

final class fd$10
  extends eb<URL>
{
  public final URL a(ff paramff)
  {
    AppMethodBeat.i(147747);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147747);
      return null;
    }
    paramff = paramff.h();
    if ("null".equals(paramff))
    {
      AppMethodBeat.o(147747);
      return null;
    }
    paramff = new URL(paramff);
    AppMethodBeat.o(147747);
    return paramff;
  }
  
  public final void a(fh paramfh, URL paramURL)
  {
    AppMethodBeat.i(147748);
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toExternalForm())
    {
      paramfh.b(paramURL);
      AppMethodBeat.o(147748);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.10
 * JD-Core Version:    0.7.0.1
 */