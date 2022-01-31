package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$19
  implements ec
{
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147784);
    paramfe = paramfe.a();
    if ((!Enum.class.isAssignableFrom(paramfe)) || (paramfe == Enum.class))
    {
      AppMethodBeat.o(147784);
      return null;
    }
    paramdk = paramfe;
    if (!paramfe.isEnum()) {
      paramdk = paramfe.getSuperclass();
    }
    paramdk = new fd.a(paramdk);
    AppMethodBeat.o(147784);
    return paramdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.19
 * JD-Core Version:    0.7.0.1
 */