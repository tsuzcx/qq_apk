package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Map;

public final class ex
  implements ec
{
  private final ej a;
  private final boolean b;
  
  public ex(ej paramej, boolean paramBoolean)
  {
    this.a = paramej;
    this.b = paramBoolean;
  }
  
  private eb<?> a(dk paramdk, Type paramType)
  {
    AppMethodBeat.i(147710);
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class))
    {
      paramdk = fd.f;
      AppMethodBeat.o(147710);
      return paramdk;
    }
    paramdk = paramdk.a(fe.a(paramType));
    AppMethodBeat.o(147710);
    return paramdk;
  }
  
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147709);
    Object localObject = paramfe.b();
    if (!Map.class.isAssignableFrom(paramfe.a()))
    {
      AppMethodBeat.o(147709);
      return null;
    }
    localObject = ei.b((Type)localObject, ei.e((Type)localObject));
    eb localeb1 = a(paramdk, localObject[0]);
    eb localeb2 = paramdk.a(fe.a(localObject[1]));
    paramfe = this.a.a(paramfe);
    paramdk = new ex.a(this, paramdk, localObject[0], localeb1, localObject[1], localeb2, paramfe);
    AppMethodBeat.o(147709);
    return paramdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ex
 * JD-Core Version:    0.7.0.1
 */