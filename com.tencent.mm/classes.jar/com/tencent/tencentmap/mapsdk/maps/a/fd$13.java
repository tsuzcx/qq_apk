package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

final class fd$13
  extends eb<InetAddress>
{
  public final InetAddress a(ff paramff)
  {
    AppMethodBeat.i(147759);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147759);
      return null;
    }
    paramff = InetAddress.getByName(paramff.h());
    AppMethodBeat.o(147759);
    return paramff;
  }
  
  public final void a(fh paramfh, InetAddress paramInetAddress)
  {
    AppMethodBeat.i(147760);
    if (paramInetAddress == null) {}
    for (paramInetAddress = null;; paramInetAddress = paramInetAddress.getHostAddress())
    {
      paramfh.b(paramInetAddress);
      AppMethodBeat.o(147760);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.13
 * JD-Core Version:    0.7.0.1
 */