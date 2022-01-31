package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

final class fd$14
  extends eb<UUID>
{
  public final UUID a(ff paramff)
  {
    AppMethodBeat.i(147763);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147763);
      return null;
    }
    paramff = UUID.fromString(paramff.h());
    AppMethodBeat.o(147763);
    return paramff;
  }
  
  public final void a(fh paramfh, UUID paramUUID)
  {
    AppMethodBeat.i(147764);
    if (paramUUID == null) {}
    for (paramUUID = null;; paramUUID = paramUUID.toString())
    {
      paramfh.b(paramUUID);
      AppMethodBeat.o(147764);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.14
 * JD-Core Version:    0.7.0.1
 */