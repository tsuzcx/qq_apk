package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.sql.Timestamp;
import java.util.Date;

final class fd$15
  implements ec
{
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147771);
    if (paramfe.a() != Timestamp.class)
    {
      AppMethodBeat.o(147771);
      return null;
    }
    paramdk = new fd.15.1(this, paramdk.a(Date.class));
    AppMethodBeat.o(147771);
    return paramdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.15
 * JD-Core Version:    0.7.0.1
 */