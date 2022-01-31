package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collection;

public final class et
  implements ec
{
  private final ej a;
  
  public et(ej paramej)
  {
    this.a = paramej;
  }
  
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147650);
    Type localType = paramfe.b();
    Class localClass = paramfe.a();
    if (!Collection.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(147650);
      return null;
    }
    localType = ei.a(localType, localClass);
    paramdk = new et.a(this, paramdk, localType, paramdk.a(fe.a(localType)), this.a.a(paramfe));
    AppMethodBeat.o(147650);
    return paramdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.et
 * JD-Core Version:    0.7.0.1
 */