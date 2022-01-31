package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;

final class es$1
  implements ec
{
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147640);
    paramfe = paramfe.b();
    if ((!(paramfe instanceof GenericArrayType)) && ((!(paramfe instanceof Class)) || (!((Class)paramfe).isArray())))
    {
      AppMethodBeat.o(147640);
      return null;
    }
    paramfe = ei.g(paramfe);
    paramdk = new es(paramdk, paramdk.a(fe.a(paramfe)), ei.e(paramfe));
    AppMethodBeat.o(147640);
    return paramdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.es.1
 * JD-Core Version:    0.7.0.1
 */